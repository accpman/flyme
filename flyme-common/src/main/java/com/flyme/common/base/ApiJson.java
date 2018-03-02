package com.flyme.common.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonView;
import com.flyme.common.utils.ObjectUtils;
import com.flyme.common.view.AjaxView;

import java.io.Serializable;
import java.util.Map;


/**
 * Ajax请求返回的对象
 */
@JsonInclude(Include.NON_NULL)
public class ApiJson implements Serializable {
    private static final long serialVersionUID = 1L;
    /* 提示信息 */
    @JsonView(AjaxView.class)
    private String info = "";
    /* 状态码(100:成功,101:失败,102:登录超时) */
    @JsonView(AjaxView.class)
    private Integer code = 100;
    /* 返回对象 */
    @JsonView(AjaxView.class)
    private Object object;

    /* 其他参数 */
    private Map<String, Object> attributes;

    public ApiJson() {

    }

    public String getInfo() {
        return info;
    }

    public ApiJson setInfo(String info) {
        this.info = info;
        this.code = 100;
        return this;
    }

    public ApiJson setAppInfo(String info) {
        this.info = info;
        this.code = 100;
        return this;
    }



    public ApiJson setAppError(String info) {
        this.info = info;
        this.code = 101;
        return this;
    }

    public ApiJson setError(String info) {
        this.info = info;
        this.code = 101;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public <T> T getObject() {
        return (T) object;
    }

    public ApiJson setObject(Object object) {
        if (ObjectUtils.isNull(object)) {
            object = new Object();
        }
        this.object = object;
        return  this;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }


    public Boolean success() {
        Boolean tag = false;
        if (code.equals(100)) {
            tag = true;
        }
        return tag;
    }

    public Boolean fail() {
        Boolean tag = false;
        if (code.equals(101)) {
            tag = true;
        }
        return tag;
    }
}