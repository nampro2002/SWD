package com.example.InsuranceCardProject.Service.ServiceImpl;

import com.example.InsuranceCardProject.Entity.Role;
import com.example.InsuranceCardProject.Repository.RoleRepository;
import com.example.InsuranceCardProject.Service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    @Override
    public Role getRoleUser() {
        return roleRepository.findById(2).get();

    }
}
