package com.yang.dao.entity;



import com.yang.common.base.dao.BaseEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "t_order")
public class Order extends BaseEntity {

    @Column(name = "f_commofify_info")
    private String commodifyInfo;

    @Column(name = "f_user_id")
    private Long userId;

    @Column(name = "f_discount_type")
    private Integer discountType;

    @Column(name = "f_discount_price")
    private Integer discountPrice;

    @Column(name = "f_order_price")
    private Integer orderPirce;

    @Column(name = "f_price")
    private Integer price;

    @Column(name = "f_address_info")
    private String addressInfo;

    @Column(name = "f_payment_mode")
    private Integer paymentMode;

    @Column(name = "f_order_id")
    private Long orderId;

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

    public Integer getDiscountType() {
        return discountType;
    }

    public void setDiscountType(Integer discountType) {
        this.discountType = discountType;
    }

    public Integer getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Integer discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Integer getOrderPirce() {
        return orderPirce;
    }

    public void setOrderPirce(Integer orderPirce) {
        this.orderPirce = orderPirce;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(String addressInfo) {
        this.addressInfo = addressInfo;
    }

    public Integer getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(Integer paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
