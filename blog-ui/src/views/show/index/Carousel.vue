<template>
    <el-carousel :interval="5000" arrow="always" class="carousel">
        <el-carousel-item>
            <img src="static/img/banner_1.jpg"/>
        </el-carousel-item>
        <el-carousel-item>
            <img src="static/img/banner_2.jpg"/>
        </el-carousel-item>
        <el-carousel-item>
            <img src="static/img/banner_3.jpg"/>
        </el-carousel-item>
    </el-carousel>
</template>

<script>
export default {

}
</script>

<style>
    .carousel{
        border-radius: 10px;
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
</style>