import request from '@/utils/request'

export function login(username, password) {
  return request({
    url: '/admin/user/login',
    method: 'post',
    params: {
      username,
      password
    }
  })
}

export function getUserInfo(token) {
  return request({
    url: '/admin/user/getUserinfo',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/admin/user/logout',
    method: 'post'
  })
}
