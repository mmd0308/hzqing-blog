<template>
    <div id="showIndexSidebar">
        <el-card class="sidebar-box-card detail-card">
            <el-input placeholder="请输入内容" v-model="queryAll">
                <!-- <template slot="append">搜 索</template> -->
                 <el-button slot="append" icon="el-icon-search"></el-button>
            </el-input>
        </el-card>
        <el-card class="sidebar-box-card">
            <div slot="header" class="clearfix">
                <span>文章分类</span>
            </div>
            <div v-for="o in 4" :key="o" class="sidebar-text sidebar-item show-index-detail-text">
                <span>填坑系列 --- spring-boot</span>
                <span style="float:right;">2篇</span>
            </div>
        </el-card>
        <el-card class="sidebar-box-card">
            <div slot="header" class="clearfix">
                <span>热门标签</span>
            </div>
            <div class="sidebar-text">
                <el-tag class="sidebar-item-tag" size="medium" color="#F3A557" >ff</el-tag>
                <el-tag class="sidebar-item-tag" size="medium" color="#34AFD8" >中等标签</el-tag>
                <el-tag v-for="o in 5" :key="o" class="sidebar-item-tag" size="medium" color="#F25E45">小型标签</el-tag>
                <el-tag class="sidebar-item-tag" size="medium" color="#F3A557" >Java</el-tag>
                <el-tag class="sidebar-item-tag" size="medium" color="#34AFD8" >中等标签</el-tag>
                <el-tag class="sidebar-item-tag" size="medium" color="#34AFD8" >中等标签</el-tag>
                <el-tag class="sidebar-item-tag" size="medium" color="#34AFD8" >中等标签</el-tag>
                <el-tag class="sidebar-item-tag" size="medium" color="#34AFD8" >中等标签</el-tag>
                <el-tag class="sidebar-item-tag" size="medium" color="#34AFD8" >中等标签</el-tag>
            </div>
        </el-card>
        <el-card class="sidebar-box-card">
            <div slot="header" class="clearfix">
                <span>置顶推荐</span>
            </div>
            <div v-for="o in 4" :key="o" class="sidebar-text sidebar-item show-index-detail-text">
                <span>填坑系列 --- 在SElinux启动情况下docker数据管理</span>
            </div>
        </el-card>
        <el-card class="sidebar-box-card">
            <div slot="header" class="clearfix">
                <span>加入组织</span>
            </div>
            <div class="sidebar-text sidebar-item show-index-detail-text">
                <span>邮箱：mmd0308@126.com</span>
            </div>
        </el-card>
        <el-card class="sidebar-box-card">
            <div slot="header" class="clearfix">
                <span>友情链接</span>
            </div>
            <div class="sidebar-text">
                <el-tag class="sidebar-item-tag" size="medium" color="#F3A557" >ff</el-tag>
                <el-tag class="sidebar-item-tag" size="medium" color="#34AFD8" >中等标签</el-tag>
                <el-tag v-for="o in 5" :key="o" class="sidebar-item-tag" size="medium" color="#F25E45">小型标签</el-tag>
                <el-tag class="sidebar-item-tag" size="medium" color="#F3A557" >Java</el-tag>
                <el-tag class="sidebar-item-tag" size="medium" color="#34AFD8" >中等标签</el-tag>
                <el-tag class="sidebar-item-tag" size="medium" color="#34AFD8" >中等标签</el-tag>
                <el-tag class="sidebar-item-tag" size="medium" color="#34AFD8" >中等标签</el-tag>
                <el-tag class="sidebar-item-tag" size="medium" color="#34AFD8" >中等标签</el-tag>
                <el-tag class="sidebar-item-tag" size="medium" color="#34AFD8" >中等标签</el-tag>
            </div>
        </el-card>        
    </div>
</template>

<script>
export default {
  data() {
    return {
      queryAll: ''
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
