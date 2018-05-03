<template>
  <div class="leftSideBar ">
    <ul>
        <li @click="clickSiberItem('basic')" :class="{clickSiber:clickSidber === 'basic'}">
            <span>基础设置</span>
        </li>
        <li @click="clickSiberItem('person')" :class="{clickSiber:clickSidber === 'person'}">
            <span>个人资料</span>
        </li>
        <li @click="clickSiberItem('weibo')" :class="{clickSiber:clickSidber === 'weibo'}">
            <span>微博认证</span>
        </li>
    </ul>
  </div>
</template>

<script>
export default {
  props: {
    createBar: {
      type: String,
      default: ''
    }
  },
  data() {
    return{
      clickSidber: this.createBar
    }
  },
  methods: {
    clickSiberItem(item) {
      this.clickSidber = item
      this.$emit("getRightMsg",item)
    }
  }
}
</script>

<style rel="stylesheet/scss" lang="scss">
.leftSideBar{
    padding: 0px;
    background: #fff;
    overflow: auto;
    height: fit-content;
    margin-right: 20px;
    ul {
        padding: 0px;
        margin: 0px;
        li{
            height: 50px;
            border-bottom: 1px solid #e5e5e5;
            font-size: 14px;
            line-height: 50px;
        }
        li:hover{
            background: #ff7d44;
        }
        .clickSiber{
            background: #ff7d44;
        }
        span {
            padding: 0px 15px;
            display: block;
        }
    }
}
</style>
