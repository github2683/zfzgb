<template>
    <div >

        <Row>
            <Col span="24">
                <Card>
                    <p slot="title">
                        <Icon type="ios-film-outline"></Icon>
                        用户管理
                    </p>
                    <a href="#" slot="extra" @click.prevent="changeLimit">
                        <Icon type="ios-loop-strong"></Icon>

                    </a>

                    <Table border :columns="columns7" :data="data6"></Table>
                    <br/>
                    <Page :total="total" show-sizer show-elevator show-total />
                    <br>
                    <Row>
                        <Col span="24">
                            <Button type="primary" size="large" @click="handleStart(1)"><Icon type="ios-download-outline"></Icon> Add</Button>
                            <Button type="primary" size="large" @click="getData(2)"><Icon type="ios-download-outline"></Icon> Export sorting and filtered data</Button>
                            <Button type="primary" size="large" @click="exportData(3)"><Icon type="ios-download-outline"></Icon> Export custom data</Button>
                        </Col>
                    </Row>
                </Card>
            </Col>
        </Row>

    </div>
</template>
<script>
    import axios from 'axios';
    export default {
        data () {
            return {
                columns7: [
                    {
                        title: 'Name',
                        key: 'name',
                        render: (h, params) => {
                            return h('div', [
                                h('Icon', {
                                    props: {
                                        type: 'person'
                                    }
                                }),
                                h('strong', params.row.name)
                            ]);
                        }
                    },
                    {
                        title: 'Age',
                        key: 'age'
                    },
                    {
                        title: 'Address',
                        key: 'address'
                    },
                    {
                        title: 'Action',
                        key: 'action',
                        width: 150,
                        align: 'center',
                        render: (h, params) => {
                            return h('div', [
                                h('Button', {
                                    props: {
                                        type: 'primary',
                                        size: 'small'
                                    },
                                    style: {
                                        marginRight: '5px'
                                    },
                                    on: {
                                        click: () => {
                                            this.show(params.index)
                                        }
                                    }
                                }, 'View'),
                                h('Button', {
                                    props: {
                                        type: 'error',
                                        size: 'small'
                                    },
                                    on: {
                                        click: () => {
                                            this.remove(params.index)
                                        }
                                    }
                                }, 'Delete')
                            ]);
                        }
                    }
                ],
                data6: [
                    {
                        name: 'John Brown',
                        age: 18,
                        address: 'New York No. 1 Lake Park'
                    },
                    {
                        name: 'Jim Green',
                        age: 24,
                        address: 'London No. 1 Lake Park'
                    },
                    {
                        name: 'Joe Black',
                        age: 30,
                        address: 'Sydney No. 1 Lake Park'
                    },
                    {
                        name: 'Jon Snow',
                        age: 26,
                        address: 'Ottawa No. 2 Lake Park'
                    }
                ]
            }
        },
        methods: {
            show (index) {
                this.$Modal.info({
                    title: '用户信息',
                    content: `Name：${this.data6[index].name}<br>Age：${this.data6[index].age}<br>Address：${this.data6[index].address}`
                })
            },
            remove (index) {
                this.data6.splice(index, 1);
            },
            handleStart () {
                this.$Modal.info({
                    title: '登录表单',
                    content: '输入用户名和密码'
                });
            },
            getData(index){
                let url = 'http://localhost:8011/user/get?id='+ index;
                axios.get(url).then(function () {
                    console.log("请求结束");
                }).catch(function () {
                    console.log(" catch 异常 ");
                }).finally(function () {
                    console.log("请求最后 finally ");
                });
            }
        },
        computed:{
            total:function () {
                return this.data6.length;
            }
        }
    }
</script>
