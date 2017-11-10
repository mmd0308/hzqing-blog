import fetch from '@/utils/fetch'

export function page(query) {
  return fetch({
    url: '/admin/user/page',
    method: 'get',
    params: query
  })
}

export function addObj(obj) {
  return fetch({
    url: '/admin/user/add',
    method: 'post',
    data: obj
  })
}

export function getObj(id) {
  return fetch({
    url: '/admin/user/get/' + id,
    method: 'get'
  })
}

export function delObj(id) {
  return fetch({
    url: '/admin/user/delete/' + id,
    method: 'delete'
  })
}

export function putObj(id, obj) {
  return fetch({
    url: '/admin/user/put/' + id,
    method: 'put',
    data: obj
  })
}

export function saveUserRole(obj) {
  return fetch({
    url: '/admin/user/saveUserRole',
    method: 'post',
    data: obj
  })
}

