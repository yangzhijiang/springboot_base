package com.yang.service.enums;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yangzhijiang
 * @Date: 17:33 2017/11/17
 * @DESC:
 */
public enum OrderStatusEnum {

//    1 未支付 2 已支付 3 已取消 4 已发货 5 已退款 6 支付中 7 退款中 默认 1 ',
    UNPAY(1,"未支付"),PAYED(2,"已支付"),CANCEL(3,"已取消"),DELIVERY(4,"已发货"),REFUNDED(5,"已退款"),PAYING(6,"支付中"),REFUNDING(7,"退款中");

    private int code;

    private String describe;

    OrderStatusEnum(int code, String describe) {
        this.code = code;
        this.describe = describe;
    }

    public int getCode() {
        return code;
    }

    public String getDescribe() {
        return describe;
    }

    public static Map<Integer,String> getOrderStatus(){

        Map<Integer,String> maps = new HashMap<Integer, String>();
        for(OrderStatusEnum e : OrderStatusEnum.values()){
            maps.put(e.getCode(),e.getDescribe());
        }
        return maps;

    }

}
