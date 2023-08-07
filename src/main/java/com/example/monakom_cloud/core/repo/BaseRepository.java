package com.example.monakom_cloud.core.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import th.co.geniustree.springdata.jpa.repository.JpaSpecificationExecutorWithProjection;

@NoRepositoryBean
public interface BaseRepository<T> extends
        JpaRepository<T, Long>,
        JpaSpecificationExecutor<T>,
        JpaSpecificationExecutorWithProjection<T, Long>
{

}
