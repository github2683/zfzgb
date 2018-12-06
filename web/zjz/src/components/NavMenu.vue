<template>
        <Row>
            <Col span="24">
                <Menu active-name="1-2" :open-names="['1']">
                    <!--<Submenu>-->
                        <Card style="width:100%;">
                            <div style="text-align:center">
                                <!--<img src="https://icarusion.gitee.io/iview/2ecd3b0452aa197097d5131afacab7b8.png"/>-->
                                <img src="../images/logo.jpg" style="width:85px;"/>
                                <h3>我的大名</h3>
                            </div>
                        </Card>
                    <!--</Submenu>-->
                    <Submenu name="1">
                        <template slot="title">
                            <Icon type="ios-analytics" />
                            模块一
                        </template>
                        <MenuGroup title="分组 1">
                            <MenuItem name="1-1">功能1</MenuItem>
                            <MenuItem name="1-2">功能2</MenuItem>
                        </MenuGroup>
                        <MenuGroup title="分组 2">
                            <MenuItem name="1-3">功能3</MenuItem>
                            <MenuItem name="1-4">功能4</MenuItem>
                        </MenuGroup>
                    </Submenu>
                    <Submenu name="2">
                        <template slot="title">
                            <Icon type="ios-filing" />
                            模块二
                        </template>
                        <MenuItem name="2-1">功能5</MenuItem>
                        <MenuItem name="2-2">功能6</MenuItem>
                        <Submenu name="3">
                            <template slot="title">子菜单</template>
                            <MenuItem name="3-1">功能7</MenuItem>
                            <MenuItem name="3-2">功能8</MenuItem>
                        </Submenu>
                    </Submenu>
                    <Submenu name="4">
                <template slot="title">
                    <Icon type="ios-cog" />
                    模块三
                </template>
                <MenuItem name="4-1">功能9</MenuItem>
                <MenuItem name="4-2">功能10</MenuItem>
                <MenuItem name="4-3">功能11</MenuItem>
                <MenuItem name="4-4">功能12</MenuItem>
            </Submenu>
                </Menu>
            </Col>
        </Row>

</template>

<script>
    export default {
        name: "NavMenu",
        data () {
            return {
                logo: './images/logo.jpg'
            }
        }
    }
</script>

<style scoped>

</style>
