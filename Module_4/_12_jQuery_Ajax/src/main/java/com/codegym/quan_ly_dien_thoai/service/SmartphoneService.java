package com.codegym.quan_ly_dien_thoai.service;

import com.codegym.quan_ly_dien_thoai.model.SmartPhone;
import org.springframework.stereotype.Service;

@Service
public interface SmartphoneService {
    Iterable<SmartPhone> findAll();
    SmartPhone findById(Integer id);
    SmartPhone save(SmartPhone phone);
    SmartPhone remove(Integer id);
}
