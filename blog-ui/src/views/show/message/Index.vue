<template>
    <div id="message">
        <show-header :message='msg'></show-header>
        <comment></comment>
    </div>
</template>

<script>
import ShowHeader from '@/components/ShowHeader/index'
import Comment from '@/views/show/comment/Index'
export default {
  components: {
    ShowHeader,
    Comment
  },
  data() {
      return {
          msg: '留言板'
      }
  }
}
</script>

<style rel="stylesheet/scss" lang="scss">
    #message{

    }
</style>
