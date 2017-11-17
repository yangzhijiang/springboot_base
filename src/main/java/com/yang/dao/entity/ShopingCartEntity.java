package com.yang.dao.entity;



import com.yang.common.base.dao.BaseEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "t_shoping_cart")
public class ShopingCartEntity extends BaseEntity {


    @Column(name = "f_commodify_info")
    private String commodifyInfo;

    @Column(name = "f_user_id")
    private Long userId;

    public String getCommodifyInfo() {
        return commodifyInfo;
    }

    public void setCommodifyInfo(String commodifyInfo) {
        this.commodifyInfo = commodifyInfo;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
