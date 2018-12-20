<template>
    <div>
        <Tree :data="org" :render="renderContent"
              show-checkbox
               @on-check-change="checkChagne" ></Tree>
    </div>
</template>

<script>
    import config from "../config/config";
    import axios from 'axios';
    export default {
        name: "OrgSelect",
        data(){
            return {
                org:[]
            }
        },
        mounted:function () {
            this.loadData();
        },
        methods:{
            checkChagne(data){
                console.log("勾选的节点");
                console.log(data );
                console.log(arguments);
                //TODO 查询相应的用户信息
            },
            loadData(){
                let xthis = this;
                let url = config.url.server.zfz_user.org + 'search';
                axios.get(url).then(function (res) {
                    let resData = res.data;

                    if( resData.code == config.code.response.SUCCESS ){
                        if( resData.data && resData.data.length > 0 ) {
                            xthis.org = xthis.convert2Tree(resData.data);
                        }
                        // xthis.$Message.success('组织信息加载成功');
                    }else {
                        xthis.$Message.error('组织信息加载失败');
                    }
                });
            },
            convert2Tree(data){
                let orgs = [];
                if(!data || data.length == 0 ){
                    return orgs;
                }
                let len = data.length;
                for(let i=0;i<len;i++){
                    let d = data[i];
                    if( !d.pid || d.pid == '-1'){
                        let org  = {
                            id:d.id,
                            pid:'-1',
                            title: d.name,
                            expand: true,

                        };
                        org.children = this.getChildren(data,org.id);
                        orgs.push(org);
                    }
                }

                return orgs;
            },
            getChildren(data,pid){
                if(!data || data.length == 0){
                    return [];
                }
                let orgs = new Array();
                let len = data.length;
                for(let i=0;i<len;i++){
                    let d = data[i];
                    if( d.pid == pid ){
                        let org  = {
                            id:d.id,
                            pid:pid,
                            title: d.name,
                            expand: true,
                        };
                        org.children = this.getChildren(data,org.id);
                        orgs.push(org);
                    }
                }
                return orgs;
            },
            renderContent (h, { root, node, data }) {
                return h('span', {
                    style: {
                        display: 'inline-block',
                        width: '100%'
                    }
                }, [
                    h('span', [
                        h('Icon', {
                            props: {
                                type: 'ios-paper-outline'
                            },
                            style: {
                                marginRight: '8px'
                            }
                        }),
                        h('span', data.title)
                    ]),
                    h('span', {
                        style: {
                            display: 'inline-block',
                            float: 'right',
                            marginRight: '32px'
                        }
                    })
                ]);
            },
        }
    }
</script>

<style scoped>

</style>
