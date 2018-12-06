const routers = [
    {
        path: '/',
        meta: {
            title: ''
        },
        component: (resolve) => require(['./views/index.vue'], resolve)
    },
    {
        path: '/login',
        meta: {
            title: ''
        },
        component: (resolve) => require(['./views/login.vue'], resolve)
    },
    {
        path: '/user_manager',
        meta: {
            title: ''
        },
        component: (resolve) => require(['./views/user_manager.vue'], resolve)
    },
];
export default routers;
