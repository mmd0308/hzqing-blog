<template>
    <div class="header">
        <el-breadcrumb separator-class="el-icon-arrow-right">
            <svg-icon icon-class="show-index" style="float:left"></svg-icon>
        <el-breadcrumb-item :to="{ path: '/' }">
        首页</el-breadcrumb-item>
        <el-breadcrumb-item>{{ message }}</el-breadcrumb-item>
        </el-breadcrumb>
    </div>
</template>

<script>
export default {
  props: ['message']
}
</script>

<style rel="stylesheet/scss" lang="scss">
    .header{
        padding-bottom: 10px;
        .svg-icon[data-v-c8a70580]{
            width: 1.5em;
            height: 1.5em;
        }
        .el-breadcrumb{
            font-size: 15px;
            line-height: 25px;
        }
        .el-breadcrumb__item{
            padding-left: 6px;
        }
        .el-breadcrumb__inner, .el-breadcrumb__inner a{
            font-weight: normal;
            color: #565b63;
        }
    }
</style>
