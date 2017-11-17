import router from './router'
import store from './store'
import NProgress from 'nprogress' // Progress 进度条
import 'nprogress/nprogress.css'// Progress 进度条样式
import { Message } from 'element-ui'
import { getToken } from '@/utils/auth' // 验权

const whiteList = ['/login','/','/index','/details'] // 不重定向白名单
router.beforeEach((to, from, next) => {
  NProgress.start()
  if (getToken()) {  //获取tocken 是否登陆
    if (to.path === '/login') { //如果已经登陆,直接进入/admin后台系统
      next({ path: '/admin' })
    } else {
      if (store.getters.roles.length === 0) {  // 判断当前用户是否已拉取完user_info信息 获取用户的角色信息
        store.dispatch('GetInfo').then(res => { // 拉取用户信息
          const roles = res.data.roles
          const menus = res.data.menus
          debugger
          if(roles.length !=0 && menus.length !=0){
            store.dispatch('GenerateRoutes', { menus, roles }).then(() => { // 生成可访问的路由表
              console.log(store.getters.addRouters)
              router.addRoutes(store.getters.addRouters) // 动态添加可访问路由表
              next({ ...to }) // hack方法 确保addRoutes已完成
            })
          }else{
            // 无权限
            store.dispatch('FedLogOut').then(() => {
              Message.error('您没有登陆权限，等联系管员。')
              next({ path: '/login' })
            })
          }
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
