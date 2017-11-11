<template>
    <div id="menu">
      <el-row  v-loading.body="listLoading">
        <el-col :span="6">
            <el-input placeholder="输入关键字进行过滤" v-model="filterText">
            </el-input>
            <el-tree class="filter-tree" style="margin-top:10px;"  :data="menuTreeDate" 
            :props="defaultProps" :default-expand-all="true"  :filter-node-method="filterNode" 
            :default-expanded-keys="[0,1]" ref="menuTree"
             @node-click="clickTree" @node-expand="expandTree">
            </el-tree>
        </el-col>
        <el-col :span="18">
             <div class="right-layout-from">
                <div v-if="this.state == 'see'" class="top-button">
                    <el-button-group>
                    <el-button type="primary" native-type="submit"  @click="toCreate()" icon="plus">添加</el-button>
                    <el-button type="primary"  @click="toUpdate()" icon="edit">编辑</el-button>
                    <el-button type="danger"  @click="toDeleted()" icon="delete">删除</el-button>
                    </el-button-group>
                </div>
                <div  class="top-button">
                    <el-button v-if="this.state == 'add'" type="primary" native-type="submit"  @click="createMenu('form')">保存</el-button>
                    <el-button v-if="this.state == 'edit'" type="primary" native-type="submit"  @click="updateMenu('form')">保存</el-button>
                </div>
                 <el-card class="box-card" style="margin-bottom: 10px;">
                     <el-form :model="form"  ref="form" label-width="120px" >
                        <el-row aria-disabled="">
                            <el-col :span="8">
                            <el-form-item  label="菜单名称" prop="menuName">
                                <el-input v-model="form.menuName" v-if="this.state == 'see'" disabled="disabled" ></el-input>
                                <el-input v-model="form.menuName" v-else ></el-input>
                            </el-form-item>
                            </el-col>
                            <el-col :span="8">
                                <el-form-item label="父级节点" prop="parentName">
                                    <el-input v-model="form.parentName" disabled="disabled"></el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span="8">
                            <el-form-item label="菜单编码" prop="menuCode">
                                <el-input v-model="form.menuCode" v-if="this.state == 'see'" disabled="disabled" ></el-input>
                                <el-input v-model="form.menuCode" v-else></el-input>
                            </el-form-item>
                            </el-col>
                        </el-row>
                        <el-row>
                            <el-col :span="8">
                                <el-form-item label="资源路径" prop="href">
                                    <el-input v-if="this.state == 'see'" v-model="form.href" disabled="disabled"></el-input>
                                    <el-input v-else v-model="form.href" ></el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span="8">
                                <el-form-item label="前端组件" prop="component">
                                    <el-input v-if="this.state == 'see'" v-model="form.component" disabled="disabled"></el-input>
                                    <el-input v-else v-model="form.component" ></el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span="8">
                                <el-form-item label="图标" prop="icon">
                                    <el-input v-if="this.state == 'see'" v-model="form.icon" disabled="disabled"></el-input>
                                    <el-input v-else v-model="form.icon" ></el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <el-row>
                            <el-col :span="8">
                                <el-form-item label="层级编码" prop="levelcode">
                                    <el-input v-model="form.levelcode" disabled="disabled"></el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span="8">
                                <el-form-item label="是否可用" prop="enabled">
                                    <el-switch on-text="可用" off-text="禁用" on-value='1'  off-value='0' v-model="form.enabled"></el-switch>
                                </el-form-item>
                            </el-col>
                            <el-col :span="8">
                                <el-form-item label="请求资源类型" prop="menuType">
                                    <el-select v-model="form.menuType" placeholder="请选择机构类别" v-if="this.state == 'see'" disabled="disabled" >
                                        <el-option label="link" value="link"></el-option>
                                        <el-option label="menu" value="menu"></el-option>
                                    </el-select>
                                    <el-select v-model="form.menuType" placeholder="请选择机构类别" v-else >
                                        <el-option label="link" value="link"></el-option>
                                        <el-option label="menu" value="menu"></el-option>
                                    </el-select>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <el-form-item label="机构说明" prop="note">
                            <el-input type="textarea" v-model="form.note" v-if="this.state == 'see'" disabled="disabled"></el-input>
                            <el-input type="textarea" v-model="form.note" v-else></el-input>
                        </el-form-item>
                        </el-form>
                </el-card>
             </div>
        </el-col>
      </el-row>
    </div>
</template>

<script>
  import { tree, addObj, getNextLevelCode, putObj, delObj } from '@/api/admin/system/menu/index'
  export default {
    watch: {
        filterText(val) {
            this.$refs.menuTree.filter(val);
        }
    },
    created() {
        this.getTree();
    },
    data(){
        return {
            state: 'see',
            form: this.initObj(),
            filterText: '',
            defaultProps: {
                children: 'menus',
                label: 'menuName'
            },
            menuTreeDate: null,
            listLoading: false
        }
    },
    methods: {
        initObj() {
            return {
                id: '',
                menuName: '',
                menuCode: '',
                levelcode: '',
                parentId: '',
                parentName: '',
                href: '',
                component: '',
                icon: '',
                menuType: '',
                enabled: '0',
                note: ''
            }
        },
        filterNode(value, data) {
            if (!value) return true;
            return data.menuName.indexOf(value) !== -1;
        },
        getTree(){
            tree('-1').then(response => {
                this.menuTreeDate = response.data
                this.form = response.data[0]
                this.state = 'see'
            })
        },
        clickTree(date) {
            this.form = date
            this.state = 'see'
        },
        expandTree(date) {
            console.log('expand')
        },
        toCreate() {
            this.state = 'add'
            var parentId = this.form.id
            var name = this.form.menuName
            var levelcode = this.form.levelcode
            this.resetTemp();
            this.form.parentId = parentId
            this.form.parentName = name
            getNextLevelCode(parentId,levelcode).then(response =>{
                this.form.levelcode = response.data
            })
        },
        createMenu(form) {
            this.$refs[form].validate(vaild =>{
                if(vaild) {
                    addObj(this.form).then(() => {
                        this.getTree();
                        this.$notify({
                            title: '成功',
                            message: '菜单新增成功',
                            type: 'success',
                            duration: 2000
                        })
                    })
                }
            })

        },
        toUpdate() {
            this.state = 'edit'
        },
        updateMenu(form) {
            this.$refs[form].validate(vaild => {
                if(vaild){
                    putObj(this.form.id, this.form).then(() => {
                        this.getTree();
                        this.$notify({
                            title: '成功',
                            message: '菜单修改成功',
                            type: 'success',
                            duration: 2000
                        })
                    })
                }
            })
        },
        toDeleted() {
            this.$confirm('此操作将永久删除, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
                }).then(() => {
                delObj(this.form.id).then(response => {
                    if (response.data) {
                        this.getTree();
                        this.$notify({
                            title: '成功',
                            message: '删除成功',
                            type: 'success',
                            duration: 2000
                        });
                    } else {
                        this.$notify({
                            title: '失败',
                            message: '请先删除下级菜单',
                            type: 'error',
                            duration: 2000
                        });
                    }
                });
            });
        },
        resetTemp() {
            this.form = this.initObj();
        }

    }
  }
</script>
<style>
#menu{
    padding: 20px;
}
.right-layout-from{
  margin-left: 20px;
}
.top-button{
  margin-bottom: 20px;
}
.grid-content{
    border-radius: 4px;
    min-height: 36px;
}
</style>

