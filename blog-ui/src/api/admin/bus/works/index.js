import request from '@/utils/request'

export function page(query) {
  return request({
    url: '/admin/bus/works/page',
    method: 'get',
    params: query
  })
}

export function showAll(query) {
  return request({
    url: '/admin/bus/works/show/all',
    method: 'get',
    params: query
  })
}

export function getAll(query) {
  return request({
    url: '/admin/bus/works/all',
    method: 'get',
    params: query
  })
}

export function addObj(obj) {
  return request({
    url: '/admin/bus/works/add',
    method: 'post',
    data: obj
  })
}

export function getObj(id) {
  return request({
    url: '/admin/bus/works/get/' + id,
    method: 'get'
  })
}

export function delObj(id) {
  return request({
    url: '/admin/bus/works/delete/' + id,
    method: 'delete'
  })
}

export function putObj(id, obj) {
  return request({
    url: '/admin/bus/works/put/' + id,
    method: 'put',
    data: obj
  })
}

export function saveUserRole(obj) {
  return request({
    url: '/admin/bus/works/saveUserRole',
    method: 'post',
    data: obj
  })
}

