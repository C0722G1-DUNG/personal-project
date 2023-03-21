package com.example.shopinterior.service.account.impl;


import com.example.shopinterior.entity.account.Role;
import com.example.shopinterior.repository.IRoleRepository;
import com.example.shopinterior.service.account.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepository iRoleRepository;
    /**
     * Created by: CuongVV
     * Date created: 28/2/2023
     * Function: get role admin
     * @param:none
     **/
    @Override
    public Optional<Role> roleAdmin() {
        return iRoleRepository.roleAdmin();
    }
    /**
     * Created by: CuongVV
     * Date created: 28/2/2023
     * Function: get role customer
     * @param:none
     **/
    @Override
    public Optional<Role> roleCustomer() {
        return iRoleRepository.roleCustomer();
    }
    /**
     * Created by: CuongVV
     * Date created: 28/2/2023
     * Function: get role employee
     * @param:none
     **/
    @Override
    public Optional<Role> roleEmployee() {
        return iRoleRepository.roleEmployee();
    }

}
