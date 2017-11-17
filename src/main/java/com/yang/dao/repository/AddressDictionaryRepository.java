package com.yang.dao.repository;

import com.yang.common.base.dao.BaseRepository;
import com.yang.dao.entity.AddressDictionaryEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressDictionaryRepository extends BaseRepository<AddressDictionaryEntity,Long> {

    List<AddressDictionaryEntity> findAddressDictionaryEntitiesByParent(Long parent);
}
