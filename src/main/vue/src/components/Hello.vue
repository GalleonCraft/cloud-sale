<template>
  <div class="hello">
        <el-button >{{name}}</el-button>
  </div>
</template>

<script>
export default {
  name: 'hello',
  data () {
    return {
      name: '蛤喽 Vue！'
    }
  },
  beforeMount: function(){
    this.queryName();
  },
  methods: {
     queryName: function(){
       var vm = this;
        this.$http.post('http://localhost:8080/hello').then(function(response){
              vm.name = response.data;
      },function(response){

      }
      )}
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
