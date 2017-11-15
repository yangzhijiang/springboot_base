package com.yang.common.base.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<T,ID extends Serializable> extends JpaRepository<T,ID> ,JpaSpecificationExecutor<T> {


}
