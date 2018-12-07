<style scoped>
    @import 'styles/common.css';
</style>
<template>

    <Row>
        <Col v-bind:span="menuWidth" v-if="hasMenu" v-on:changeTopTheme="changeWidth()" style="z-index: 999;">
            <NavMenu></NavMenu>
        </Col>
        <Col v-bind:span="topWidth">
            <Row v-if="hasTop">
                <Col span="24">
                    <NavTop></NavTop>
                </Col>
            </Row>
            <Row>
                <Col span="24">
                    <router-view></router-view>
                </Col>
            </Row>
        </Col>
    </Row>

    <!--原布局-->
    <!--<div>-->
        <!--<router-view></router-view>-->
    <!--</div>-->
</template>
<script>
    import NavTop from "./components/NavTop";
    import NavMenu from "./components/NavMenu";

    export default {
        components: {NavMenu, NavTop},
        data () {
            return {
                topWidth:21,
                menuWidth:3
            }
        },
        mounted () {

        },
        beforeDestroy () {

        },
        computed: {
            hasTop:function () {
                let login =  window.location.href.indexOf("login")<0;
                console.log(login?'要头条导航':'不要头条导航');
                return login;
            },
            hasMenu:function () {
                let login =  window.location.href.indexOf("login")<0;
                console.log(login?'要菜单':'不要菜单');
                return login;
            }
        },
        methods:{
            changeWidth:function () {
                debugger;
                this.topWidth = 23;
                this.menuWidth = 1;
            }
        }
    }
</script>
