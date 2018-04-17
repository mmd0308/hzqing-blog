<template>
    <div id="showAppMain" class="showAppMain">
        <carousel></carousel>
        <web-index></web-index>
        <!-- <el-row>
            <el-col :lg="18" :xl="18" >
                <web-index></web-index>
            </el-col>
            <el-col  :lg="6" :xl="6">
                <div class="show-appMain-right hidden-md-and-down">
                    <sidebar></sidebar>
                </div>
            </el-col>
        </el-row> -->
        <works></works>
        <f-links></f-links>
    </div>
</template>

<script>
import WebIndex from '@/views/show/index/Blog'
import Carousel from '@/views/show/index/Carousel'
import FLinks from '@/views/show/index/FLinks'
import Works from '@/views/show/index/Works'
import Sidebar from '@/views/show/indexLayout/Sidebar'
export default {
  components: {
    WebIndex,
    Sidebar,
    Carousel,
    FLinks,
    Works
  }
}
</script>

<style>
</style>
