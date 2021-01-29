package com.casestudy.repository.contract;

import com.casestudy.model.Contract;
import com.casestudy.model.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractDetailRepository extends JpaRepository<ContractDetail, Integer> {
    Page<ContractDetail> findByAttachServiceName(String searchString, Pageable pageable);
}
