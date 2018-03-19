import request from '@/utils/request'

export function getAllByTagId(id, query) {
  return request({
    url: '/admin/blog/article/getAllByTagId/' + id,
    method: 'get',
    params: query
  })
}

export function page(query) {
  return request({
    url: '/admin/blog/article/page',
    method: 'get',
    params: query
  })
}

export function delObj(id) {
  return request({
    url: '/admin/blog/article/delete/' + id,
    method: 'delete'
  })
}

export function addObjVo(obj) {
  return request({
    url: '/admin/blog/article/addVo',
    method: 'post',
    data: obj
  })
}

export function putObj(id, obj) {
  return request({
    url: '/admin/blog/article/put/' + id,
    method: 'put',
    data: obj
  })
}
