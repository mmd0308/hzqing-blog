<template>
    <div id="showAppMain" class="showAppMain">
        <carousel></carousel>
        <web-index></web-index>
        <!-- 作品展示 暂时不展示 -->
        <!-- <works></works> -->
        <f-links></f-links>
    </div>
</template>

<script>
import WebIndex from '@/views/show/index/Blog'
import Carousel from '@/views/show/index/Carousel'
import FLinks from '@/views/show/index/FLinks'
import Works from '@/views/show/index/Works'
// import Sidebar from '@/views/show/indexLayout/Sidebar'
export default {
  components: {
    WebIndex,
    // Sidebar,
    Carousel,
    FLinks,
    Works
  }
}
</script>

<style>
</style>
