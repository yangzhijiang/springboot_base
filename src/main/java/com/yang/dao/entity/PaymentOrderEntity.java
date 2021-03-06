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
@Table(name = "t_payment_order")
public class PaymentOrderEntity extends BaseEntity {

    @Column(name = "f_order_id")
    private Long orderId;

    @Column(name = "f_payment_price")
    private Integer paymentPrice;

    @Column(name = "f_thr_id")
    private String thrId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getPaymentPrice() {
        return paymentPrice;
    }

    public void setPaymentPrice(Integer paymentPrice) {
        this.paymentPrice = paymentPrice;
    }

    public String getThrId() {
        return thrId;
    }

    public void setThrId(String thrId) {
        this.thrId = thrId;
    }
}
