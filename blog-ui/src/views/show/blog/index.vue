<template>
  <div class="showBlog">
      <!-- <show-header :message='msg'></show-header> -->
      <el-row>
            <el-col :lg="18" :xl="18">
                  <web-blog ref="blog"></web-blog>
            </el-col>
            <el-col  :lg="6" :xl="6">
                <div>
                    <web-sidebar v-on:getArticleByLablesId="getArticleByTagId" v-on:getArticleByTitle="getArticleByTitle" ></web-sidebar>
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
      msg: '学无止境'
    }
  },
  methods: {
    getArticleByTagId(tagId) {
      this.$refs.blog.getListByTagId(tagId)
    },
    getArticleByTitle(title) {
      this.$refs.blog.getListByTitle(title)
    }
  }
}
</script>

<style>

</style>
