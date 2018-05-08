<template>
    <div id="message">
        <el-card class="box-card"  >
            <div slot="header" class="clearfix">
                <span>{{navHeader}}</span>
            </div>
            <comment></comment>
        </el-card>
    </div>
</template>

<script>
import Comment from '@/views/show/comment/Index'
export default {
  components: {
    Comment
  },
  data() {
    return {
      navHeader: ''
    }
  },
  created() {
    this.navHeader = this.$route.query.navHeader
  }
}
</script>

<style rel="stylesheet/scss" lang="scss">
    #message{
        border-radius: 10px;
    }
</style>
