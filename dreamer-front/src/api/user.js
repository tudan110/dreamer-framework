import http from '@/axios/api.request';

const user = {};

user.listUsers = () => {
  return http.request({
    url: 'user/',
    method: 'get'
  })
};

user.addUser = (param) => {
  return http.request({
    url: 'user/',
    method: 'post',
    params: param
  })
};

user.updateUser = (param) => {
  return http.request({
    url: 'user/',
    method: 'put',
    params: param
  })
};

user.deleteUser = (param) => {
  return http.request({
    url: 'user/',
    method: 'delete',
    params: {
      id: param
    }
  })
};

export default user;