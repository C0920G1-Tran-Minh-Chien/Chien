package com.codegym.quan_ly_dien_thoai.service;

import com.codegym.quan_ly_dien_thoai.model.SmartPhone;
import com.codegym.quan_ly_dien_thoai.repository.SmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmartphoneServiceImpl implements SmartphoneService {

    @Autowired
    private SmartphoneRepository smartphoneRepository;

    @Override
    public Iterable<SmartPhone> findAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public SmartPhone findById(Integer id) {
        SmartPhone smartphone = findById(id);
        if(smartphone == null){
            return null;
        }
        return smartphone;
    }

    @Override
    public SmartPhone save(SmartPhone phone) {
        return smartphoneRepository.save(phone);
    }

    @Override
    public SmartPhone remove(Integer id) {
        SmartPhone smartphone = findById(id);
        smartphoneRepository.deleteById(id);
        return smartphone;
    }
}
