<template>
    <div>
        <Row  type="flex" justify="center" align="middle">
            <Col span="12">
                <Card style="width:100%">
                    <p slot="title">
                        <Icon type="ios-people"></Icon>
                        组织管理
                    </p>
                    <a href="#" slot="extra" @click.prevent="changeLimit">
                        <Icon type="ios-loop-strong"></Icon>
                        Change
                    </a>
                    <Tree :data="org" :render="renderContent"></Tree>
                </Card>
            </Col>
        </Row>
        <Modal v-model="orgModel" title="组织新增" @on-ok="submitAdd('formValidate')" @on-cancel="handleReset('formValidate')">
            <Form ref="formValidate" :model="formValidate" :rules="ruleValidate" :label-width="80">
                <FormItem label="父组织名" prop="username">
                    <Input v-model="formValidate.pname" ></Input>
                </FormItem>

                <FormItem label="组织名" prop="username">
                    <Input v-model="formValidate.name" placeholder="输入组织"></Input>
                </FormItem>

                <FormItem label="排序值" prop="seg">
                    <Input v-model="formValidate.seg"  placeholder="输入整数"></Input>
                </FormItem>

                <FormItem label="描述" prop="remark">
                    <Input v-model="formValidate.remark" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="写点说明吧..."></Input>
                </FormItem>
            </Form>
            <!--<span slot="footer"></span>-->
        </Modal>
    </div>
