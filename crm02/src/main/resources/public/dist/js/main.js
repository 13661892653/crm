require.config({
  paths: {
    "jquery": 'lib/jquery-1.10.2.min',
    "echart": 'lib/echarts.min',
    "vue": 'lib/vue',
    "axios": 'lib/axios.min'
  }
})

require(['vue', 'echart', 'axios'], function(Vue, echarts, axios) {

  const defaultOption = {
    tooltip: {
      trigger: 'item',
      formatter: '{a} <br /> {b}  {c}'
    },
    xAxis: {
      data: '',
      axisLine: {
        lineStyle: {
          color: "#adadad"
        }
      },
      axisTick: {
        alignWithLabel: true
      }
    },
    yAxis: {
      type: 'value',
      axisLine: {
        lineStyle: {
          color: '#adadad'
        }
      }
    },
    series: []
  }

  const pieOption = {
    tooltip: {
      trigger: 'item',
      formatter: '{a} <br /> {b}  {c}'
    },
    series: []
  }

  const dataSource = [
    { name: "上海 3月份 天气", url: "http://localhost:8080/assets/data/weather_02.json" },
    { name: "上海 4月份 天气", url: "http://localhost:8080/assets/data/weather.json" },
    { name: "居民收支", url: "http://localhost:8080/assets/data/incomes.json" },
  ]

  const color = {
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
      //刚刷新页面，没选数据源时
    created: function() {
      const _this = this
      axios({
        methods: 'get',
        //url: 'http://127.0.0.1:8080/data/weather.json',
        responseType: 'json',
      }).then((res) => {
        const result = res.data
        _this.data = result  //数据
        _this.option.xAxis.data = result.record.map(function(item) {return item[result.dimension[0].name]})  //X轴
        _this.chartStyle = result.type   //图形类型
      })
    },
    data: {
      data: '',
      type: '',
      option: defaultOption,
      cb: false,
      labelItem: [],
      colorBox: color,
      chartStyle: '',
      dataSource: dataSource,
      labelChecked: false
    },
    methods: {
      // 添加数值
      addSeries: function(label, alias) {
        // console.log(label);
        const c = this.colorBox.colorful[Math.floor(Math.random() * 6)].hex

        const se = {
          name: label,
          type: 'bar',
          data: this.data.record.map(function(item) {return item[label]}),
          label: {
            normal: {
              show: this.labelChecked === false ? false : true,
              position: 'top',
              textStyle: {
                color: '#666'
              }
            }
          },
          itemStyle: {
            normal: {
              color: c
            }
          }
        }

        this.option.series.push(se)
        chart(this.option)

        const ci = {
          label: label,
          name: alias,
          color: c
        }
        this.labelItem.push(ci)
      },
      // 颜色
      setColor: function(label) {
        this.cb = !this.cb
        this.colorBox.goal = label
      },
      //设置颜色
      changeColor: function(color) {
        // console.log(color);
        // console.log(this.colorBox.goal);
        var _this = this
        this.option.series.forEach(function(s) {
          if (s.name === _this.colorBox.goal) {
            s.itemStyle.normal.color = color
          }
        })
        this.labelItem.forEach(function(c) {
          if (c.label === _this.colorBox.goal) {
            c.color = color
          }
        })
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
        const _this = this
        this.data = ''
        this.option.xAxis = {}
        this.option.xAxis.data = ''
        this.option.series = []
        this.labelItem = []
        this.chartStyle = ''
        chart(this.option)
        axios({
          url: url,
          methods: 'get',
          responseType: 'json'
        }).then((res) => {
          const result = res.data
          _this.data = result  //数据
          _this.chartStyle = result.type   //图形类型
          _this.option.xAxis.data = result.record.map(function(item) {return item[result.dimension[0].name]})   //X轴
        })
      },
      // 显示图表标签
      showLabel: function() {
        const len = this.option.series.length
        for (var i = 0; i < len; i++) {
          this.option.series[i].label.normal.show = this.labelChecked
        }
        chart(this.option)
      },
      // 删除数值
      deleteSeries: function(label) {
        console.log(label);
        var len = this.option.series.length
        for (var i = 0; i < len; i++) {
          if(this.option.series[i].name == label) {
            this.option.series.splice(i, 1)
            break
          }
        }
        for (var i = 0; i < len; i++) {
          if(this.labelItem[i].label == label) {
            this.labelItem.splice(i, 1)
            break
          }
        }
        chart(this.option)
      }
    }
  })

  function chart(option) {
    const box = document.getElementById('box')
    const myChart = echarts.init(box)
    myChart.setOption(option)
  }
})
