import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

import Layout from '../views/manager/layout/Layout'
import ShowIndexLayout from '../views/show/indexLayout/Layout'


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
      },
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

  { 
    path: '/login',
    component: () => import('@/views/manager/login/index'),
    hidden: true
  },
  { 
    path: '/404',
    component: () => import('@/views/404'),
    hidden: true
  },
  {
    path: '',
    component: Layout,
    name: 'managerIndex',
    children: [{
      path: 'managerIndex',
      meta: { title: 'Weclome', icon: 'example' },
      component: () => import('@/views/manager/dashboard/index')
    }]
  },
  {
    path: '',
    component: Layout,
    children: [
      {
        path: 'icon',
        name: 'Icon',
        component: () => import('@/views/manager/svg-icons/index'),
        meta: { title: '图标管理', icon: 'admin-comment' }
      }
    ]
  }
]

export default new Router({
  mode: 'history', // 后端支持可开
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRouterMap
})

export const asyncRouterMap = [
  
  {
    path: '',
    component: Layout,
    name: 'Blog',
    meta: { title: '博客管理', icon: 'admin-blog' },
    children: [
      {
        path: 'blogWrite',
        name: 'Write',
        redirect: '/write',
        meta: { title: '写文章', icon: 'admin-blog-write' },
        code: 'MENU_ADMIN_AUTH_WRITE'
      },
      {
        path: 'blogArticle',
        name: 'Article',
        component: () => import('@/views/manager/blog/article/Index'),
        meta: { title: '文章管理', icon: 'table' },
        code: 'MENU_ADMIN_AUTH_ARTICLE'
      },
      {
        path: 'blogTag',
        name: 'Tag',
        component: () => import('@/views/manager/blog/tag/index'),
        meta: { title: '标签管理', icon: 'admin-blog-tag' },
        code: 'MENU_ADMIN_AUTH_TAG'
      }
    ]
  },
  { 
    path: '/write',
    component: () => import('@/views/manager/blog/write/Index'),
    hidden: true,
    code: 'MENU_ADMIN_AUTH_WRITE'
  },
  {
    path: '',
    component: Layout,
    children: [
      {
        path: 'bloggerDiary',
        name: 'Diary',
        component: () => import('@/views/manager/blogger/diary/index'),
        meta: { title: '个人日记', icon: 'admin-comment' },
        code: 'MENU_ADMIN_AUTH_DIARY'
      }
    ]
  },
  {
    path: '',
    component: Layout,
    children: [
      {
        path: 'bloggerMe',
        name: 'me',
        component: () => import('@/views/manager/system/user/index'),
        meta: { title: '关于我', icon: 'admin-comment' },
        code: 'MENU_ADMIN_AUTH_ABLOUT_ME'
      }
    ]
  },
  {
    path: '',
    component: Layout,
    children: [
      {
        path: 'busWorks',
        name: 'Works',
        component: () => import('@/views/manager/bus/works/index'),
        meta: { title: '作品管理', icon: 'admin-comment' },
        code: 'MENU_ADMIN_AUTH_WORKS'
      }
    ]
  },
  {
    path: '',
    component: Layout,
    children: [
      {
        path: 'busLink',
        name: 'Link',
        component: () => import('@/views/manager/bus/link/index'),
        meta: { title: '友情链接', icon: 'admin-comment' },
        code: 'MENU_ADMIN_AUTH_LINKS'
      }
    ]
  },
  {
    path: '',
    component: Layout,
    name: 'System',
    meta: { title: '系统管理', icon: 'admin-system' },
    children: [
      {
        path: 'sysUser',
        name: 'User',
        component: () => import('@/views/manager/system/user/index'),
        meta: { title: '用户管理', icon: 'user' },
        code: 'MENU_ADMIN_AUTH_USER'
      },
      {
        path: 'sysRole',
        name: 'Role',
        component: () => import('@/views/manager/system/role/index'),
        meta: { title: '角色管理', icon: 'tree' },
        code: 'MENU_ADMIN_AUTH_ROLE'
      },
      {
        path: 'sysMenu',
        name: 'Menu',
        component: () => import('@/views/manager/system/menu/index'),
        meta: { title: '资源管理', icon: 'tree' },
        code: 'MENU_ADMIN_AUTH_MENU'
      },
      {
        path: 'sysDict',
        name: 'Dict',
        component: () => import('@/views/manager/system/dict/index'),
        meta: { title: '数据字典管理', icon: 'tree' },
        code: 'MENU_ADMIN_AUTH_DICT'
      }
    ]
  },
  { path: '*', redirect: '/index', hidden: true }
]
