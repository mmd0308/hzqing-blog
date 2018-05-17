import router from './router'
import store from './store'
import NProgress from 'nprogress' // Progress 进度条
import 'nprogress/nprogress.css'// Progress 进度条样式
// import { Message } from 'element-ui'
import { getToken } from '@/utils/auth' // 验权

const whiteList = ['/index', '/write', '/login', '/', '/detail', '/message', '/about', '/diary', '/works', '/blog'] // 不重定向白名单
router.beforeEach((to, from, next) => {
  NProgress.start()
  if (getToken()) { // 如果token存在
    console.log('token 存在 ' + getToken())
    console.log('路径 ：  ' + to.path)
    if (to.path === '/login') {
      next({ path: '/manager' })
    } else {
      if (store.getters.roles.length === 0) { // 如果没有角色，获取用户信息
        store.dispatch('GetUserInfo').then(res => { // 拉取用户信息
          next()
        }).catch(() => {
          store.dispatch('FedLogOut').then(() => {
            // Message.error('验证失败,请重新登录')
            console.log('验证失败,请重新登录')
            next({ path: '/login' })
          })
        })
      } else {
        next()
      }
    }
  } else { // 如果token不存在
    if (whiteList.indexOf(to.path) !== -1) { // 白名单中是否存在
      next()
    } else {
      console.log('-----permission token 不存在 不再白名单')
      next('/index') // 如果没有权限，直接返回首页面
      NProgress.done()
    }
  }
})
router.afterEach(() => {
  NProgress.done() // 结束Progress
})
