<template>
  <div class="showBlog">
        <div class="blog">
          <web-blog ref="blog"></web-blog>
        </div>
        <div class="blog-sidebar">
          <web-sidebar v-on:getArticleByLablesId="getArticleByTagId" v-on:getArticleByTitle="getArticleByTitle" ></web-sidebar>
        </div>
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

<style rel="stylesheet/scss" lang="scss">
  .showBlog{
    display: var(--hzq-blog-index-display);
    .blog{
      display: var(--hzq-blog-display);
      vertical-align: top;
      width: var(--hzq-blog-width);
    }
    .blog-sidebar {
      width:300px;
      display: var(--hzq-blog-sidebar-display)
    }
  }

</style>
