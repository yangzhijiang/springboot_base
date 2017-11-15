package com.yang.service.query;


public class CommodifyQuery {

    private final Integer PAGE_SIZE = 15;

    private Integer pageNum;

    private Integer pageSize ;

    private Integer type;

    private Integer isImported;

    private Integer startPrice;

    private Integer endPrice;

    public Integer getPageNum() {
        if(pageNum != null && pageNum > 1){
            return pageNum - 1;
        }else{
            return 0;
        }

    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {

        if(null == pageSize){
           return PAGE_SIZE;
        }else{
            return pageSize;
        }
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIsImported() {
        return isImported;
    }

    public void setIsImported(Integer isImported) {
        this.isImported = isImported;
    }

    public Integer getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Integer startPrice) {
        this.startPrice = startPrice;
    }

    public Integer getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(Integer endPrice) {
        this.endPrice = endPrice;
    }
}
