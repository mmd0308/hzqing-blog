<template>
    <div id="showIndexSidebar">
        <el-card class="sidebar-box-card">
            <div slot="header" class="clearfix">
                <span>博主</span>
            </div>
            <div v-for="o in 4" :key="o" class="sidebar-text sidebar-item">
                <span>博主@的简介</span>
            </div>
        </el-card>
        <el-card class="sidebar-box-card">
            <div slot="header" class="clearfix">
                <span>热门标签2</span>
            </div>
            <div class="sidebar-text">
                <wordcloud
                :data="words"
                wordPadding="0"
                fontScale="n"
                nameKey="name"
                spiral="rectangular"
                :rotate="rotate"
                valueKey="value">
                </wordcloud>

            </div>
        </el-card>
        <el-card class="sidebar-box-card">
            <div slot="header" class="clearfix">
                <span>推荐文章</span>
            </div>
            <div v-for="o in 4" :key="o" class="sidebar-text sidebar-item">
                <span>填坑系列 --- 在SElinux启动情况下docker数据管理</span>
            </div>
        </el-card>     
    </div>
</template>

<script>
import wordcloud from 'vue-wordcloud'
export default {
  components: {
    wordcloud
  },
  data() {
    return {
      queryAll: '',
      rotate:{
          from: -60,
          to: 90,
          numOfOrientation: 10 
      },
      words: [{
          "name": "Cat",
          "value": 26
        },
        {
          "name": "暂时",
          "value": 19
        },
        {
          "name": "things",
          "value": 18
        },
        {
          "name": "look",
          "value": 16
        },
        {
          "name": "two",
          "value": 15
        },
        {
          "name": "fun",
          "value": 9
        },
        {
          "name": "know",
          "value": 9
        },
        {
          "name": "good",
          "value": 9
        },
        {
          "name": "play",
          "value": 6
        },
        {
          "name": "fish",
          "value": 19
        },
        {
          "name": "测试",
          "value": 18
        },
        {
          "name": "Java",
          "value": 16
        },
        {
          "name": "错误",
          "value": 15
        },
        {
          "name": "fun",
          "value": 9
        },
        {
          "name": "Hadoop",
          "value": 9
        },
        {
          "name": "good",
          "value": 9
        },
        {
          "name": "play",
          "value": 6
        },
        {
          "name": "hzqing-a",
          "value": 6
        },
        {
          "name": "hzqing-b",
          "value": 6
        },
        {
          "name": "hzqing-c",
          "value": 6
        },
        {
          "name": "hzqing-d",
          "value": 6
        },
        {
          "name": "hzqing-f",
          "value": 6
        }
      ]
    }
  }
}
</script>

<style>
#showIndexSidebar{
    margin-left: 15px;
}
.sidebar-box-card{
    margin-bottom: 18px;
}
.sidebar-text {
    font-size: 14px;
}

.sidebar-item {
    margin-bottom: 18px;
}
.sidebar-item-tag{
    color: #fff;
    margin: 3px 4px;
    border-radius: 15px;
}
</style>
