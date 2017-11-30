<template>
    <div id="detailsFoot">
        <div class="support-author">
                <p>喜欢就告诉我~</p> 
                <div class="btn-pay" @click="supportMoney">赞赏支持</div> 
                <div class="supporter" hidden>
                    <ul class="support-list">
                        <li>
                            <a target="_blank" href="/u/de2100caeda2" class="avatar">
                                <img src="//upload.jianshu.io/users/upload_avatars/8584695/8970ec75-a5e0-4420-b414-7b6fe925c806?imageMogr2/auto-orient/strip|imageView2/1/w/120/h/120">
                            </a>
                        </li>
                    </ul> 
                </div>
        </div>
        <div class="meta-bottom">
            <div class="like" >
                <div class="like" id="noLike" @click="deleSupport" v-if="showLike">
                    <div class="no-like-group no-font-like"> 
                        <div class="btn-like">
                            <i class="iconfont ic-like">喜欢</i>
                        </div> 
                        <div class="modal-wrap no-modal-wrap" >
                            <span v-if="vSupport == null" > 0</span>
                            <span v-else>{{ vSupport }}</span>
                        </div>
                    </div> <!---->
                </div>
                <div class="like-group font-like" v-else @click="saveSupport"> 
                    <div class="btn-like">
                        <i class="iconfont ic-like">喜欢</i>
                    </div> 
                    <div class="modal-wrap" >
                        <span v-if="vSupport == null" > 0</span>
                        <span v-else>{{ vSupport }}</span>
                    </div>
                </div> <!---->
            </div>

            <div class="share-group">
                <li class="share-circle" >
                </li>
                <li class="share-circle" >
                </li>
                <li class="share-circle" >
                </li>
            </div>
        </div>
    </div>
</template>
<script >
import {  saveSupport, deleSupport, getSupportNumByAId } from '@/api/admin/blog/visit'
export default {
    props:['blogId'],
    data() {
        return{
            vSupport: null,
            showLike: false,
            from : this.initObj()
        }
    },
    created() {
        this.getSupportNumByAId();
    },
    methods:{
        initObj(){
            return{
                id: ''
            }
        },
        saveSupport(){
            saveSupport(this.blogId).then(response => {
                this.showLike = true
                this.from = response.data;
                this.getSupportNumByAId();
            })
        },
        deleSupport(){
            deleSupport(this.from.id).then(() =>{
                this.showLike = false;
                this.getSupportNumByAId();
            })
        },
        getSupportNumByAId(){
            getSupportNumByAId(this.blogId).then(response => {
                this.vSupport = response.data
            })
        },
        supportMoney(){
              this.$notify({
                    title: '开发中...',
                    message: '请耐心等待...',
                    type: 'info',
                    duration: 2000
                })
        }
    }
}
</script>

<style>
.support-author{
    padding: 30px 0 20px;
    text-align: center;
    clear: both;
    border-bottom: 1px solid #f0f0f0;
}
.support-author p{
    padding: 0 30px;
    margin-bottom: 20px;
    min-height: 24px;
    font-size: 17px;
}

.support-author .btn-pay {
    margin-bottom: 20px;
    padding: 8px 25px;
    font-size: 16px;
    color: #fff;
    background-color: #ec6149;
    border-radius: 20px;
    display: inline-block;
}
.supporter{
    height: 50px;
}
.supporter ul{
    list-style: none;
    display: inline-block;
    margin-top: 0;
    margin-bottom: 10px;
    padding-left: 0px;
}
.avatar{
    display: block;
    cursor: pointer;
    height: 40px;
    width: 40px;
}
.avatar img{
    width: 100%;
    height: 100%;
    border-radius: 50%;
    border: 3px solid #fff;
}
.meta-bottom{
    margin-top: 30px;
    margin-bottom: 80px;
}
.meta-bottom .like{
    display: inline-block;
}
.like-group{
    padding: 13px 0 10px;
    font-size: 0;
    border: 1px solid #ea6f5a;
    border-radius: 40px;
}
.no-like-group{
    padding: 13px 0 10px;
    font-size: 0;
    border: 1px solid #ea6f5a;
    border-radius: 40px;
    background-color: #ea6f5a;
}
.btn-like{
    font-size: 19px;
    display: inline-block;    
}

.btn-like  i{
    margin-right: 5px;
    font-size: 21px;
    padding: 18px 15px 18px 30px;
    margin-right: 5px;
    font-size: 21px;
}
.no-modal-wrap{
    border-left: 1px solid white !important;
}
.modal-wrap{
    font-size: 18px;
    border-left: 1px solid rgba(236,97,73,.4);
    display: inline-block;
}
.modal-wrap span{
    padding: 18px 30px 18px 17px;
}
.share-group{
    float: right; 
}
.share-circle{
    width: 50px;
    height: 50px;
    margin-left: 5px;
    text-align: center;
    border: 1px solid #dcdcdc;
    border-radius: 50%;
    vertical-align: middle;
    display: inline-block;
}
.font-like{
     color: #ea6f5a;
}
.no-font-like{
     color:white;
}

</style>

