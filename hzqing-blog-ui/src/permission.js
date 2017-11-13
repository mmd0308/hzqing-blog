import router from './router'
import store from './store'
import NProgress from 'nprogress' // Progress 进度条
import 'nprogress/nprogress.css'// Progress 进度条样式
import { Message } from 'element-ui'
import { getToken } from '@/utils/auth' // 验权

const whiteList = ['/login','/','/index','/details','/admin','/admin/dashboard','/system','/system/user'] // 不重定向白名单
router.beforeEach((to, from, next) => {
  NProgress.start()
  if (getToken()) {  //获取tocken 是否登陆
    if (to.path === '/login') { //如果已经登陆,直接进入/admin后台系统
      next({ path: '/admin' })
    } else {
      if (store.getters.roles.length === 0) {  //获取用户角色
        store.dispatch('GetInfo').then(res => { // 拉取用户信息
          const roles = res.roles
          debugger
          next()
        }).catch(() => {
          // 前端退出登陆
          store.dispatch('FedLogOut').then(() => {
            Message.error('验证失败,请重新登录')
            next({ path: '/login' })
          })
        })
      } else {
        next()
      }
    }
  } else {
    if (whiteList.indexOf(to.path) !== -1) {
      next()
    } else {
      next('/login')
      NProgress.done()
    }
  }
})

router.afterEach(() => {
  NProgress.done() // 结束Progress
})
