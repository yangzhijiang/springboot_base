package com.yang.dao.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "t_address_dictionary")
public class AddressDictionaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "f_describe")
    private String describe;

    @Column(name = "f_parent")
    private Long parent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }
}
