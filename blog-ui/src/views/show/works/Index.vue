<template>
    <div id="works">
        <show-header :message='msg'></show-header>
        <div class="works-body fl" style="background:#fff;">
            <el-row>
                <el-col :span="6" v-for="o in 4" :key="o" >
                    <div class="item fl" >
                        <div class="item-img fl">
                            <img src="static/img/timeline.png"/> 
                        </div>
                        <div class="itme-title fl"> 
                            <h2>
                                衡钊清个人博客（hzqing-blog）个人博客
                            </h2>
                            <div class="see-font fl"> 
                                <span>
                                    2018-03-20
                                </span>
                                <span>
                                    阅读 258
                                </span>
                            </div>
                        </div>
                    </div>
                </el-col>
            </el-row>
        </div>
    </div>
</template>

<script>
import ShowHeader from '@/components/ShowHeader/index'
export default {
  components: {
    ShowHeader
  },
  data() {
    return {
      msg: '作品展示'
    }
  }
}
</script>

<style rel="stylesheet/scss" lang="scss">
    #works{
        .works-body{
            border-radius: 10px;
            padding: 20px;
            .item{
                box-sizing: border-box;
                border: 1px solid #eee;
                border-radius: 5px;
                margin-right: 20px;
                margin-bottom: 30px;
                overflow: hidden;
                .item-img{
                    border: none;
                    border-radius: 5px 5px 0 0;
                    img{
                        width: 100%;
                        height: 100%;
                        display: block;
                    }
                }
                .itme-title{
                    padding: 1em;
                    h2{
                        font-weight: normal;
                        margin: 0px 0px 12px;
                        font-size: 14px;
                    }
                    .see-font{
                    	font-size: 12px;
                    }
                }
            }
            .item:nth-child(2n){
                margin-right: 0px;
            }
        }
    }
</style>
