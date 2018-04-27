import Vue from 'vue'
import Router from 'vue-router'

// in development-env not use lazy-loading, because lazy-loading too many pages will cause webpack hot update too slow. so only in production use lazy-loading;
// detail: https://panjiachen.github.io/vue-element-admin-site/#/lazy-loading

Vue.use(Router)

/* Layout */
import Layout from '../views/admin/layout/Layout'
import ShowIndexLayout from '../views/show/indexLayout/Layout'

/**
* hidden: true                   if `hidden:true` will not show in the sidebar(default is false)
* alwaysShow: true               if set true, will always show the root menu, whatever its child routes length
*                                if not set alwaysShow, only more than one route under the children
*                                it will becomes nested mode, otherwise not show the root menu
* redirect: noredirect           if `redirect:noredirect` will no redirct in the breadcrumb
* name:'router-name'             the name is used by <keep-alive> (must set!!!)
* meta : {
    title: 'title'               the name show in submenu and breadcrumb (recommend set)
    icon: 'svg-name'             the icon show in the sidebar,
  }
**/
export const constantRouterMap = [
  {
    path: '/',
    component: ShowIndexLayout,
    redirect: '/index',
    name: 'Index',
    hidden: true,
    children: [
      {
        path: 'index',
        component: () => import('@/views/show/indexLayout/AppMain')
      },
      {
        path: 'detail',
        component: () => import('@/views/show/detail/Index')
      },
      {
        path: 'works',
        component: () => import('@/views/show/works/Index')
      },,
      {
        path: 'about',
        component: () => import('@/views/show/about/Index')
      },
      {
        path: 'diary',
        component: () => import('@/views/show/diary/Index')
      },
      {
        path: 'message',
        component: () => import('@/views/show/message/Index')
      },
      {
        path: 'blog',
        component: () => import('@/views/show/blog/index')
      },
      {
        path: 'setting',
        component: () => import('@/views/show/set/index')
      }
    ]
  },
  { path: '/write', component: () => import('@/views/admin/blog/write/Index'), hidden: true },
  { path: '/login', component: () => import('@/views/admin/login/index'), hidden: true },
  { path: '/404', component: () => import('@/views/404'), hidden: true },
  {
    path: '/admin',
    component: Layout,
    redirect: '/admin/index',
    name: 'Index',
    children: [{
      path: 'index',
      meta: { title: 'Weclome', icon: 'example' },
      component: () => import('@/views/admin/dashboard/index')
    }]
  },
  {
    path: '/blog',
    component: Layout,
    redirect: '/blog/article',
    name: 'Blog',
    meta: { title: '博客管理', icon: 'admin-blog' },
    children: [
      {
        path: 'write',
        name: 'Write',
        redirect: '/write',
        meta: { title: '写文章', icon: 'admin-blog-write' }
      },
      {
        path: 'article',
        name: 'Article',
        component: () => import('@/views/admin/blog/article/Index'),
        meta: { title: '文章管理', icon: 'table' }
      },
      {
        path: 'tag',
        name: 'Tag',
        component: () => import('@/views/admin/blog/tag/index'),
        meta: { title: '标签管理', icon: 'admin-blog-tag' }
      }
    ]
  },
  {
    path: '/system',
    component: Layout,
    redirect: '/system/user',
    name: 'System',
    meta: { title: '系统管理', icon: 'admin-system' },
    children: [
      {
        path: 'user',
        name: 'User',
        component: () => import('@/views/admin/system/user/index'),
        meta: { title: '用户管理', icon: 'user' }
      },
      {
        path: 'role',
        name: 'Role',
        component: () => import('@/views/admin/system/role/index'),
        meta: { title: '角色管理', icon: 'tree' }
      },
      {
        path: 'menu',
        name: 'Menu',
        component: () => import('@/views/admin/system/menu/index'),
        meta: { title: '资源管理', icon: 'tree' }
      }
    ]
  },
  {
    path: '/comment',
    component: Layout,
    redirect: '/comment/user',
    name: 'Comment',
    meta: { title: '评论管理', icon: 'admin-comment' },
    children: [
      {
        path: 'user',
        name: 'User',
        component: () => import('@/views/admin/system/user/index'),
        meta: { title: '用户管理', icon: 'table' }
      },
      {
        path: 'role',
        name: 'Role',
        component: () => import('@/views/tree/index'),
        meta: { title: '角色管理', icon: 'tree' }
      }
    ]
  },
  {
    path: '/blogger',
    component: Layout,
    redirect: '/blogger/me',
    name: 'Blogger',
    meta: { title: '博主管理', icon: 'admin-comment' },
    children: [
      {
        path: 'diary',
        name: 'Diary',
        component: () => import('@/views/admin/blogger/diary/index'),
        meta: { title: '个人日记', icon: 'admin-comment' }
      },
      {
        path: 'me',
        name: 'me',
        component: () => import('@/views/admin/system/user/index'),
        meta: { title: '关于我', icon: 'admin-comment' }
      }
    ]
  },
  {
    path: '/bus',
    component: Layout,
    redirect: '/bus/link',
    name: 'Bus',
    meta: { title: '博客管理', icon: 'admin-comment' },
    children: [
      {
        path: 'works',
        name: 'Works',
        component: () => import('@/views/admin/bus/works/index'),
        meta: { title: '作品管理', icon: 'admin-comment' }
      },
      {
        path: 'link',
        name: 'Link',
        component: () => import('@/views/admin/bus/link/index'),
        meta: { title: '友情链接', icon: 'admin-comment' }
      }
    ]
  },
  { path: '*', redirect: '/index', hidden: true }
]

export default new Router({
  // mode: 'history', //后端支持可开
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRouterMap
})

