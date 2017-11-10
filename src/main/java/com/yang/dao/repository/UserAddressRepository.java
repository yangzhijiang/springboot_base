package com.yang.dao.repository;

import com.yang.dao.entity.UserAddress;
import org.springframework.data.repository.CrudRepository;

public interface UserAddressRepository extends CrudRepository<UserAddress,Long> {
}
