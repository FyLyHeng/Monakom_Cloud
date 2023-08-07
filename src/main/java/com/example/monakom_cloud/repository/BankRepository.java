package com.example.monakom_cloud.repository;

import com.example.monakom_cloud.model.pgw.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import th.co.geniustree.springdata.jpa.repository.JpaSpecificationExecutorWithProjection;

@Repository
public interface BankRepository extends
        JpaRepository<Bank, Long>,
        JpaSpecificationExecutor<Bank>
        //, JpaSpecificationExecutorWithProjection<Bank, Long>
{


}
