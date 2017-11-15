package com.yang.dao.repository;

import com.yang.common.base.dao.BaseRepository;
import com.yang.dao.entity.ShopingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ShopingCartRepository extends BaseRepository<ShopingCart,Long> {
}
