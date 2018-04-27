<template>
    <div id="roleMenu" v-loading="menuTreeLoading">
      <el-row>
        <el-col :span="6">
          <el-card>
            <el-tree
                :data="menuTree"
                ref="roleMenuTree"
                show-checkbox
                node-key="id"
                :default-expand-all="true"
                @node-click="clickTree"
                :props="defaultProps">
                </el-tree>
          </el-card>
        </el-col>
        <el-col :span="18">
          <div class="role-dialog-div">
            <el-table
              ref="buttonsTable"
              :data="list"
              style="width: 100%"
              :highlight-current-row="true"
              class="system-table"
              >
                  <el-table-column
                    type="selection"
                    width="55">
                  </el-table-column>
                  <el-table-column
                  label="按钮名称">
                      <template scope="scope">
                          <span style="margin-left: 10px">{{ scope.row.name }}</span>
                      </template>
                  </el-table-column>
                  <el-table-column
                  label="编码">
                      <template scope="scope">
                          <span style="margin-left: 10px">{{ scope.row.code }}</span>
                      </template>
                  </el-table-column>
              </el-table>
          </div>
        </el-col>
      </el-row>
        <div slot="footer" class="dialog-footer" style="text-align:center;">
            <el-button @click="cancel()">取 消</el-button>
            <el-button type="primary" @click="addRoleMenu()">确 定</el-button>
        </div>
    </div>
</template>

<script>
import { tree } from '@/api/admin/system/menu/index'
import { getButtonByMenuIdOrRoleId  } from '@/api/admin/system/button/index'
import { addRoleRes, getResIdByRoleId } from '@/api/admin/system/role/index'
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
      checkRes: {
        menuId: '',
        roleId: '',
        buttons: ''
      },
      list: null,
      roleMenuResId: null,
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
    clickTree(data) {
      this.checkRes.menuId = data.id
      this.checkRes.roleId = ""
      this.getButtonByMenuId(data.id, this.checkRes)
    },
    getButtonByMenuId(id, obj) {
      getButtonByMenuIdOrRoleId(id, obj).then(response => {
        this.list = response.data
        this.$nextTick(() => {
          this.checkButtonByRoleIdAndMenuId(id)
        })
      })
    },
    checkButtonByRoleIdAndMenuId() {
      this.list.forEach(element => {
        if (this.roleMenuResId.indexOf(element.id) != -1) {
          this.$refs.buttonsTable.toggleRowSelection(element);
        }
      })
      // this.list.forEach(row => {
      //     this.$refs.buttonsTable.toggleRowSelection(row)
      // })
      // this.checkRes.roleId = this.roleId
      // this.checkRes.menuId = id
      // getButtonByMenuIdOrRoleId(id, this.checkRes).then(response => {
      //   this.chckList = response.data
      //   this.chckList.forEach(row => {
      //     console.log(row)
      //     this.$refs.buttonsTable.toggleRowSelection(row, true);
      //   })
      // })
    },
    addRoleMenu() {
      var roleId = this.roleId
      var menus = this.$refs.roleMenuTree.getCheckedNodes()
      var menuId = menus.map(menu => menu.id).join()
      this.checkRes.menuId = menuId
      this.checkRes.roleId = roleId
      debugger
      var buttons = this.$refs.buttonsTable.selection.map(button => button.id).join()      
      this.checkRes.buttons = buttons
      addRoleRes(roleId, this.checkRes).then(() => {
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
      getResIdByRoleId(this.roleId).then(response => {
        this.resetChecked()
        this.$refs.roleMenuTree.setCheckedKeys(response.data)
        this.menuTreeLoading = false
        this.roleMenuResId = response.data
      })
    },
    resetChecked() {
      this.$refs.roleMenuTree.setCheckedKeys([])
    },
    cancel() {
      // 清楚按钮选中
      this.$refs.buttonsTable.clearSelection();
      this.$emit('roleMenuCancle', 'cancel')
    }
  }
}
</script>
<style>
.role-dialog-div{
  margin: 0px 15px;
}
</style>
