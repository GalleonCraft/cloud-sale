// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import Login from './Login.vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import store from 'store'
import 'element-ui/lib/theme-chalk/index.css'

Vue.config.productionTip = false
Vue.use(ElementUI)

var menus = [
  {
    name:'系统管理',
    url:'',
    icon:'el-icon-setting',
    role:['ADMIN'],
    children:[
      {
        name:'用户管理',
        url:'/system/sysUser'
      },
      {
        name:'权限管理',
        url:'/system/sysQx'
      }
    ]
  }
];

var MainApp = App;
if(!window.localStorage){
  alert("浏览器版本太旧，部分功能无法展示。");
}else{
  var currentUser = store.get('currentUser');
  //console.log(currentUser);
  if(currentUser){
    var authmenus = [];
    for(var i=0;i<menus.length;i++){
      var m = menus[i];
      if(!m.role || m.role.indexOf(currentUser.role) >= 0){
        var am = {name:m.name,url:m.url,icon:m.icon,children:[]};
        if(m.children){
          for(var j=0;j<m.children.length;j++){
            var cm = m.children[j];
            if(!cm.role || cm.role.indexOf(currentUser.role) >= 0){
              am.children.push({name:cm.name,url:cm.url});
            }
          }
        }
        authmenus.push(am);
      }
    }
    store.set('authmenus',authmenus);
  }else{
    MainApp = Login;
  }
}
router.replace("/");
store.set('menus',menus);

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  render: h => h(MainApp)
})

