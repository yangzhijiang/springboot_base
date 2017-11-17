package com.yang.service.query;

import com.yang.common.exception.ServiceException;
import com.yang.service.enums.OrderStatusEnum;

/**
 * @Author: yangzhijiang
 * @Date: 17:08 2017/11/17
 * @DESC:
 */
public class OrderQuery {

    private final Integer PAGE_SIZE = 15;

    private Integer pageNum;

    private Integer pageSize ;

    private Integer state;

    private String startTime;

    private String endTime;

    public Integer getPageNum() {

        if(null != pageNum&&pageNum > 0){
            return pageNum-1;
        }
        return 0;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {

        if(null == pageSize){
            return PAGE_SIZE;
        }

        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {

        if(!OrderStatusEnum.getOrderStatus().containsKey(state)){
            throw new ServiceException(406,"订单状态非法！");
        }
        this.state = state;

    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