</template>
<script>
    import config from "../config/config";
    import axios from 'axios';
    export default {
        name: "org_manager",
        data () {
            return {
                org: [
                    {
                        title: '根组织 1',
                        expand: true,
                        render: (h, { root, node, data }) => {
                            return h('span', {
                                style: {
                                    display: 'inline-block',
                                    width: '100%'
                                }
                            }, [
                                h('span', [
                                    h('Icon', {
                                        props: {
                                            type: 'ios-folder-outline'
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
                                }, [
                                    h('Button', {
                                        props: Object.assign({}, this.buttonProps, {
                                            icon: 'ios-add',
                                            type: 'primary'
                                        }),
                                        style: {
                                            width: '64px'
                                        },
                                        on: {
                                            click: () => { this.append(data) }
                                        }
                                    })
                                ])
                            ]);
                        },
                        children: [
                            {
                                title: '一级组织 1-1',
                                expand: true,
                                children: [
                                    {
                                        title: '二级组织 1-1-1',
                                        expand: true
                                    },
                                    {
                                        title: '二级组织 1-1-2',
                                        expand: true
                                    }
                                ]
                            },
                            {
                                title: '一级组织 1-2',
                                expand: true,
                                children: [
                                    {
                                        title: '二级组织 1-2-1',
                                        expand: true
                                    },
                                    {
                                        title: '二级组织 1-2-1',
                                        expand: true
                                    }
                                ]
                            }
                        ]
                    }
                ],
                buttonProps: {
                    type: 'default',
                    size: 'small',
                },
                orgModel:false,
                optData:null,
                formValidate: {
                    pname:'',
                    pid:'',
                    name: '',
                    seg: 1,
                    remark: ''
                },
                ruleValidate: {
                    pid: [
                        { required: true }
                    ],
                    name: [
                        { required: true, message: '请输入用户名', trigger: 'blur' }
                    ],
                    seg: [
                        { required: true, type: 'integer', message: '请输入一个整数', trigger: 'change' },
                        { min: 1, type: 'integer', message: '请输入要不小于1', trigger: 'change' }
                    ],
                    remark: [
                        { required: true, message: '请输入备注内容', trigger: 'blur' },
                        { type: 'string', min: 15, message: '备注不得少于15个字', trigger: 'blur' }
                    ]
                }
            }
        },
        methods: {
            loadData(){
                let xthis = this;
                let url = config.url.server.zfz_user.org + 'search';
                axios.get(url).then(function (res) {
                    let resData = res.data;
                    if( resData.code == config.code.response.SUCCESS ){
                        if( resData.data && resData.data.length > 0 ) {
                            xthis.org = xthis.convert2Tree(resData.data);
                        }
                        xthis.$Message.success('组织信息加载成功');
                    }else {
                        xthis.$Message.error('组织信息加载失败');
                    }
                });

            },
            convert2Tree(data){
                let orgs = [];
                let len = data.length;
                for(let i=0;i<len;i++){
                    let d = data[i];
                    if( !d.pid || d.pid == '-1'){
                        let org  = {
                            id:d.id,
                            pid:'-1',
                            pids:'-1',
                            title: d.name,
                            expand: true,
                            render: (h, {root, node, data}) => {
                                return h('span', {
                                    style: {
                                        display: 'inline-block',
                                        width: '100%'
                                    }
                                }, [
                                    h('span', [
                                        h('Icon', {
                                            props: {
                                                type: 'ios-folder-outline'
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
                                    }, [
                                        h('Button', {
                                            props: Object.assign({}, this.buttonProps, {
                                                icon: 'ios-add',
                                                type: 'primary'
                                            }),
                                            style: {
                                                width: '64px'
                                            },
                                            on: {
                                                click: () => {
                                                    this.append(data)
                                                }
                                            }
                                        })
                                    ])
                                ]);
                            },
                        }
                        org.children = this.getChildren(data,org.id);
                        orgs.push(org);
                    }
                }

                return orgs;
            },
            getChildren(data,pid){
                let orgs = new Array();
                let len = data.length;
                for(let i=0;i<len;i++){
                    let d = data[i];
                    if( d.pid == pid ){
                        let org  = {
                                id:d.id,
                                pid:pid,
                                pids:d.pids,
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
                    }, [
                        h('Button', {
                            props: Object.assign({}, this.buttonProps, {
                                icon: 'ios-add'
                            }),
                            style: {
                                marginRight: '8px'
                            },
                            on: {
                                click: () => { this.append(data) }
                            }
                        }),
                        h('Button', {
                            props: Object.assign({}, this.buttonProps, {
                                icon: 'ios-remove'
                            }),
                            on: {
                                click: () => { this.remove(root, node, data) }
                            }
                        })
                    ])
                ]);
            },
            append (data) {

                // const children = data.children || [];
                // children.push({
                //     title: 'appended node',
                //     expand: true
                // });
                // this.$set(data, 'children', children);

                this.formValidate.pid = data.id;
                this.formValidate.pids = data.pids + ',' + data.id;
                this.formValidate.pname = data.title;
                this.optData = data;
                this.orgModel = true;
            },
            submitAdd(name){
                let xthis = this;
                this.$refs[name].validate((valid) => {
                    let url = config.url.server.zfz_user.org + config.url.opt.add;
                    // this.formValidate.name = this.formValidate.title;
                    axios.get(url, {params: this.formValidate}).then(function (res) {
                        let resData = res.data;
                        if (resData.code == config.code.response.SUCCESS) {
                            let d = resData.data;
                            let org = {
                                title: d.name,
                                id: d.id,
                                pid: d.pid,
                                pids: d.pids,
                                expand: true,
                            };
                            xthis.optData.children.push(org);
                            xthis.$set(xthis.optData,'children',xthis.optData.children);
                            xthis.$Message.success('添加成功');
                        }else {
                            xthis.$Message.error('添加失败');
                        }
                    });
                });
            },
            remove (root, node, data) {
                // root 根节点
                // node 当前节点
                // data 当前节点数据

                if(data.children && data.children.length > 0 ){
                    this.$Modal.error({
                        title: '删除提示',
                        content: '组织：' + data.title + ' 下有子组织，不可以直接删除，<br/> 请先删除子组织！'
                    });
                    return false;
                }

                const parentKey = root.find(el => el === node).parent;
                const parent = root.find(el => el.nodeKey === parentKey).node;
                const index = parent.children.indexOf(data);
                // parent.children.splice(index, 1);

                let xthis = this;
                this.$Modal.confirm({
                    title:'删除确认提示',
                    content:'确定删除' + data.title,
                    onOk:function () {
                        let url = config.url.server.zfz_user.org + config.url.opt.delete +'?id=' + data.id;
                        axios.get(url).then(function (res) {
                            let resData = res.data;
                            if ( resData.code == config.code.response.SUCCESS ) {
                                xthis.$Message.success('删除成功!');
                                parent.children.splice(index, 1);
                            } else {
                                xthis.$Message.error('删除失败!');
                            }
                        })
                    },
                    onCancel:function () {

                    }
                });

            }
        },
        mounted:function () {
            this.loadData();
        }
    }
</script>

<style scoped>

</style>
