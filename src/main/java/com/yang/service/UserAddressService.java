package com.yang.service;

import com.yang.dao.entity.UserAddressEntity;
import com.yang.dao.repository.UserAddressRepository;
import com.yang.service.enums.UserAddressDefaultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yangzhijiang
 * @Date: 14:58 2017/11/17
 * @DESC:
 */

@Service
public class UserAddressService {

    @Autowired
    private UserAddressRepository userAddressRepository;

    public List<UserAddressEntity> getUserAddresss(Long uId){

        return userAddressRepository.findUserAddressEntitiesByUserIdAndState(uId);
    }

    @Transient
    public UserAddressEntity add(UserAddressEntity userAddressEntity,Long uId){

        UserAddressEntity userAddressEntity2 = userAddressRepository.findUserAddressEntitieByUserIdAndisDefault(uId, UserAddressDefaultEnum.DEFAULT.getCode());
        userAddressEntity2.setIsDefault(UserAddressDefaultEnum.NODEFAULT.getCode());
        userAddressRepository.save(userAddressEntity2);
        userAddressEntity.setIsDefault(1);
        UserAddressEntity userAddressEntity1 = userAddressRepository.save(userAddressEntity);
        return userAddressEntity1;

    }

    /**
     * 冻结用户地址
     * @param id
     * @return
     */
    public int invalid(Long id){

        return  userAddressRepository.updateState(id,2);

    }

    public int setDefault(Long id,Long uId){

        UserAddressEntity userAddressEntity2 = userAddressRepository.findUserAddressEntitieByUserIdAndisDefault(uId, UserAddressDefaultEnum.DEFAULT.getCode());
        userAddressEntity2.setIsDefault(UserAddressDefaultEnum.NODEFAULT.getCode());
        userAddressRepository.save(userAddressEntity2);

        return  userAddressRepository.updateisDefault(id,UserAddressDefaultEnum.DEFAULT.getCode());

    }

    public UserAddressEntity update(UserAddressEntity userAddressEntity){

        return  userAddressRepository.save(userAddressEntity);
    }
}
