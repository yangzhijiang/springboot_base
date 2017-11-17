package com.yang.dao.entity;



import com.yang.common.base.dao.BaseEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "t_commodify")
public class CommodifyEntity extends BaseEntity {

    @Column(name = "f_commodify_id")
    private String commodifyId;

    @Column(name = "f_name")
    private String name;

    @Column(name = "f_type")
    private Integer type;

    @Column(name = "f_introduce")
    private String introduce;

    @Column(name = "f_price")
    private Integer price;

    @Column(name = "f_showhead_pic")
    private String showheadPic;

    @Column(name = "f_show1_pic")
    private String show1Pic;

    @Column(name = "f_show2_pic")
    private String show2Pic;

    @Column(name = "f_show3_pic")
    private String show3Pic;

    @Column(name = "f_show4_pic")
    private String show4Pic;

    @Column(name = "f_show5_pic")
    private String show5Pic;

    @Column(name = "f_origin_place")
    private String originPlace;

    @Column(name = "f_is_imported")
    private Integer isImported;

    @Column(name = "f_weight")
    private Integer weight;

    @Column(name = "f_state")
    private Integer state;

    public String getCommodifyId() {
        return commodifyId;
    }

    public void setCommodifyId(String commodifyId) {
        this.commodifyId = commodifyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getShowheadPic() {
        return showheadPic;
    }

    public void setShowheadPic(String showheadPic) {
        this.showheadPic = showheadPic;
    }

    public String getShow1Pic() {
        return show1Pic;
    }

    public void setShow1Pic(String show1Pic) {
        this.show1Pic = show1Pic;
    }

    public String getShow2Pic() {
        return show2Pic;
    }

    public void setShow2Pic(String show2Pic) {
        this.show2Pic = show2Pic;
    }

    public String getShow3Pic() {
        return show3Pic;
    }

    public void setShow3Pic(String show3Pic) {
        this.show3Pic = show3Pic;
    }

    public String getShow4Pic() {
        return show4Pic;
    }

    public void setShow4Pic(String show4Pic) {
        this.show4Pic = show4Pic;
    }

    public String getShow5Pic() {
        return show5Pic;
    }

    public void setShow5Pic(String show5Pic) {
        this.show5Pic = show5Pic;
    }

    public String getOriginPlace() {
        return originPlace;
    }

    public void setOriginPlace(String originPlace) {
        this.originPlace = originPlace;
    }

    public Integer getIsImported() {
        return isImported;
    }

    public void setIsImported(Integer isImported) {
        this.isImported = isImported;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
