<template>
    <div class="showWebIndex">
        <div class="show-appMain-left">
            <el-card class="box-card" v-for="o in 5" :key="o">
                <div class="appMain-card-header">
                    <router-link to="/detail">
                        <h3>最适合入门的Laravel初级教程(七)</h3>
                    </router-link>
                </div>
                <div>
                    <el-row>
                            <el-col class="hidden-md-and-down" :md="2" :lg="5" :xl="5">
                            <img class="show-index-blog-topic-pic" width="100%" src="https://baijunyao.com/uploads/article/20180106/5a50792eeef57.jpg" alt="">
                        </el-col>
                        <el-col :md="22" :lg="19" :xl="19">
                            <div class="user-detail">
                                <p style="padding-top:0px;"> 
                                    <span class="author">作者</span> / 
                                    <span class="author">分类</span> / 
                                    2016-6-21 23:23 / 阅读: 27371</p> 
                            </div>
                            <div class="show-index-blog-abstract show-index-detail-text">
                                看到这的时候我默认你已经配置好数据库了； 我们开始对数据库操作了； 但是前提是我们得有表啊； 说到数据库说到表； 做开发的小伙伴们肯定理解到过其中的苦于泪； 还是环境的问题； 每个同事都有一个自己的本地环境； 还有测试环境、生产环境； 团队合作的时候为了避免代码冲突； 以及方便记录修改历史和回退； 我们有版本控制比如说 git； 但是数据库怎么搞呢？ 在远古时代； 在中小...
                            </div>
                            <div class="appmain-footer">
                                <p>
                                    <el-tag size="medium" color="#F3A557" >ff</el-tag>
                                    <el-tag size="medium" color="#34AFD8" >中等标签</el-tag>
                                    <el-tag size="medium" color="#F25E45">小型标签</el-tag>
                                    <span class="readAll">阅读全文</span>
                                </p>
                            </div>
                        </el-col>
                    </el-row>
                </div>
            </el-card>
            <div class="block" style="text-align: center;">
                <el-pagination
                    background
                    layout="prev, pager, next"
                    :total="1000">
                </el-pagination>
            </div>
        </div>
    </div>
</template>

<script>
export default {

}
</script>

<style>
</style>
