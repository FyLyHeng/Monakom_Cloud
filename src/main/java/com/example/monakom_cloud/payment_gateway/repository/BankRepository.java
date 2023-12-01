package com.example.monakom_cloud.payment_gateway.repository;

import com.example.monakom_cloud.payment_gateway.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends
        JpaRepository<Bank, Long>,
        JpaSpecificationExecutor<Bank>
        //, JpaSpecificationExecutorWithProjection<Bank, Long>
{


}
