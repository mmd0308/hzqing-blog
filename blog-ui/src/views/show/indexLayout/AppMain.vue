<template>
    <div id="showAppMain" class="showAppMain">
        <el-row>
            <el-col :lg="19" :xl="19" >
                <web-index></web-index>
            </el-col>
            <el-col  :lg="5" :xl="5">
                <div class="show-appMain-right hidden-md-and-down">
                    <sidebar></sidebar>
                </div>
            </el-col>
        </el-row>
    </div>
</template>

<script>
import WebIndex from '@/views/show/index/Index'
import Sidebar from '@/views/show/indexLayout/Sidebar'
export default {
  components: {
    WebIndex,
    Sidebar
  }
}
</script>

<style>
.showAppMain{
}
.show-appMain-left{
    margin: 0 2% 0 0;
}
.show-appMain-left .el-card{
    margin-bottom: 18px;
}
.show-appMain-right{

}
.appMain-card-header h3 {
    margin: 0px 0px 15px 0px;
    color: #0593d3;
}
.phone-appMain-card-header h3 {
    margin: 0px;
    color: #0593d3;
}

.show-index-blog-topic-pic{
    width: 85%;
    height: 150px;
    float: left;
}
.user-detail {
    font-size: 15px;
}
.appmain-footer .el-tag{
    color: #fff;
}
.appmain-footer p{
    margin: 20px 0px 0px 0px;
}
.phone-appmain-footer{
    margin: 13px 0px;
    float: left;
}
.readAll{
    padding: 0 10px;
    position: absolute;
    right: 15px;
    bottom: 5px;
    border-radius: 10px;
    color: #fff;
    font-size: 19px;
    background: #34AFD8;
}
.phone-readAll{
    padding: 2px 10px;
    border-radius: 10px;
    color: #fff;
    font-size: 19px;
    background: #34AFD8;
}
</style>
