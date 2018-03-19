<template>
    <div id="roleMenu" v-loading="menuTreeLoading">
        <el-tree
            :data="menuTree"
            ref="roleMenuTree"
            show-checkbox
            node-key="id"
            :default-expand-all="true"
            :props="defaultProps">
            </el-tree>
        <div slot="footer" class="dialog-footer">
            <el-button @click="cancel()">取 消</el-button>
            <el-button type="primary" @click="addRoleMenu()">确 定</el-button>
        </div>
    </div>
</template>

<script>
import { tree } from '@/api/admin/system/menu/index'
import { addRoleMenu, getMenuIdByRoleId } from '@/api/admin/system/role/index'
export default {
  props: ['roleId'],
  created() {
    this.menuTreeLoading = true
    this.getTree()
  },
  data() {
    return {
      defaultProps: {
        children: 'menus',
        label: 'menuName'
      },
      menuTree: null,
      checkMenu: {
        menuId: '',
        roleId: ''
      },
      menuTreeLoading: false
    }
  },
  methods: {
    getTree() {
      tree('-1').then(response => {
        this.menuTree = response.data
        this.getMenuIdByRoleId()
      })
    },
    addRoleMenu() {
      var roleId = this.roleId
      var menus = this.$refs.roleMenuTree.getCheckedNodes()
      var menuId = menus.map(menu => menu.id).join()
      this.checkMenu.menuId = menuId
      this.checkMenu.roleId = roleId
      addRoleMenu(roleId, this.checkMenu).then(() => {
        this.$notify({
          title: '成功',
          message: '资源添加成功',
          type: 'success',
          duration: 2000
        })
        this.cancel()
      })
    },
    getMenuIdByRoleId() {
      getMenuIdByRoleId(this.roleId).then(response => {
        this.resetChecked()
        this.$refs.roleMenuTree.setCheckedKeys(response.data)
        this.menuTreeLoading = false
      })
    },
    resetChecked() {
      this.$refs.roleMenuTree.setCheckedKeys([])
    },
    cancel() {
      this.$emit('roleMenuCancle', 'cancel')
    }
  }
}
</script>