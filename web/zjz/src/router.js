const routers = [
    {
        path: '/',
        meta: {
            title: '首页'
        },
        component: (resolve) => require(['./views/index.vue'], resolve)
    },
    {
        path: '/login',
        meta: {
            title: '登录'
        },
        component: (resolve) => require(['./views/login.vue'], resolve)
    },
    {
        path: '/user_manager',
        meta: {
            title: '用户管理'
        },
        component: (resolve) => require(['./views/user_manager.vue'], resolve)
    },
    {
        path: '/org_manager',
        meta: {
            title: '组织管理'
        },
        component: (resolve) => require(['./views/org_manager.vue'], resolve)
    },
];
export default routers;
