package com.example.monakom_cloud.repository;

import com.example.monakom_cloud.core.repo.BaseRepository;
import com.example.monakom_cloud.model.pgw.Bank;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends BaseRepository<Bank> {
}
