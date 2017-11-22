<template>
    <div id="sIndex">
        <el-carousel indicator-position="outside">
            <el-carousel-item v-for="item in 4" :key="item">
            <h3>{{ item }}</h3>
            </el-carousel-item>
        </el-carousel>
        <div class="list-div-item" v-for="o in list" :key="o" >
            <div class="list-div-item-title">
                <i class="iconfont hzqing-blog-yuan"></i>
                <h1>
                    <span class="link_title">
                        <router-link to="/details">
                            <font color="red">[置顶]</font>
                                {{ o.arTitle }}
                        </router-link>
                    </span>
                </h1>
            </div>
            <div class="list-div-item-description">
                {{ o.arDesc }}
            </div>
            <div class="article_manage">
                <span class="link_postdate">2017-07-20 08:48</span>
                <span class="link_view" title="阅读次数">
                    <i class="iconfont hzqing-blog-yuedu"></i>
                    <a href="/mmd0308/article/details/75453720" title="阅读次数">阅读</a>(143)
                </span>
                <span class="link_comments" title="评论次数">
                    <i class="iconfont hzqing-blog-tubiao"></i>
                    <a href="/mmd0308/article/details/75453720#comments" title="评论次数" onclick="_gaq.push(['_trackEvent','function', 'onclick', 'blog_articles_pinglun'])">评论</a>(0)
                </span>
            </div>
        </div>
    </div>
</template>
<script>
import {  page, getObj } from '@/api/admin/blog/article'
import detailsFoot from '@/views/show/blog/DetailsFoot'
export default{
    components:{
        detailsFoot
    },
    data(){
        return {
            form: this.initObj(),
            listQuery:{
                page: 1,
                pageSize: 10
            },
            list: null,
            total: null
        }
    },
    created() {
        this.getList();
    },
    methods: {
        initObj() {
            return {
                id: '',
                arTitle: '',
                arContent: '',
                arContentHtml: '',
                arDesc: ''
            }
        },
        findById() {
            getObj(this.form.id).then(response => {
                this.form = response.data
                console.log(response.data)
            })
        },
        getList() {
            page(this.listQuery).then(response => {
                this.list = response.data.list
                this.total = response.data.total
            })
        }

    }

}
</script>
<style>
.article_manage{
    margin-bottom: 10px;
    text-align: right;
    color: #999;
    font-size: 12px;
}
.article_manage span{
    margin-right: 16px;
}
.article_manage span a{
    color: #20a0ff;
}
.list-div-item-title h1{
    padding: 0;
    margin: 0;
    display: inline-block;
}
.list-div-item{
    border: 1px solid #e9e9e9;
    margin: -1px 0 0 0;
    padding: 12px 30px 1px 30px;
}
.list-div-item-title{
    font-size: 17px;
    margin-bottom: 17px;
}
.list-div-item-description{
    text-indent: 2em;
    font: 14px/24px 'microsoft yahei';
    color: #666;
    margin: -10px 0 10px 0;
}
.link_title{
    font-weight: normal;
    font-size: 18px;
}
.el-carousel__item h3 {
    color: #475669;
    font-size: 18px;
    opacity: 0.75;
    line-height: 300px;
    margin: 0;
}
.el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
}
.el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
}
.el-carousel__container{
    position: relative;
    height: 180px;
}
</style>