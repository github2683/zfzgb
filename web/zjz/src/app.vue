<style scoped>
    @import 'styles/common.css';
</style>
<template>

    <Row>
        <Col span="3" v-if="hasMenu" style="z-index: 999;">
            <NavMenu></NavMenu>
        </Col>
        <Col span="21">
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
            return {}
        },
        mounted () {

        },
        beforeDestroy () {

        },
        computed: {
            hasTop:function () {
                let login =  window.location.href.indexOf("login")<0;
                console.log(login);
                return login;
            },
            hasMenu:function () {
                let login =  window.location.href.indexOf("login")<0;
                console.log(login);
                return login;
            }
        }
    }
</script>
