import Env from './env';

let root = 'http://localhost:8888/';//网关地址
let zfz_user = root + 'zfz-user/';//用户服务地址
let zfz_wealth = root + 'zfz-wealth/';//财务服务地址

let config = {
    env: Env,
    url:{
      server:{
          zfz_user:{
              root:zfz_user,
              user: zfz_user + 'user/',
              org: zfz_user + 'org/',
              role: zfz_user + 'role/',
              modular: zfz_user + 'modular/',
              permission: zfz_user + 'permission/',
          },
          zfz_wealth:{
              root:zfz_wealth,
          }
      }
    }
};

export default config;
