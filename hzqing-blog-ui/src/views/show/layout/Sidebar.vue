<template>
    <div id="sidebar" class="sidebar">
        <div class="sidebar-panel">
            <ul class="sidebar-panel_head"><span>个人简介</span></ul>
            <ul class="profile">    
                <div id="blog_userface">
                    <a href="http://my.csdn.net/mmd0308" target="_blank">
                    <img src="http://avatar.csdn.net/C/4/C/1_mmd0308.jpg" title="访问我的空间" style="max-width:90%">
                    </a>
                    <br>
                    <span><a href="http://my.csdn.net/mmd0308" class="user_name" target="_blank">mmd0308</a></span>
                </div>
                <ul id="blog_rank">
                    <li>访问：<span>22297 次</span></li>
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
                <el-input placeholder="请输入内容" v-model="input5" class="input-with-select">
                    <el-button size="small" slot="append">搜索</el-button>
                </el-input>
            </ul>

        </div>
        <div class="sidebar-panel" v-for="o in 2" :key="o">
            <ul class="sidebar-panel_head"><span>文章分类</span></ul>
            <ul class="sidebar-panel_body">    
                <li v-for="a in 5" :key="a">
                    <span>待开发</span>
                </li>
            </ul>
        </div>
    </div>
</template>
        
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
</style>
