<template>
    <div id="sidebar" class="sidebar">
        <div class="sidebar-panel">
            <ul class="sidebar-panel_head"><span>个人简介</span></ul>
            <ul class="profile">    
                <div id="blog_userface">
                    <img src="/static/img/tx.jpg" title="访问我的空间" style="max-width:90%">
                    <br>
                    <span>mmd0308</span>
                </div>
                <ul id="blog_rank">
                    <li>访问：<span>{{ this.visitNum }} 次</span></li>
                    <li>邮箱：<span>mmd0308@126.com</span> </li>    
                    <li>gitHub：<a href='https://github.com/mmd0308'><span style="color:#20a0ff;">『mmd0308』</span></a> </li>    
                    <li>码云：<a href='https://gitee.com/hszj'><span style="color:#20a0ff;">『奋斗吧趁我们还年轻』</span></a> </li>    
                    <li>座右铭：<span>做一个决定，并不难，难的是付诸行动，并且坚持到底</span></li>
                </ul>
            </ul>
        </div>
        <div class="sidebar-panel">
            <ul class="sidebar-panel_head"><span>文章搜索</span></ul>
            <ul class="sidebar-panel_body">    
                <el-input placeholder="请输入内容" v-model="queryArticle" class="input-with-select" @keyup.enter.native="queryArt">
                    <el-button size="small" slot="append" @click="queryArt">搜索</el-button>
                </el-input>
            </ul>

        </div>
        <div class="sidebar-panel">
            <ul class="sidebar-panel_head"><span>文章分类</span></ul>
            <ul class="sidebar-panel_body">    
                <li v-for="(cate,index) in categorys" :key="index" @click="getArticleByCId(cate.id)" class="category_span">
                    <span>{{cate.cateName}} 
                            <span hidden  class="category_number" v-if="cate.artNumber == '' || cate.artNumber == null">
                               (0)
                            </span>
                            <span hidden class="category_number" v-else>
                               ({{cate.artNumber}})
                            </span>
                    </span>
                </li>
            </ul>
        </div>
    </div>
</template>
<script>
import {  getAll} from '@/api/admin/blog/category'
import {  getVisitNum} from '@/api/admin/blog/visit'
export default {
    data() {
        return{
            categorys: null,
            queryArticle: '',
            visitNum: null
        }
    },
    created() {
        this.getCategory();
        this.getVisitNum();
    },
    methods: {
        getCategory(){
            getAll().then(response => {
                this.categorys = response.data
            })
        },
        getArticleByCId(id) {
            this.$parent.$parent.$parent.$refs.blog_index.getBlogListByCId(id);
        },
        queryArt() {
            this.$parent.$parent.$parent.$refs.blog_index.listQuery.arTitle = this.queryArticle;
            this.$parent.$parent.$parent.$refs.blog_index.listQuery.arContent = this.queryArticle;
            this.$parent.$parent.$parent.$refs.blog_index.listQuery.arDesc = this.queryArticle;
            this.$parent.$parent.$parent.$refs.blog_index.getList();
        },
        getVisitNum() {
            getVisitNum().then(response => {
                this.visitNum = response.data
            })
        }
    }
  
}
</script>
 
<style>
.sidebar{
    font-size: 12px;
}
.profile{
    padding: 29px 40px 17px 40px;
    padding-bottom: 5px;
}
.profile #blog_rank{
    padding: 14px 4px 4px 4px;
    border-top: 1px dashed #ccc;
    margin-bottom: 13px;
}
.profile #blog_rank li{
    margin-bottom: 11px;
}
#blog_userface{
    text-align: center;
    font-size: 16px;
    color: #666;
}
#blog_userface span{
    display: block;
    margin: 15px 0;
}
.sidebar-panel_body{
    padding: 0px 16px 17px;
}
.sidebar-panel{
    border: 1px solid #ccc;
    margin-bottom: 9px;
}
.sidebar ul{
    margin-bottom: -4px;
}
.sidebar ul li{
    list-style: none;
}
.sidebar ul span{
    margin-left: 8px;
}

.sidebar ul li a{
    color: #20a0ff;
}

.sidebar-panel_head{
    background: #f5f5f5;
    height: 29px;
    line-height: 29px;
    padding-left: 11px;
    color: #333;
    margin: 0px;
    padding: 0px;
    font-weight: bold;
}
.input-with-select .el-input-group__prepend {
    background-color: #fff;
}
.category_span{
    font-size: 14px;
    color: #20a0ff;
    margin: 3px 0px;
}
.category_number{
    font-size: 13px;
    color: black;
}
</style>
