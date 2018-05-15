import request from '@/utils/request'

export function page(query) {
  return request({
    url: '/admin/bus/link/page',
    method: 'get',
    params: query
  })
}

export function showAll(query) {
  return request({
    url: '/admin/bus/link/show/all',
    method: 'get',
    params: query
  })
}

export function getAll(query) {
  return request({
    url: '/admin/bus/link/all',
    method: 'get',
    params: query
  })
}

export function addObj(obj) {
  return request({
    url: '/admin/bus/link/add',
    method: 'post',
    data: obj
  })
}

export function getObj(id) {
  return request({
    url: '/admin/bus/link/get/' + id,
    method: 'get'
  })
}

export function delObj(id) {
  return request({
    url: '/admin/bus/link/delete/' + id,
    method: 'delete'
  })
}

export function putObj(id, obj) {
  return request({
    url: '/admin/bus/link/put/' + id,
    method: 'put',
    data: obj
  })
}

export function saveUserRole(obj) {
  return request({
    url: '/admin/bus/link/saveUserRole',
    method: 'post',
    data: obj
  })
}

