package com.casestudy.service.Impl.Contract;

import com.casestudy.repository.contract.AttachServiceRepository;
import com.casestudy.service.Contract.AttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceImpl implements AttachService {
    @Autowired
    AttachServiceRepository attachServiceRepository;
    @Override
    public List<com.casestudy.model.AttachService> findAll() {
        return attachServiceRepository.findAll();
    }
}
