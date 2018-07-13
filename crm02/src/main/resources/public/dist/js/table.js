require.config({
  paths: {
    "vue": 'lib/vue',
    "axios": 'lib/axios.min'
  }
})

require(['vue', 'axios'], function(Vue, axios) {
  const vm = new Vue({
    el: '#app',
    created: function() {
      const _this = this
      axios({
        url: 'http://127.0.0.1:8080/data/incomes.json',
        method: 'get',
        responseType: 'json',
      }).then((res) => {
        const result = res.data
        _this.data = result
      })
    },
    data: {
      data: '',
      condition: {
        0: '',
        1: '',
        2: '',
        length: 3
      }
    },
    methods: {
      filter: function() {
        // console.log(Array.prototype.slice.call(this.condition))
        const _this = this
        this.data.record.forEach(function(item) {
          if(item.province.match(_this.condition[0])) {
            console.log(item);
          }
        })
      }
    }
  })
})
