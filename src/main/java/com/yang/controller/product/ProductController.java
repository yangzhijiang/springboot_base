package com.yang.controller.product;

import com.alibaba.fastjson.JSONObject;

import com.yang.common.globalbean.ApiResult;
import com.yang.dao.entity.CommodifyEntity;
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

    /**
     *
     * @param query
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    public ApiResult getList(CommodifyQuery query){


        if(null == query){
            return ApiResult.fail(400,"入参异常");
        }

        Page<CommodifyEntity> pages = productService.getListByCondition(query);

        JSONObject obj = new JSONObject();
        obj.put("list",pages.getContent());
        obj.put("totalPages",pages.getTotalPages());
        obj.put("totalElements",pages.getTotalElements());

        return ApiResult.success(obj);
    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "get",method = RequestMethod.GET)
    public ApiResult get(Long id){

        if(null == id){
            return ApiResult.fail(400,"入参异常");
        }

        CommodifyEntity commodify = productService.getCommodify(id);

        return ApiResult.success(commodify);

    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "online",method = RequestMethod.POST)
    public ApiResult online(Long id){

        if(null == id){
            return ApiResult.fail(400,"入参异常");
        }

        int offlineNum = productService.online(id);
        if(offlineNum > 0){
            return ApiResult.success();
        }else{
            return ApiResult.fail(401,"上线失败！");
        }

    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "offline",method = RequestMethod.POST)
    public ApiResult offline(Long id){

        if(null == id){
            return ApiResult.fail(400,"入参异常");
        }

        int offlineNum = productService.offline(id);
        if(offlineNum > 0){
            return ApiResult.success();
        }else{
            return ApiResult.fail(401,"下线失败！");
        }

    }

    /**
     *
     * @param commodify
     * @return
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public ApiResult add(CommodifyEntity commodify){

        CommodifyEntity commodifyEntity = productService.insertCommodify(commodify);
        if(commodifyEntity != null){
            return ApiResult.success(commodifyEntity);
        }else{
            return ApiResult.fail(402,"保存失败！");
        }

    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ApiResult update(CommodifyEntity commodifyEntity){

        CommodifyEntity commodifyEntity1 = productService.update(commodifyEntity);
        if(commodifyEntity != null){
            return ApiResult.success(commodifyEntity1);
        }else{
            return ApiResult.fail(402,"更新失败！");
        }

    }


}
