import request from '@/utils/request'

export function page(query) {
  return request({
    url: '/admin/blog/tag/page',
    method: 'get',
    params: query
  })
}

export function getAll(query) {
  return request({
    url: '/admin/blog/tag/all',
    method: 'get',
    params: query
  })
}

export function addObj(obj) {
  return request({
    url: '/admin/blog/tag/add',
    method: 'post',
    data: obj
  })
}

export function getObj(id) {
  return request({
    url: '/admin/blog/tag/get/' + id,
    method: 'get'
  })
}

export function delObj(id) {
  return request({
    url: '/admin/blog/tag/delete/' + id,
    method: 'delete'
  })
}

export function putObj(id, obj) {
  return request({
    url: '/admin/blog/tag/put/' + id,
    method: 'put',
    data: obj
  })
}

export function saveUserRole(obj) {
  return request({
    url: '/admin/blog/tag/saveUserRole',
    method: 'post',
    data: obj
  })
}

