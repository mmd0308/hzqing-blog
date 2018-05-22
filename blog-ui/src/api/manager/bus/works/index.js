import request from '@/utils/request'

export function page(query) {
  return request({
    url: '/api/bus/works/page',
    method: 'get',
    params: query
  })
}

export function showAll(query) {
  return request({
    url: '/api/bus/works/show/all',
    method: 'get',
    params: query
  })
}

export function getAll(query) {
  return request({
    url: '/api/bus/works/all',
    method: 'get',
    params: query
  })
}

export function addObj(obj) {
  return request({
    url: '/api/bus/works/add',
    method: 'post',
    data: obj
  })
}

export function getObj(id) {
  return request({
    url: '/api/bus/works/get/' + id,
    method: 'get'
  })
}

export function delObj(id) {
  return request({
    url: '/api/bus/works/delete/' + id,
    method: 'delete'
  })
}

export function putObj(id, obj) {
  return request({
    url: '/api/bus/works/put/' + id,
    method: 'put',
    data: obj
  })
}

export function saveUserRole(obj) {
  return request({
    url: '/api/bus/works/saveUserRole',
    method: 'post',
    data: obj
  })
}

