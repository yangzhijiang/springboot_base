package com.yang.controller.address;

import com.yang.common.globalbean.ApiResult;
import com.yang.dao.entity.AddressDictionaryEntity;
import com.yang.service.AddressDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: yangzhijiang
 * @Date: 14:30 2017/11/17
 * @DESC:
 */

@RestController
@RequestMapping("address")
public class AddressDictionaryController {

    @Autowired
    private AddressDictionaryService addressDictionaryService;

    @RequestMapping(value = "getprovinces")
    public ApiResult getProvinces(){

        List<AddressDictionaryEntity> addressDictionaryEntities = addressDictionaryService.getProvinces();

        return ApiResult.success(addressDictionaryEntities);
    }

    @RequestMapping(value = "getcitys")
    public ApiResult getCitys(Long id){

        if(null == id){
            return ApiResult.fail(400,"入参异常");
        }

        List<AddressDictionaryEntity> addressDictionaryEntities = addressDictionaryService.getCitys(id);

        return ApiResult.success(addressDictionaryEntities);
    }


}
