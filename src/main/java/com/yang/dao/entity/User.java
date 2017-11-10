package com.yang.dao.entity;

import com.yang.common.base.BaseEntity;

import javax.persistence.*;
@Entity
@Table(name = "t_user")
public class User extends BaseEntity {


    @Column(name = "f_nick_name")
    private String nickName;

    @Column(name = "f_real_name")
    private String realName;

    @Column(name = "f_phone")
    private String phone;

    @Column(name = "f_password")
    private String password;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
