import fetch from '@/utils/fetch'

export function login(username, password) {
  return fetch({
    url: '/admin/user/login',
    method: 'post',
    data: {
      username,
      password
    }
  })
}

export function getInfo(token) {
  return fetch({
    url: '/admin/user/getUserinfo',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return fetch({
    url: '/admin/user/logout',
    method: 'post'
  })
}
