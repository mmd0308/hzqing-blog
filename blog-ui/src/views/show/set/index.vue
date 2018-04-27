<template>
  <div class="set">
      <!-- <show-header :message='msg'></show-header> -->
      <el-row>
        <el-col :xs="0" :sm="6" :md="6" :lg="6" :xl="6">
          <side-bar @getRightMsg="getRight" ></side-bar>
        </el-col>
        <el-col :xs="24" :sm="18" :md="18" :lg="18" :xl="18">
          <basic-set v-if="checkRightCom === 'basic'"></basic-set>
        </el-col>
      </el-row>
  </div>
</template>

<script>
import SideBar from '@/views/show/set/sidebar'
import BasicSet from '@/views/show/set/basicSet'
import ShowHeader from '@/components/ShowHeader/index'
export default {
  components: {
    SideBar,
    BasicSet,
    ShowHeader
  },
  data() {
    return {
      msg: '设置',
      checkRightCom: ''
    }
  },
  methods: {
    getRight(data) {
      this.checkRightCom = data
    }
  }
}
</script>

<style rel="stylesheet/scss" lang="scss">
.set {
}
</style>
