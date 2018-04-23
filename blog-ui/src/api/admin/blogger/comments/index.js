import request from '@/utils/request'

export function page(query) {
  return request({
    url: '/admin/blogger/comments/page',
    method: 'get',
    params: query
  })
}

export function showPage(query) {
  return request({
    url: '/admin/blogger/comments/show/pageTree',
    method: 'get',
    params: query
  })
}

export function showAll(query) {
  return request({
    url: '/admin/blogger/comments/show/all',
    method: 'get',
    params: query
  })
}

export function getAll(query) {
  return request({
    url: '/admin/blogger/comments/all',
    method: 'get',
    params: query
  })
}

export function addObj(obj) {
  return request({
    url: '/admin/blogger/comments/add',
    method: 'post',
    data: obj
  })
}

export function getObj(id) {
  return request({
    url: '/admin/blogger/comments/get/' + id,
    method: 'get'
  })
}

export function delObj(id) {
  return request({
    url: '/admin/blogger/comments/delete/' + id,
    method: 'delete'
  })
}

export function putObj(id, obj) {
  return request({
    url: '/admin/blogger/comments/put/' + id,
    method: 'put',
    data: obj
  })
}

export function saveUserRole(obj) {
  return request({
    url: '/admin/blogger/comments/saveUserRole',
    method: 'post',
    data: obj
  })
}

