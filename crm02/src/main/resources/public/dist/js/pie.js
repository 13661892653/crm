require.config({
  paths: {
    "jquery": 'lib/jquery-1.10.2.min',
    "echart": 'lib/echarts.min',
    "vue": 'lib/vue',
    "axios": 'lib/axios.min'
  }
})

require(['vue', 'echart', 'axios'], function(Vue, echarts, axios) {

  const pieOption = {
    tooltip: {
      trigger: 'item',
      formatter: '{a} <br /> {b}  {c}'
    },
    series: []
  }

  const dataSource = [
    { name: "编程语言人数统计", url: "http://127.0.0.1:8080/data/language.json" }
  ]

  const color = {
    idx: '',
    goal: '',
    colorful: [
      { name: "红色", hex: "#e9546b" },
      { name: "黄绿色", hex: "#b8d200" },
      { name: "蓝色", hex: "#007bbb" },
      { name: "藤黄", hex: "#f7c114" },
      { name: "青竹色", hex: "#7ebeab" },
      { name: "浅葱色", hex: "#00a3af" },
      { name: "梅紫", hex: "#aa4c8f" },
      { name: "花緑青", hex: "#00a381" },
      { name: "黄金", hex: "#e6b422" },
      { name: "熨斗目花色", hex: "#426579" },
    ]
  }

  const vm = new Vue({
    el: '#app',
    created: function() {
      const _this = this
      axios({
        methods: 'get',
        url: 'http://127.0.0.1:8080/data/language.json',
        responseType: 'json',
      }).then((res) => {
        const result = res.data
        _this.data = result
        _this.chartStyle = result.type
      })
    },
    data: {
      data: '',
      type: '',
      option: pieOption,
      cb: false,
      labelItem: [],
      colorBox: color,
      chartStyle: '',
      dataSource: dataSource
    },
    methods: {
      // 添加数值
      addSeries: function(label, alias) {
        // console.log(label);
        // const c = this.colorBox.colorful[Math.floor(Math.random() * 6)].hex
        const len = this.data.record.length
        // let ca = []
        for(let i = 0; i < len; i++) {
          const c = color.colorful[i].hex
          this.data.record[i].itemStyle = {}
          this.data.record[i].itemStyle.normal = {}
          this.data.record[i].itemStyle.normal.color = c
          this.data.record[i].label = {}
          this.data.record[i].label.normal = {}
          this.data.record[i].label.normal.show = true
          this.labelItem.push({idx: i, label: this.data.record[i].name, color: c})
        }

        const se = {
          name: label,
          type: 'pie',
          data: this.data.record
        }
        this.option.series.push(se)
        chart(this.option)
      },
      // 颜色
      setColor: function(idx) {
        this.cb = !this.cb
        this.colorBox.idx = idx
      },
      //设置颜色
      changeColor: function(color) {
        const id = this.colorBox.idx
        const _this = this
        this.option.series[0].data[id].itemStyle.normal.color = color
        this.labelItem[id].color = color
        chart(this.option)
      },
      // 设置类型
      changeStyle: function(label, style) {
        this.option.series.forEach(function(item) {
          if (item.name == label) {
            item.type = style
          }
        })
        chart(this.option)
      },
      // Data Source
      changeData: function(url) {
        // const _this = this
        // this.data = ''
        // this.option.xAxis = {}
        // this.option.xAxis.data = ''
        // this.option.series = []
        // this.labelItem = []
        // this.chartStyle = ''
        // chart(this.option)
        // axios({
        //   url: url,
        //   methods: 'get',
        //   responseType: 'json'
        // }).then((res) => {
        //   const result = res.data
        //   _this.data = result
        //   _this.chartStyle = result.type
        //   _this.option.xAxis.data = result.record.map(function(item) {
        //     return item[result.dimension[0].name]
        //   })
        // })
      }
    }
  })

  function chart(option) {
    const box = document.getElementById('box')
    const myChart = echarts.init(box)
    myChart.setOption(option)
  }
})
