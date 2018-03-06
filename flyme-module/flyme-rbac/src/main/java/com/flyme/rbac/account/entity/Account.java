package com.flyme.rbac.account.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.flyme.core.mybatis.base.AbstractEntity;

/**
 * @Author flyme
 * @Date 2018/3/6 14:44
 * @Desc 系统账户表
 */
@TableName("t_rbac_account")
@JsonInclude(Include.NON_NULL)
public class Account extends AbstractEntity {

    @TableId
    private String accountId;
    /**
     * 账户名
     */
    private String accountName;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 密码
     */
    private String pwd;
    /**
     * 手势登录
     */
    private Integer gesture;
    /**
     * 手势密码
     */
    private String gesturePwd;
    /**
     * 盐池
     */
    private String salt;
    /**
     * 微信ID
     */
    private String openId;

    /**
     * 用户类型
     */
    private String accountType;
    /**
     * 登录IP
     */
    private String loginIp;
    /**
     * 最新登录时间
     */
    private String loginDate;

    /**
     * 账户状态
     */
    private Integer accountStatus;


    public Account() {
    }

    public Account(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(String loginDate) {
        this.loginDate = loginDate;
    }

    public Integer getGesture() {
        return gesture;
    }

    public void setGesture(Integer gesture) {
        this.gesture = gesture;
    }

    public String getGesturePwd() {
        return gesturePwd;
    }

    public void setGesturePwd(String gesturePwd) {
        this.gesturePwd = gesturePwd;
    }

    public Integer getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Integer accountStatus) {
        this.accountStatus = accountStatus;
    }
}
