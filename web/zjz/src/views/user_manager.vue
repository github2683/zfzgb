<template>
    <div >

        <Row>
            <Col span="24">
                <Card>
                    <p slot="title">
                        <Icon type="ios-contacts" style="font-size:21px;"></Icon>
                        用户管理
                    </p>
                    <a href="#" slot="extra" @click.prevent="changeLimit">
                        <Icon type="ios-loop-strong"></Icon>
                        修改
                    </a>

                    <Row>
                        <Col span="3">
                            <OrgSelect></OrgSelect>
                        </Col>
                        <Col span="21">
                            <Table border :columns="userTableTitle" :data="tableData"></Table>
                            <br/>
                            <Page :total="total" show-sizer show-elevator show-total v-on:on-change="loadData" />
                            <br>
                        </Col>
                    </Row>


                    <Row>
                        <Col span="24" align="right">
                            <Button type="primary" size="large" @click="userModel = true">新增</Button>
                            <Button type="primary" size="large" @click="getData(2)">导出过虑数据</Button>
                            <Button type="primary" size="large" @click="userModel = true">导出所有数据</Button>
                        </Col>
                    </Row>
                </Card>

            </Col>
        </Row>
        <Modal v-model="userModel" title="用户新增" @on-ok="handleSubmit('formValidate')" @on-cancel="handleReset('formValidate')">
            <Form ref="formValidate" :model="formValidate" :rules="ruleValidate" :label-width="80">
                <FormItem label="用户名" prop="username">
                    <Input v-model="formValidate.username" placeholder="输入用户名"></Input>
                </FormItem>
                <FormItem label="手机号" prop="phone">
                    <Input v-model="formValidate.phone" placeholder="输入手机号"></Input>
                </FormItem>
                <FormItem label="微信号" prop="weixin">
                    <Input v-model="formValidate.weixin" placeholder="输入微信号"></Input>
                </FormItem>
                <FormItem label="电子邮箱" prop="email">
                    <Input v-model="formValidate.email" placeholder="输入电子邮箱"></Input>
                </FormItem>
                <FormItem label="密码" prop="password">
                    <Input v-model="formValidate.password" placeholder="输入用户名"></Input>
                </FormItem>
                <FormItem label="排序值" prop="seg">
                    <Input v-model="formValidate.seg"  placeholder="输入整数"></Input>
                </FormItem>
                <!--
                <FormItem label="城市" prop="city">
                    <Select v-model="formValidate.city" placeholder="选择城市">
                        <Option value="beijing">北京</Option>
                        <Option value="shanghai">上海</Option>
                        <Option value="shenzhen">深圳</Option>
                    </Select>
                </FormItem>
                <FormItem label="日期">
                    <Row>
                        <Col span="11">
                            <FormItem prop="date">
                                <DatePicker type="date" placeholder="选择日期" v-model="formValidate.date"></DatePicker>
                            </FormItem>
                        </Col>
                        <Col span="2" style="text-align: center">-</Col>
                        <Col span="11">
                            <FormItem prop="time">
                                <TimePicker type="time" placeholder="选择时间" v-model="formValidate.time"></TimePicker>
                            </FormItem>
                        </Col>
                    </Row>
                </FormItem>
                <FormItem label="性别" prop="gender">
                    <RadioGroup v-model="formValidate.gender">
                        <Radio label="male">男</Radio>
                        <Radio label="female">女</Radio>
                    </RadioGroup>
                </FormItem>
                <FormItem label="爱好" prop="interest">
                    <CheckboxGroup v-model="formValidate.interest">
                        <Checkbox label="吃"></Checkbox>
                        <Checkbox label="睡"></Checkbox>
                        <Checkbox label="徒步"></Checkbox>
                        <Checkbox label="看电影"></Checkbox>
                    </CheckboxGroup>
                </FormItem>
                -->
                <FormItem label="描述" prop="remark">
                    <Input v-model="formValidate.remark" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="写点说明吧..."></Input>
                </FormItem>
                <!--<FormItem>-->
                    <!--<Button type="primary" @click="handleSubmit('formValidate')">Submit</Button>-->
                    <!--<Button @click="handleReset('formValidate')" style="margin-left: 8px">Reset</Button>-->
                <!--</FormItem>-->
            </Form>
            <!--<span slot="footer"></span>-->
        </Modal>
    </div>
