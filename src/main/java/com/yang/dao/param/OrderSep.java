package com.yang.dao.param;

import com.yang.dao.entity.OrderEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangzhijiang
 * @Date: 17:19 2017/11/17
 * @DESC:
 */
public class OrderSep implements Specification<OrderEntity> {

    private Integer state;

    private String startTime;

    private String endTime;

    @Override
    public Predicate toPredicate(Root<OrderEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> list = new ArrayList<Predicate>();
        if(null != state){
            list.add(cb.equal(root.get("state").as(Integer.class),state));
        }
        if(!StringUtils.isEmpty(startTime)){
            list.add(cb.greaterThanOrEqualTo(root.get("createTime").as(String.class),startTime));
        }
        if(!StringUtils.isEmpty(endTime)) {
            list.add(cb.lessThanOrEqualTo(root.get("createTime").as(String.class), endTime));
        }

        list.add(cb.equal(root.get("stat").as(Integer.class),1));
        Predicate[] p = new Predicate[list.size()];
        return cb.and(list.toArray(p));
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
