package com.example.monakom_cloud.payment_gateway;

import com.example.monakom_cloud.core.repo.BaseRepository;
import com.example.monakom_cloud.payment_gateway.model.Bank;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends BaseRepository<Bank>
{

}
