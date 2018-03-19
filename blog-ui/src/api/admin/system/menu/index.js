import request from '@/utils/request'

export function tree(id) {
  return request({
    url: '/admin/menu/tree/' + id,
    method: 'get'
  })
}

export function getNextLevelCode(id, lcode) {
  return request({
    url: '/admin/menu/getNextLevelCode/' + id + '/' + lcode,
    method: 'get'
  })
}

export function page(query) {
  return request({
    url: '/admin/user/page',
    method: 'get',
    params: query
  })
}

export function addObj(obj) {
  return request({
    url: '/admin/menu/add',
    method: 'post',
    data: obj
  })
}

export function getObj(id) {
  return request({
    url: '/admin/user/get/' + id,
    method: 'get'
  })
}

export function delObj(id) {
  return request({
    url: '/admin/menu/delete/' + id,
    method: 'delete'
  })
}

export function putObj(id, obj) {
  return request({
    url: '/admin/menu/put/' + id,
    method: 'put',
    data: obj
  })
}

export function saveUserRole(obj) {
  return request({
    url: '/admin/user/saveUserRole',
    method: 'post',
    data: obj
  })
}

