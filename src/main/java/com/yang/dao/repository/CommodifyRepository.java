package com.yang.dao.repository;

import com.yang.common.base.dao.BaseRepository;
import com.yang.dao.entity.CommodifyEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CommodifyRepository extends BaseRepository<CommodifyEntity,Long> {


    @Modifying
    @Query("update CommodifyEntity  c set c.state = ?1 where c.id = ?2")
    int updateState(Integer state,Long id );
}
