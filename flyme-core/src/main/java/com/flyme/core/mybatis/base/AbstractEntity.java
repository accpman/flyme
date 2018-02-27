package com.flyme.core.mybatis.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;

/**
 * 实体类父类
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(value = {"modifyUser"})
public class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 创建时间
     */
    private String createDate;
    /**
     * 修改时间
     */
    private String modifyDate;
    /**
     * 修改人员
     */
    private String modifyUser;


    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }
}
