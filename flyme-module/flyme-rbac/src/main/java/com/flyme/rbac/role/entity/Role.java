package com.flyme.rbac.role.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.flyme.core.mybatis.base.AbstractEntity;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author flyme
 * @since 2018-03-06
 */
@TableName("t_rbac_role")
public class Role extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 是否超级管理员
     */
    private Integer isSuper;

    /**
     * 备注
     */
    private String remark;

    public String getRoleId() {
        return roleId;
    }

    public Role setRoleId(String roleId) {
        this.roleId = roleId;
        return this;
    }
    public String getRoleName() {
        return roleName;
    }

    public Role setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }
    public String getRoleCode() {
        return roleCode;
    }

    public Role setRoleCode(String roleCode) {
        this.roleCode = roleCode;
        return this;
    }
    public Integer getIsSuper() {
        return isSuper;
    }

    public Role setIsSuper(Integer isSuper) {
        this.isSuper = isSuper;
        return this;
    }
    public String getRemark() {
        return remark;
    }

    public Role setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    @Override
    public String toString() {
        return "Role{" +
        "roleId=" + roleId +
        ", roleName=" + roleName +
        ", roleCode=" + roleCode +
        ", isSuper=" + isSuper +
        ", remark=" + remark +
        "}";
    }
}
