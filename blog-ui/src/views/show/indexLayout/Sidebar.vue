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
                <span>热门标签1</span>
            </div>
            <div class="sidebar-text">
                <wordcloud
                fontScale="log"
                :data="words"
                wordPadding="0"
                rotate="rotate"
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
      rotate:{
        from: -60,
        to: 60,
        numOfOrientation: 10 
      },
      words: [
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
