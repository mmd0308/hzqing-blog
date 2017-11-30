import fetch from '@/utils/fetch'


export function getVisitNum() {
  return fetch({
    url: '/admin/blog/visit/getVisitNum',
    method: 'get'
  })
}

export function getVisitNumByAId(id) {
  return fetch({
    url: '/admin/blog/visit/getVisitNumByAId/' + id,
    method: 'get'
  })
}

export function getSupportNumByAId(id) {
  return fetch({
    url: '/admin/blog/visit/getSupportNumByAId/' + id,
    method: 'get'
  })
}

export function saveSupport(id) {
  return fetch({
    url: '/admin/blog/visit/saveSupport/' + id,
    method: 'post'
  })
}

export function deleSupport(id) {
  return fetch({
    url: '/admin/blog/visit/delete/' + id,
    method: 'delete'
  })
}

