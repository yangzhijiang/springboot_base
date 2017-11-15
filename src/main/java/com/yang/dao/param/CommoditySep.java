package com.yang.dao.param;

import com.yang.dao.entity.Commodify;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CommoditySep implements Specification<Commodify> {

    private Integer type;

    private Integer isImported;

    private Integer startPrice;

    private Integer endPrice;


    @Override
    public Predicate toPredicate(Root<Commodify> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> list = new ArrayList<Predicate>();
        if(null!= type){
            list.add(cb.equal(root.get("type").as(Integer.class),type));
        }
        if(null!=isImported){
            list.add(cb.equal(root.get("isImported").as(Integer.class),isImported));
        }
        if(null!=startPrice) {
            list.add(cb.greaterThanOrEqualTo(root.get("price").as(Integer.class), startPrice));
        }
        if(null!=endPrice){
            list.add(cb.lessThanOrEqualTo(root.get("price").as(Integer.class),endPrice));
        }
        list.add(cb.equal(root.get("stat").as(Integer.class),1));
        list.add(cb.equal(root.get("state").as(Integer.class),1));
        Predicate[] p = new Predicate[list.size()];
        return cb.and(list.toArray(p));
    }


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIsImported() {
        return isImported;
    }

    public void setIsImported(Integer isImported) {
        this.isImported = isImported;
    }

    public Integer getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Integer startPrice) {
        this.startPrice = startPrice;
    }

    public Integer getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(Integer endPrice) {
        this.endPrice = endPrice;
    }


}
