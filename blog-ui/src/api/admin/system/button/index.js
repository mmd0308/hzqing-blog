import request from '@/utils/request'

export function page(query) {
  return request({
    url: '/admin/button/page',
    method: 'get',
    params: query
  })
}

export function addObj(obj) {
  return request({
    url: '/admin/button/add',
    method: 'post',
    data: obj
  })
}

export function getButtonByMenuIdOrRoleId(id, obj) {
  return request({
    url: '/admin/button/getButtonByMenuIdOrRoleId/' + id,
    method: 'get',
    params:  obj
  })
}

export function getObj(id) {
  return request({
    url: '/admin/button/get/' + id,
    method: 'get'
  })
}

export function delObj(id) {
  return request({
    url: '/admin/button/delete/' + id,
    method: 'delete'
  })
}

export function putObj(id, obj) {
  return request({
    url: '/admin/button/put/' + id,
    method: 'put',
    data: obj
  })
}
