import request from '@/utils/request'

export function page(query) {
  return request({
    url: '/admin/blogger/diary/page',
    method: 'get',
    params: query
  })
}

export function showAll(query) {
  return request({
    url: '/admin/blogger/diary/show/all',
    method: 'get',
    params: query
  })
}

export function getAll(query) {
  return request({
    url: '/admin/blogger/diary/all',
    method: 'get',
    params: query
  })
}

export function addObj(obj) {
  return request({
    url: '/admin/blogger/diary/add',
    method: 'post',
    data: obj
  })
}

export function getObj(id) {
  return request({
    url: '/admin/blogger/diary/get/' + id,
    method: 'get'
  })
}

export function delObj(id) {
  return request({
    url: '/admin/blogger/diary/delete/' + id,
    method: 'delete'
  })
}

export function putObj(id, obj) {
  return request({
    url: '/admin/blogger/diary/put/' + id,
    method: 'put',
    data: obj
  })
}

export function saveUserRole(obj) {
  return request({
    url: '/admin/blogger/diary/saveUserRole',
    method: 'post',
    data: obj
  })
}

