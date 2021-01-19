package com.codeym.service.impl;

import com.codeym.model.Position;
import com.codeym.repository.PositionRepository;
import com.codeym.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionRepository positionRepository;
    @Override
    public List<Position> getAllPosition() {
        return positionRepository.findAll();
    }
}
