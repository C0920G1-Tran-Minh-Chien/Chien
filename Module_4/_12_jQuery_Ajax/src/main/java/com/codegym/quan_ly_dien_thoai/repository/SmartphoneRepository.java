package com.codegym.quan_ly_dien_thoai.repository;

import com.codegym.quan_ly_dien_thoai.model.SmartPhone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepositoryExtensionsKt;
import org.springframework.stereotype.Service;

@Service
public interface SmartphoneRepository extends CrudRepository<SmartPhone, Integer> {
}
