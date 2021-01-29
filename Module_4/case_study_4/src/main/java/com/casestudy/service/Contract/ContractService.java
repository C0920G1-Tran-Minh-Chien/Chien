package com.casestudy.service.Contract;

import com.casestudy.model.Contract;
import com.casestudy.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractService {
    List<Contract> getAllContract();

    void save(Contract contract);

    Contract findById(int id);

    void delete(int id);

    Page<Contract> findAll(Pageable pageable);

    Page<Contract> search(String searchName, Pageable pageable);
}
