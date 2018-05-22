import request from '@/utils/request'

export function page(query) {
  return request({
    url: '/api/bus/comments/page',
    method: 'get',
    params: query
  })
}

export function showPage(query) {
  return request({
    url: '/api/bus/comments/show/pageTree',
    method: 'get',
    params: query
  })
}

export function showAll(query) {
  return request({
    url: '/api/bus/comments/show/all',
    method: 'get',
    params: query
  })
}

export function getAll(query) {
  return request({
    url: '/api/bus/comments/all',
    method: 'get',
    params: query
  })
}

export function addObj(obj) {
  return request({
    url: '/api/bus/comments/add',
    method: 'post',
    data: obj
  })
}

export function getObj(id) {
  return request({
    url: '/api/bus/comments/get/' + id,
    method: 'get'
  })
}

export function delObj(id) {
  return request({
    url: '/api/bus/comments/delete/' + id,
    method: 'delete'
  })
}

export function putObj(id, obj) {
  return request({
    url: '/api/bus/comments/put/' + id,
    method: 'put',
    data: obj
  })
}

export function saveUserRole(obj) {
  return request({
    url: '/api/bus/comments/saveUserRole',
    method: 'post',
    data: obj
  })
}

