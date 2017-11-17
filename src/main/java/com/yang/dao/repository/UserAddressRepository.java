package com.yang.dao.repository;

import com.yang.common.base.dao.BaseRepository;
import com.yang.dao.entity.UserAddressEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserAddressRepository extends BaseRepository<UserAddressEntity,Long> {

    @Modifying
    @Query("select UserAddressEntity as  a from a where a.userId = ?1 and a.state = 1 order by a.isDefault desc ,a.createTime desc")
    List<UserAddressEntity> findUserAddressEntitiesByUserIdAndState(Long userId);

    UserAddressEntity findUserAddressEntitieByUserIdAndisDefault(Long userId,int isDefault);

    @Modifying
    @Query("update UserAddressEntity a set a.state = ?2 where a.id = ?1")
    int updateState(Long id,int state);

    @Modifying
    @Query("update UserAddressEntity a set a.isDefault = ?2 where a.id = ?1")
    int updateisDefault(Long id,int isDefault);


}
