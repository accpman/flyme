package com.flyme.rbac.accountinfo.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.flyme.core.mybatis.base.AbstractEntity;


@TableName("t_u_account_info")
@JsonInclude(Include.NON_NULL)
public class AccountInfo extends AbstractEntity {
    @TableId
    private String accountInfoId;
    /**
     * 用户所属区域
     */
    private String areaId;
    /**
     * 姓名
     */
    private String userName;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 头像
     */
    private String userhead;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 工作电话
     */
    private String telephone;
    /**
     * QQ
     */
    private String qq;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 地址
     */
    private String address;
    /**
     * 个人签名
     */
    private String motto;
    /**
     * 职位
     */
    private String positionName;
    /**
     * 是否公开手机号
     */
    private Integer telephoneIsOpen;
    /**
     * 爱好
     */
    private String hobby;
    /**
     * 生日
     */
    private String birthday;
    /**
     * 个人二维码
     */
    private String qrode;

    /**
     * 融云token
     */
    private String rongToken;


    public AccountInfo() {
    }

    public AccountInfo(String accountInfoId) {
        this.accountInfoId = accountInfoId;
    }

    public String getAccountInfoId() {
        return accountInfoId;
    }

    public void setAccountInfoId(String accountInfoId) {
        this.accountInfoId = accountInfoId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserhead() {
        return userhead;
    }

    public void setUserhead(String userhead) {
        this.userhead = userhead;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getQrode() {
        return qrode;
    }

    public void setQrode(String qrode) {
        this.qrode = qrode;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Integer getTelephoneIsOpen() {
        return telephoneIsOpen;
    }

    public void setTelephoneIsOpen(Integer telephoneIsOpen) {
        this.telephoneIsOpen = telephoneIsOpen;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getRongToken() {
        return rongToken;
    }

    public void setRongToken(String rongToken) {
        this.rongToken = rongToken;
    }
}
