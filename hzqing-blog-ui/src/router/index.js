import Vue from 'vue'
import Router from 'vue-router'
const _import = require('./_import_' + process.env.NODE_ENV)
// in development env not use Lazy Loading,because Lazy Loading too many pages will cause webpack hot update too slow.so only in production use Lazy Loading

/* layout */
import Layout from '../views/admin/layout/Layout'

Vue.use(Router)

/**
* icon : the icon show in the sidebar
* hidden : if `hidden:true` will not show in the sidebar
* redirect : if `redirect:noredirect` will not redirct in the levelbar
* noDropdown : if `noDropdown:true` will not has submenu in the sidebar
* meta : `{ role: ['admin'] }`  will control the page role
**/
export const constantRouterMap = [
  { path: '/login', component: _import('admin/login/index'), hidden: true },
  { path: '/404', component: _import('404'), hidden: true },
  { 
    path: '/', 
    component:_import('show/layout/Layout'), 
    hidden:true,
    redirect: '/index',
    children: [
      { path: 'index', component: _import('show/layout/AppMain'), hidden:true    },
      { path: 'details', component: _import('show/blog/Details'), hidden:true    }
  ]
  }
]

export default new Router({
  // mode: 'history', //后端支持可开
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRouterMap
})

export const asyncRouterMap = [

  {
    path: '/admin',
    component: Layout,
    redirect: '/admin/dashboard',
    name: 'Dashboard',
    hidden: true,
    children: [{ path: 'dashboard', component: _import('admin/dashboard/index') }]
  },
  {
    path: '/blog',
    component: Layout,
    redirect: 'noredirect',
    name: '博客管理',
    icon: 'zujian',
    children: [
      { path: 'write', name: '新增博客', icon: 'zonghe', component: _import('admin/blog/blog') },
      { path: 'article', name: '文章管理', icon: 'zonghe', component: _import('admin/blog/article') },
      { path: 'category', name: '类别管理', icon: 'zonghe', component: _import('admin/blog/category') },
      { path: 'comment', name: '评论管理', icon: 'zonghe', component: _import('admin/blog/comment') },
      { path: 'drafts', name: '草稿箱', icon: 'zonghe', component: _import('admin/page/form') },
      { path: 'recycle', name: '回收站', icon: 'zonghe', component: _import('admin/page/form') }
    ]
  },
  {
    path: '/system',
    component: Layout,
    redirect: 'noredirect',
    name: '系统管理',
    icon: 'zujian',
    children: [
      { path: 'user', name: '用户管理', icon: 'zonghe', component: _import('admin/system/user/index') },
      { path: 'role', name: '角色管理', icon: 'zonghe', component: _import('admin/system/role/index') },
      { path: 'menu', name: '菜单管理', icon: 'zonghe', component: _import('admin/system/menu/index') }
    ]
  },
  {
    path: '/table',
    component: Layout,
    redirect: '/table/index',
    icon: 'tubiao',
    noDropdown: true,
    children: [{ path: 'index', name: 'Table', component: _import('admin/table/index'), meta: { role: ['admin'] }}]
  },

  { path: '*', redirect: '/404', hidden: true }
]


