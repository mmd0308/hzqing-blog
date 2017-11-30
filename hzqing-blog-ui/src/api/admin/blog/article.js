import fetch from '@/utils/fetch'


export function page(query) {
  return fetch({
    url: '/admin/blog/article/page',
    method: 'get',
    params: query
  })
}

export function pageIndex(query) {
  return fetch({
    url: '/admin/blog/article/pageIndex',
    method: 'get',
    params: query
  })
}

export function pageByCid(query) {
  return fetch({
    url: '/admin/blog/article/pageByCid',
    method: 'get',
    params: query
  })
}

export function addObj(obj) {
  return fetch({
    url: '/admin/blog/article/saveOrUpdate',
    method: 'post',
    data: obj
  })
}

export function getObj(id) {
  return fetch({
    url: '/admin/blog/article/get/' + id,
    method: 'get'
  })
}

export function getCateByAid(id) {
  return fetch({
    url: '/admin/blog/article/getCateByAid/' + id,
    method: 'get'
  })
}

export function delObj(id) {
  return fetch({
    url: '/admin/blog/article/delete/' + id,
    method: 'delete'
  })
}

export function putObj(id, obj) {
  return fetch({
    url: '/admin/blog/article/put/' + id,
    method: 'put',
    data: obj
  })
}

export function saveUserRole(obj) {
  return fetch({
    url: '/admin/blog/article/saveUserRole',
    method: 'post',
    data: obj
  })
}

