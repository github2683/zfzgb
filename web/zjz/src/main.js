import Vue from 'vue';
import iView from 'iview';
import VueRouter from 'vue-router';
import Routers from './router';
import Util from './libs/util';
import App from './app.vue';
import 'iview/dist/styles/iview.css';
import axios from 'axios';
Vue.use(VueRouter);
Vue.use(iView);


// 路由配置
const RouterConfig = {
    mode: 'history',
    routes: Routers
};
const router = new VueRouter(RouterConfig);

router.beforeEach((to, from, next) => {
    iView.LoadingBar.start();
    Util.title(to.meta.title);
    console.log(" ---------beforeEach--------------- ");
    next();
});

router.afterEach((to, from, next) => {
    iView.LoadingBar.finish();
    console.log(" ---------afterEach--------------- ");
    window.scrollTo(0, 0);
});

// 添加一个请求拦截器
axios.interceptors.request.use(function (config) {
    // Do something before request is sent
    console.log(" axios 请求拦截 " );
    console.log(config );
    if(config.method == "get"){
        config.url = config.url + "&accesstoken=abc"
    }
    return config;
}, function (error) {
    // Do something with request error
    console.log(" axios 请求错误拦截 ");
    return Promise.reject(error);
});

// 添加一个响应拦截器
axios.interceptors.response.use(function (response) {
    // Do something with response data
    console.log(" axios 响应拦截 ");
    console.log(response);
    return response;
}, function (error) {
    // Do something with response error
    console.log(" axios 响应错误拦截 ");
    return Promise.reject(error);
});



new Vue({
    el: '#app',
    router: router,
    render: h => h(App)
});
