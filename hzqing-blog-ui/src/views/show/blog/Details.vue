<template>
    <div id="details">
        <h1 class="blog_top">
            {{ form.arTitle }}    
        </h1>
        <div class="blog-article_bar">
            <div class="meta">
              <!-- 如果文章更新时间大于发布时间，那么使用 tooltip 显示更新时间 -->
            <span class="publish-time">2017.11.05 08:31</span>
            <span class="wordage">字数 2042</span>
            <span class="views-count">阅读 1340</span><span class="comments-count">评论 49</span><span class="likes-count">喜欢 133</span><span class="rewards-count ">赞赏 1</span></div>
        </div>
        <div id="content"> 
        <mavon-editor 
            :toolbarsFlag = "toolbarsFlag" 
            :subfield= "false"
            default_open = "preview"
            :value="form.arContentHtml"
        ></mavon-editor>
        </div>
        <div id="detailsFoot">
            <details-foot :blogId="form.id"></details-foot>
        </div>
       
    </div>
</template>
<script>
import {  addObj, getObj } from '@/api/admin/blog/article'
import detailsFoot from '@/views/show/blog/DetailsFoot'

export default{
    components:{
        detailsFoot
    },
    data(){
        return {
            form: this.initObj(),
            toolbarsFlag: false,
            default_open: "preview",
            subfield: false
        }
    },
    created() {
        this.form.id = this.$route.query.blodId;
        this.findById();
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
        }

    }

}
</script>
<style>
#details{
   
    padding: 12px 30px 1px 30px;
}
.meta{
    margin-top: 5px;
    font-size: 12px;
    color: #969696;
}
.meta span{
    padding-right: 6px;
}
.blog_top{
    color: #2c3033;
    font-size: 24px;
    font-weight: bold;
    line-height: 38px;
    margin: 0;
}
.blog-article_bar{
    color: #888;
    font-size: 14px;
    line-height: 38px;
    padding-bottom: 8px;
    margin-top: 5px;
    overflow: hidden;
}

#content{
    margin: 0px;
}

.img-GZQ{
    width : 100% ;
    display : block ;
}
</style>