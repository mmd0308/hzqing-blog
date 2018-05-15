<template>
  <div class="write">
      <el-row style="height: 100%;">
        <el-col :xs="4" :sm="4" :md="4" :lg="4" :xl="4" style="height: 100%;">
            <tag-index></tag-index>
        </el-col>
        <el-col :xs="20" :sm="20" :md="20" :lg="20" :xl="20" style="height: 100%;" >
            <el-row style="height: 100%;">
                <el-col :xs="7" :sm="7" :md="7" :lg="7" :xl="7" style="height: 100%;">
                  <article-index></article-index>
                </el-col>
                <el-col :xs="17" :sm="17" :md="17" :lg="17" :xl="17" style="height: 100%;">
                   <mk-down-index></mk-down-index>
                </el-col>
            </el-row>
        </el-col>

      </el-row>
  </div>
</template>

<script>
import tagIndex from '@/views/manager/blog/write/TagIndex'
import ArticleIndex from '@/views/manager/blog/write/ArticleIndex'
import MkDownIndex from '@/views/manager/blog/write/MkDownIndex'
export default {
  data() {
    return {
    }
  },
  created() {
  },
  methods: {
  },
  components: {
    tagIndex,
    ArticleIndex,
    MkDownIndex
  }
}
</script>

<style rel="stylesheet/scss" lang="scss">
.write{
    height: 100%;
    background-color: #fff;
}
</style>
