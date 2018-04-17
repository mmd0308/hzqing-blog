<template>
    <div id="about">
        <show-header :message='msg'></show-header>
    </div>
</template>
<script>
import ShowHeader from '@/components/ShowHeader/index'
export default {
  components: {
    ShowHeader
  },
  data() {
    return {
      msg: '关于我'
    }
  }
}
</script>

<style rel="stylesheet/scss" lang="scss">
#about{
}
</style>