</template>
<script>
    import axios from 'axios';
    import config from '../config/config'
    import OrgSelect from "../components/OrgSelect";
    export default {
        components: {OrgSelect},
        data () {
            return {
                page:2,
                total:10,
                userTableTitle: [
                    {
                        title: 'id',
                        key: 'id',
                        render: (h, params) => {
                            return h('div', [h('strong', params.row.id)]);
                        }
                    },
                    {
                        title: 'username',
                        key: 'username',
                        render:(h,params) =>{
                            return h('span',params.row.username);
                        }
                    },
                    {
                        title: 'phone',
                        key: 'phone'
                    },
                    {
                        title: 'weixin',
                        key: 'weixin'
                    },
                    {
                        title: 'password',
                        key: 'password'
                    },
                    {
                        title:'email',
                        key:'email'
                    },
                    {
                        title: 'Action',
                        key: 'action',
                        width: 250,
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
                                }, '详情'),
                                h('Button', {
                                    props: {
                                        type: 'error',
                                        size: 'small'
                                    },
                                    style: {
                                        marginRight: '5px'
                                    },
                                    on: {
                                        click: () => {
                                            this.remove(params.index)
                                        }
                                    }
                                }, '删除'),
                                h('Button', {
                                    props: {
                                        type: 'success',
                                        size: 'small'
                                    },
                                    on: {
                                        click: () => {
                                            this.update(params.index)
                                        }
                                    }
                                }, '更新')
                            ]);
                        }
                    }
                ],
                userData: [
                    {
                        name:'zhc',
                        username: 'John Brown',
                        password: 'pw',
                        email: 'New York No. 1 Lake Park',
                        key:'abc'
                    },

                ],
                userModel:false,
                formValidate: {
                    username: '',
                    phone: '',
                    weixin: '',
                    email: '',
                    password: '',
                    seg: 1,
                    remark: ''
                },
                ruleValidate: {
                    username: [
                        { required: true, message: '请输入用户名', trigger: 'blur' }
                    ],
                    phone: [
                        { required: true, message: '请输入手机号', trigger: 'change' }
                    ],
                    weixin: [
                        { required: true, message: '请输入微信号', trigger: 'change' }
                    ],
                    email: [
                        { required: true, message: '请输入电子邮箱', trigger: 'blur' },
                        { type: 'email', message: '电子邮箱格式不正确', trigger: 'blur' }
                    ],
                    password: [
                        { required: true, type: 'string', min: 1, message: '请输入密码', trigger: 'change' },
                        { type: 'string',  message: '密码复杂度不够', trigger: 'change' }
                    ],
                    // date: [
                    //     { required: true, type: 'date', message: 'Please select the date', trigger: 'change' }
                    // ],
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
            show (index) {
                this.$Modal.info({
                    title: '用户信息',
                    content: `Name：${this.userData[index].username}<br>Phone：${this.userData[index].phone}<br>Email：${this.userData[index].email}<br>Password：${this.userData[index].password}`
                })
            },
            update (index) {

                this.formValidate = this.userData[index];
                this.userModel = true;

            },
            remove (index) {
                let xthis = this;
                let user = xthis.userData[index];
                this.$Modal.confirm({
                    title:'删除确认提示',
                    content:'确定删除' + user.username,
                    onOk:function () {
                        let url = config.url.server.zfz_user.user + config.url.opt.delete +'?id=' + xthis.userData[index].id;
                        axios.get(url).then(function (res) {

                            console.log(res.data);//返回的整个对象
                            let d = res.data;
                            if ( d.code == config.code.response.SUCCESS ) {

                                xthis.$Message.success('删除成功!');

                                xthis.userData.splice(index, 1);
                                xthis.total -= 1;

                            } else {
                                xthis.$Message.error('删除失败!');
                            }
                        })
                    },
                    onCancel:function () {

                    }
                });
            },
            getData(index){
                let url = config.url.server.zfz_user.user + config.url.opt.get + '?id='+ this.userData[index].id;
                axios.get(url).then(function (data) {
                    console.log("请求结束");
                    console.log(data);
                }).catch(function () {
                    console.log(" catch 异常 ");
                }).finally(function () {
                    console.log("请求最后 finally ");
                });
            },
            handleSubmit (name) {
                let xthis = this;
                this.$refs[name].validate((valid) => {

                    console.log(xthis.formValidate);
                    let url = config.url.server.zfz_user.user + 'add';
                    let opt = '新增';
                    if(xthis.formValidate.id){
                        url = config.url.server.zfz_user.user + 'update';
                        opt = '更新';
                    }
                    axios.get(url,{params:xthis.formValidate}).then(function (res) {

                        console.log(res.data);//返回的整个对象
                        let d = res.data;
                        if ( d.code == config.code.response.SUCCESS ) {

                            xthis.$Message.success( opt + '成功!');
                            if(opt=='新增') {
                                xthis.userData.unshift(d.data);
                                xthis.total += 1;
                            }
                        } else {
                            xthis.$Message.error(opt + '失败!');
                        }
                    }).catch(function () {
                        xthis.$Message.error(opt + "异常 ");
                    });



                })
            },
            handleReset (name) {
                this.$refs[name].resetFields();
            },
            loadData:function (page,orgIds) {
                this.page = page?page:1;

                let url = config.url.server.zfz_user.user + config.url.opt.search ;
                let param = {
                    params:{
                        page:this.page,
                        limit:10,
                    }
                };
                if(orgIds){
                    param.params.orgIds = orgIds;
                }
                let xthis = this;
                axios.get(url,param)
                    .then(function (res) {
                        console.log("请求结束");
                        console.log(res);

                        if(res.data.code == config.code.response.SUCCESS){

                            xthis.userData =  res.data.data;
                            if(xthis.page==1) {
                                xthis.total = res.data.total;
                            }
                        }

                    }).catch(function () {

                        console.log(" catch 异常 ");

                    }).finally(function () {

                        console.log("请求最后 finally ");
                        // return a;

                    });
            }

        },
        computed:{
          tableData:function () {
              return this.userData;
          }
        },
        mounted:function () {
            //初始化后执行
            // this.$nextTick(function () {
                this.loadData();
            // })

        }
    }
</script>
