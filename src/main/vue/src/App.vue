<template>
  <div id="app">
    <el-row>
      <el-col :span="24">
        <el-menu
          :default-active="activeIndex2"
          class="el-menu-demo"
          mode="horizontal"
          :router="true"
          @select="handleSelect"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b">
          <el-menu-item  index="/HelloWorld">处理中心</el-menu-item>
          <el-menu-item style="float: right;" index="2"><a target="_blank">你好：{{userInfo.name}}</a></el-menu-item>
          <el-menu-item style="float: right;" index="3"><a target="_blank">消息({{cmsg}})</a></el-menu-item>
        </el-menu>
      </el-col>
      <el-col :span="4">
        <el-menu
          default-active="2"
          class="el-menu-vertical-demo"
          @open="handleOpen"
          @close="handleClose"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b">
          <el-submenu v-for="(menu, index) in menus" class="el-menu-vertical-demo" :index="index+''">
            <template slot="title"><i :class="menu.icon"></i>{{menu.name}}</template>
            <el-menu-item v-for="(m, index2) in menu.children" :index="m.url">
              {{m.name}}
            </el-menu-item>
          </el-submenu>
        </el-menu>
      </el-col>
      <el-col :span="20">
        <router-view/>
      </el-col>
    </el-row>
  </div>
</template>

<script type="text/ecmascript-6">
  import store from 'store'
  import $ from 'jquery'
  export default {
  name: 'App',
  data () {
    return {
      msg:'Welcome to Your Vue.js App!',
      cmsg:9,
      userInfo:{
        name:'付永强',
        age:'26',
        sex:'猛男'
      }
    }
  },
  methods: {
    initData: function(){
      this.menus = store.get('menus');
      console.log(this.menus)
    },
  },
    beforeMount: function(){
    this.initData();
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 10px;
}
</style>
