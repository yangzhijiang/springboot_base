package com.yang.service;

import com.yang.dao.entity.Commodify;
import com.yang.dao.param.CommoditySep;
import com.yang.dao.repository.CommodifyRepository;
import com.yang.service.query.CommodifyQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private CommodifyRepository commodifyRepository;

    /**
     * 根据条件获取商品列表
     * @param query
     * @return
     */
    public Page<Commodify> getListByCondition(CommodifyQuery query){

        PageRequest pageRequest = buildPageRequest(query);
        Specification<Commodify> commodifySpecification = buildSpecification(query);
        return commodifyRepository.findAll(commodifySpecification,pageRequest);

    }

    private PageRequest buildPageRequest(CommodifyQuery query){

        List<Sort.Order> orders = new ArrayList<Sort.Order>();
        orders.add(new Sort.Order(Sort.Direction.DESC,"createTime"));
        orders.add(new Sort.Order(Sort.Direction.ASC,"price"));

        return new PageRequest(query.getPageNum(),query.getPageSize(),new Sort(orders));

    }

    private Specification<Commodify> buildSpecification(CommodifyQuery query){

        CommoditySep commoditySep = new CommoditySep();
        BeanUtils.copyProperties(query,commoditySep);
        return commoditySep;
    }

    /**
     * 获取商品详情
     * @param id
     * @return
     */
    public Commodify getCommodify(Long id){
        return commodifyRepository.findOne(id);
    }

    /**
     * 商品保存
     * @param commodify
     * @return
     */
    public Commodify insertCommodify(Commodify commodify){
        return commodifyRepository.save(commodify);
    }

    /**
     * 商品下线
     * @param id
     */
    public int offline(Long id){
        return  commodifyRepository.offline(2,id);
    }



}
