package com.casestudy.repository.contract;

import com.casestudy.model.Contract;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ContractRepository extends JpaRepository<Contract, Integer> {
    Page<Contract> findByIdContaining(String searchString, Pageable pageable);
}
