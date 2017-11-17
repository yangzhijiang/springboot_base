package com.yang.service;

import com.yang.dao.entity.AddressDictionaryEntity;
import com.yang.dao.repository.AddressDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yangzhijiang
 * @Date: 14:03 2017/11/17
 * @DESC:
 */

@Service
public class AddressDictionaryService {

    @Autowired
    private AddressDictionaryRepository addressDictionaryRepository;

    public List<AddressDictionaryEntity> getProvinces(){
        return addressDictionaryRepository.findAddressDictionaryEntitiesByParent(0L);
    }

    public List<AddressDictionaryEntity> getCitys(Long parent){
        return addressDictionaryRepository.findAddressDictionaryEntitiesByParent(parent);
    }


}
