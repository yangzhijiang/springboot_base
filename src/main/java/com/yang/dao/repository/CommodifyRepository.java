package com.yang.dao.repository;

import com.yang.dao.entity.Commodify;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;

public interface CommodifyRepository extends CrudRepository<Commodify,Long> {

    Page<Commodify>  findCommodifyBy();

}
