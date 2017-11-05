<template>
    <div id="details">
        <h1 class="blog_top">认证鉴权与API权限控制在微服务架构中的设计与实现（一）</h1>
        <div class="blog-article_bar">
            <div class="meta">
              <!-- 如果文章更新时间大于发布时间，那么使用 tooltip 显示更新时间 -->
            <span class="publish-time">2017.11.05 08:31</span>
            <span class="wordage">字数 2042</span>
            <span class="views-count">阅读 1340</span><span class="comments-count">评论 49</span><span class="likes-count">喜欢 133</span><span class="rewards-count ">赞赏 1</span></div>
        </div>
        <div style="background:gray">
            内容  正在实现中
        </div>
        <div id="detailsFoot">
            <details-foot></details-foot>
        </div>
       
    </div>
</template>
<script>
import detailsFoot from '@/views/show/blog/DetailsFoot'
export default{
    components:{
        detailsFoot
    }
}
</script>
<style>
#details{
    margin: 30px 150px 2px 150px;
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
    margin-top: 15px;
    overflow: hidden;
}
</style>