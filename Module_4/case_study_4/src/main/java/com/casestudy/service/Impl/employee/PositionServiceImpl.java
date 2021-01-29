package com.casestudy.service.Impl.employee;

import com.casestudy.model.Position;
import com.casestudy.repository.employee.PositionRepository;
import com.casestudy.service.employee.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    PositionRepository positionRepository;


    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
