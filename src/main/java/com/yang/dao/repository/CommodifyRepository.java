package com.yang.dao.repository;

import com.yang.common.base.dao.BaseRepository;
import com.yang.dao.entity.Commodify;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CommodifyRepository extends BaseRepository<Commodify,Long> {


    @Modifying
    @Query("update Commodify  c set c.state = ?1 where c.id = ?2")
    int offline(Integer state,Long id );
}
