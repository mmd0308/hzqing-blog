<template>
    <div id="showIndexSidebar">
        <el-card class="sidebar-box-card">
            <div slot="header" class="clearfix">
                <span>博主</span>
            </div>
            <div v-for="o in 4" :key="o" class="sidebar-text sidebar-item  ">
                <span>博主@的简介</span>
            </div>
        </el-card>
        <el-card class="sidebar-box-card">
            <div slot="header" class="clearfix">
                <span>热门标签</span>
            </div>
            <div class="sidebar-text">
                <wordcloud
                :data="words"
                nameKey="name"
                valueKey="value">
                </wordcloud>

            </div>
        </el-card>
        <el-card class="sidebar-box-card">
            <div slot="header" class="clearfix">
                <span>推荐文章</span>
            </div>
            <div v-for="o in 4" :key="o" class="sidebar-text sidebar-item  ">
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
        }
      ]
    }
  }
}
</script>

<style>
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
