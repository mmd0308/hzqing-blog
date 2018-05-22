import request from '@/utils/request'

export function page(query) {
  return request({
    url: '/api/blog/tag/page',
    method: 'get',
    params: query
  })
}

export function getAll(query) {
  return request({
    url: '/api/blog/tag/all',
    method: 'get',
    params: query
  })
}

export function showAll(query) {
  return request({
    url: '/api/blog/tag/show/all',
    method: 'get',
    params: query
  })
}

export function addObj(obj) {
  return request({
    url: '/api/blog/tag/add',
    method: 'post',
    data: obj
  })
}

export function getObj(id) {
  return request({
    url: '/api/blog/tag/get/' + id,
    method: 'get'
  })
}

export function delObj(id) {
  return request({
    url: '/api/blog/tag/delete/' + id,
    method: 'delete'
  })
}

export function putObj(id, obj) {
  return request({
    url: '/api/blog/tag/put/' + id,
    method: 'put',
    data: obj
  })
}

export function saveUserRole(obj) {
  return request({
    url: '/api/blog/tag/saveUserRole',
    method: 'post',
    data: obj
  })
}

