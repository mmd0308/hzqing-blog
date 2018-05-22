import request from '@/utils/request'

export function page(query) {
  return request({
    url: '/api/bus/link/page',
    method: 'get',
    params: query
  })
}

export function showAll(query) {
  return request({
    url: '/api/bus/link/show/all',
    method: 'get',
    params: query
  })
}

export function getAll(query) {
  return request({
    url: '/api/bus/link/all',
    method: 'get',
    params: query
  })
}

export function addObj(obj) {
  return request({
    url: '/api/bus/link/add',
    method: 'post',
    data: obj
  })
}

export function getObj(id) {
  return request({
    url: '/api/bus/link/get/' + id,
    method: 'get'
  })
}

export function delObj(id) {
  return request({
    url: '/api/bus/link/delete/' + id,
    method: 'delete'
  })
}

export function putObj(id, obj) {
  return request({
    url: '/api/bus/link/put/' + id,
    method: 'put',
    data: obj
  })
}

export function saveUserRole(obj) {
  return request({
    url: '/api/bus/link/saveUserRole',
    method: 'post',
    data: obj
  })
}

