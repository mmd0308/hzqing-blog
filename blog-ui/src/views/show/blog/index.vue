<template>
  <div class="showBlog">
      <show-header :message='msg'></show-header>
      <el-row>
            <el-col :lg="18" :xl="18">
                  <web-blog></web-blog>
            </el-col>
            <el-col  :lg="6" :xl="6">
                <div>
                    <web-sidebar></web-sidebar>
                </div>
            </el-col>
        </el-row>
  </div>
</template>

<script>
import WebBlog from '@/views/show/blog/blog'
import WebSidebar from '@/views/show/blog/sidebar'
import ShowHeader from '@/components/ShowHeader/index'
export default {
  components: {
    WebBlog,
    WebSidebar,
    ShowHeader
  },
  data() {
    return {
      msg: '关于我'
    }
  }
}
</script>

<style>

</style>
