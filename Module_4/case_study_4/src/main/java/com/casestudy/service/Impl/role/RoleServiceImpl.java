package com.casestudy.service.Impl.role;

import com.casestudy.model.Role;
import com.casestudy.repository.role.RoleRepository;
import com.casestudy.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;
    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
