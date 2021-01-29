package com.casestudy.service.service;


import com.casestudy.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServiceService {
    List<Service> getAllService();

    void save(Service service);

    Service findById(int id);

    void delete(int id);

    Page<Service> findAll(Pageable pageable);

    Page<Service> search(String searchName, Pageable pageable);
}
