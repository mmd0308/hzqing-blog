import request from '@/utils/request'

export function page(query) {
  return request({
    url: '/api/bus/diary/page',
    method: 'get',
    params: query
  })
}

export function showAll(query) {
  return request({
    url: '/api/bus/diary/show/all',
    method: 'get',
    params: query
  })
}

export function getAll(query) {
  return request({
    url: '/api/bus/diary/all',
    method: 'get',
    params: query
  })
}

export function addObj(obj) {
  return request({
    url: '/api/bus/diary/add',
    method: 'post',
    data: obj
  })
}

export function getObj(id) {
  return request({
    url: '/api/bus/diary/get/' + id,
    method: 'get'
  })
}

export function delObj(id) {
  return request({
    url: '/api/bus/diary/delete/' + id,
    method: 'delete'
  })
}

export function putObj(id, obj) {
  return request({
    url: '/api/bus/diary/put/' + id,
    method: 'put',
    data: obj
  })
}

export function saveUserRole(obj) {
  return request({
    url: '/api/bus/diary/saveUserRole',
    method: 'post',
    data: obj
  })
}

