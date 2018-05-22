import request from '@/utils/request'

export function getAllByTagId(id, query) {
  return request({
    url: '/api/blog/article/getAllByTagId/' + id,
    method: 'get',
    params: query
  })
}

export function page(query) {
  return request({
    url: '/api/blog/article/page',
    method: 'get',
    params: query
  })
}

export function delObj(id) {
  return request({
    url: '/api/blog/article/delete/' + id,
    method: 'delete'
  })
}

export function addObjVo(obj) {
  return request({
    url: '/api/blog/article/addVo',
    method: 'post',
    data: obj
  })
}

export function putObj(id, obj) {
  return request({
    url: '/api/blog/article/put/' + id,
    method: 'put',
    data: obj
  })
}

export function showPage(query) {
  return request({
    url: '/api/blog/article/show/page',
    method: 'get',
    params: query
  })
}

export function getObj(id) {
  return request({
    url: '/api/blog/article/show/get/' + id,
    method: 'get'
  })
}
