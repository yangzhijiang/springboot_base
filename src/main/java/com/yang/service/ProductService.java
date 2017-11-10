package com.yang.service;

import com.yang.dao.repository.CommodifyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private CommodifyRepository commodifyRepository;

}
