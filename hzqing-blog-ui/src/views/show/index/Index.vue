<template>
    <div id="sIndex">
        <el-carousel indicator-position="outside" ref="index_carousel">
            <el-carousel-item>
            <h3>待开发...</h3>
            </el-carousel-item>
             <el-carousel-item>
            <h3>待开发...</h3>
            </el-carousel-item>
        </el-carousel>
        <div class="list-div-item" v-for="(o,index) in list" :key="index" >
            <div class="list-div-item-title">
                <i class="iconfont hzqing-blog-yuan"></i>
                <h1>
                    <span class="link_title" @click="toDetail(o.id)">
                            <font color="red" v-if="o.arUp == 'Y'">[置顶]</font>
                            <span>
                                {{ o.arTitle }}
                            </span>
                    </span>
                </h1>
            </div>
            <div class="list-div-item-description">
                {{ o.arDesc }}
            </div>
            <div class="article_manage">
                <span class="link_comments">
                    {{ o.arCtime | formatDate }}
                </span>
                <span class="link_comments" title="待开发...">
                    <i class="iconfont hzqing-blog-yuedu"></i>
                    <span class="yuedu_tubiao">阅读</span>(143)
                </span>
                <span class="link_comments" title="待开发...">
                    <i class="iconfont hzqing-blog-tubiao"></i>
                    <span class="yuedu_tubiao">评论</span>(0)
                </span>
            </div>
        </div>
        <div class="pagination-container">
            <el-pagination @size-change="handleSizeChange" 
                            @current-change="handleCurrentChange"
                            :current-page.sync="listQuery.page"
                            :page-sizes="[15,30,50,100]" 
                            :page-size="listQuery.pageSize"
                            layout="total, sizes, prev, pager, next, jumper" 
                            :total="total">
            </el-pagination>
        </div>
    </div>
</template>
<script>
import {  page, getObj, pageByCid } from '@/api/admin/blog/article'
import detailsFoot from '@/views/show/blog/DetailsFoot'
import { formatDate} from '@/utils/date'
export default {
    filters: {
      formatDate(time) {
        var date = new Date(time);
        return formatDate(date, 'yyyy-MM-dd hh:mm');
      }
    },
    components:{
        detailsFoot
    },
    data(){
        return {
            form: this.initObj(),
            listQuery:{
                page: 1,
                pageSize: 15,
                arState: 'FB',
                cateId: [],
                arContent: '',
                arTitle: '',
                arLabel:'',
                arDesc: ''
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
                arDesc: '',
                arUp: '',
                arState: ''
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
        },
        handleSizeChange(val) {
            this.listQuery.pageSize = val
            this.getList();
        },
        handleCurrentChange(val) {
            this.listQuery.page = val
            this.getList();
        },
        toDetail(id) {
            this.$router.push({
                path: '/details',
                query: {
                    blodId: id 
                    }
                })
        },
        getBlogListByCId(id){
            this.listQuery.cateId = id
            pageByCid(this.listQuery).then(response => {
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
.yuedu_tubiao{
    color: #20a0ff;
}
.link_comments{
    margin-right: 16px;
}

.list-div-item-title h1{
    padding: 0;
    margin: 0;
    display: inline-block;
}
.list-div-item{
    border-bottom: 1px solid #e9e9e9;
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
.pagination-container{
    margin: 23px 20px 39px 40px;
}
</style>