<template>
    <div id="app">
        <div class="header">
            <div class="title">流动人口369工作管理平台</div>
            <div style="clear: both;"></div>
        </div>
        <div class="login">
            <h3 class="login_title">
                <span class="login_c i_small i_line"></span>登录
            </h3>

            <form @keyup="enterKeyLogin">
                <ul class="loging">
                    <li class="i_lcol_01">
                        <label class="log_user"></label>
                        <input type="text" class="login_txt" v-model="userName" placeholder="用户名">
                    </li>
                    <li class="i_lcol_01">
                        <label class="log_pass"></label>
                        <input type="password" class="login_txt" v-model="password" placeholder="密码">
                    </li>
                    <li>
                        <a href="javascript:void(0);" class="login_sub" @click="subLogin">登录</a>
                    </li>
                </ul>
            </form>
        </div>
    </div>
</template>

<script>
    import store from 'store'
    import { Message } from 'element-ui'
    import {Base64} from 'js-base64'
    export default {
        name: 'login',
        data: function(){
            return{
                userName: '',
                password: ''
            }
        },
        methods: {
            subLogin: function(){
                if(!this.userName){
                    alert('用户名不能为空');
                }else if(!this.password){
                    alert('密码不能为空');
                }else{
                    //store.set('currentUser',{username:this.userName,state:'logined'});
                    //window.location.reload();
                    var formData = new FormData();
                    formData.append('username', this.userName);
                    formData.append('passwd', this.password);
                    this.$http.post("/oauth/token",formData).then(function(response){
                        console.log(response);
                        var data = response.body;
                        if(data.code == 20000){
                            Message.success({message:"登陆成功"});
                            store.set("accessToken",data.accessToken);
                            var tokens = data.accessToken.access_token.split(".");
                            var claims = tokens[1];
                            var user = Base64.decode(claims);
                            user = JSON.parse(user);
                            store.set("currentUser",user);
                            window.location.reload();
                        }else{
                            Message.error({message:data.msg});
                        }
                    }, function(response){
                        Message.error({message:"请求异常"});
                    });
                }
            },
            enterKeyLogin: function(event){
                var e = event || window.event || arguments.callee.caller.arguments[0];
                if(e && e.keyCode == 13){
                    this.subLogin();
                }
            }
        }
    }
</script>

<style>
    .login {
        width: 324px;
        height: 390px;
        position: absolute;
        right: 80px;
        top: 160px;;
    }
    .login .login_title {
        background: url(assets/logo.png) 0 -1px no-repeat;
        position: relative;
        width: 244px;
        height: 76px;
        padding: 0 40px;
        line-height: 76px;
        font-weight: bold;
        font-size: 16px;
        text-shadow: 0 0 1px #38a4da;
        color: #fff!important;
    }
    .login .login_title .login_c {
        background-position: -33px 0;
        height: 17px;
        width: 17px;
        margin-bottom: -2px;
        margin-right: 5px;
        display: inline-block;
        background-image: url(assets/logo.png);
        background-position: 0 0;
        background-repeat: no-repeat;
    }
    .login form{
        margin-top: -16px;
    }
    .login .loging{
        text-shadow: 0 0 1px #fff;
        padding: 40px;
        padding-bottom: 96px;
        width: 242px;
        border-left: 1px solid #c9c9c9;
        border-right: 1px solid #c9c9c9;
        background-color: #f5f5f5;
        color: #666;
        border-bottom: 1px solid #c9c9c9;
    }
    .loging li {
        height: 40px;
        line-height: 40px;
        display: list-item;
        text-align: -webkit-match-parent;
        list-style-type: none;
    }
    .loging li+ li{
        margin-top: 20px;
    }
    .i_lcol_01{
        border: 1px solid #ebebeb;
        background-color: #fff;
    }
    .loging .log_user {
        width: 43px;
        height: 40px;
        display: inline-block;
        background-color: #c2e5f3;
        background-image: url(assets/logo.png);
        background-position: -24px 11px;
        background-repeat: no-repeat;
        float: left;
        cursor: default;
    }
    .loging .login_txt {
        padding: 8px 4px;
        height: 22px;
        line-height: 22px;
        width: 188px;
        border: 0 none;
        color: #666;
        font-size: 100%;
        font: 13px/1.5 "微软雅黑",tahoma,arial;
    }
    .loging .log_pass {
        float: left;
        cursor: default;
        width: 43px;
        height: 40px;
        display: inline-block;
        background-color: #c2e5f3;
        background-image: url(assets/logo.png);
        background-position: -21px -24px;
        background-repeat: no-repeat;
        background-color: #c2e5f3;
    }
    .login .login_sub {
        box-shadow: 0 0 1px #fff;
        width: 92px;
        height: 36px;
        text-align: center;
        margin-bottom: -6px;
        line-height: 36px;
        color: #406a24;
        background-image: url(assets/logo.png);
        background-position: -108px -217px;
        background-repeat: no-repeat;
        float: right;
        text-decoration: none;
    }
</style>
