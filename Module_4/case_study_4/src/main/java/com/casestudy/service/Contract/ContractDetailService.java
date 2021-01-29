package com.casestudy.service.Contract;

import com.casestudy.model.Contract;
import com.casestudy.model.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractDetailService {
    List<ContractDetail> findAll();
    void save(ContractDetail contractDetail);

    ContractDetail findById(int id);

    void delete(int id);

    Page<ContractDetail> findAll(Pageable pageable);

    Page<ContractDetail> search(String searchName, Pageable pageable);
}
