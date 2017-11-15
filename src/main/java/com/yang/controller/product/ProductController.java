package com.yang.controller.product;

import com.alibaba.fastjson.JSONObject;

import com.yang.common.globalbean.ApiResult;
import com.yang.dao.entity.Commodify;
import com.yang.service.ProductService;
import com.yang.service.query.CommodifyQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "list",method = RequestMethod.POST)
    public ApiResult getList(CommodifyQuery query){


        if(null == query){
            return ApiResult.fail(400,"入参异常");
        }

        Page<Commodify> pages = productService.getListByCondition(query);

        JSONObject obj = new JSONObject();
        obj.put("list",pages.getContent());
        obj.put("totalPages",pages.getTotalPages());
        obj.put("totalElements",pages.getTotalElements());

        return ApiResult.success(obj);
    }


}
