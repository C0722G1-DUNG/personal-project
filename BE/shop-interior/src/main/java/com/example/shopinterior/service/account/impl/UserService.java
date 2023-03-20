package com.example.shopinterior.service.account.impl;
import com.example.shopinterior.dto.request.UpdateUserForm;
import com.example.shopinterior.entity.account.Account;
import com.example.shopinterior.entity.account.Role;

import com.example.shopinterior.repository.IUserRepository;
import com.example.shopinterior.service.account.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;
    @Override
    public Account findById(int id) {
        return iUserRepository.findById(id).orElse(null);
    }
    /**
     * Created by: CuongVV
     * Date created: 28/2/2023
     * Function: find user by username
     * @param:username
     **/
    @Override
    public Optional<Account> findByUsername(String username) {
        return iUserRepository.findByUsername(username);
    }

    /**
     * Created by: CuongVV
     * Date created: 28/2/2023
     * Function: update user table to change info user
     * @param:UpdateUserForm
     **/
    @Override
    public void updateUser(UpdateUserForm updateUserForm) {
        iUserRepository.updateUser(updateUserForm.getName(),
                updateUserForm.getPhoneNumber(),
                updateUserForm.getEmail(),
                updateUserForm.getAddress(),
                updateUserForm.getAge(),
                updateUserForm.getGender(),
                updateUserForm.getDateOfBirth(),
                updateUserForm.getAvatar(),
                updateUserForm.getUsername());
    }
    /**
     * Created by: CuongVV
     * Date created: 28/2/2023
     * Function: change password
     * @param:password,username
     **/
    @Override
    public void changePassword(String password, String username) {
        iUserRepository.changePassword(password,username);
    }


    /**
     * Created by: CuongVV
     * Date created: 28/2/2023
     * Function: insert into user to register account
     * @param:name,username,password,email
     **/
    @Override
    public void save(Account user) {
        iUserRepository.save(user.getNameAccount(),user.getUsernameAccount(), user.getEmailAccount(), user.getEncryptPassword());
        Account user1 = iUserRepository.findByUsername(user.getUsernameAccount()).orElse(null);
        for (Role x: user.getRoles()) {
            assert user1 != null;
            iUserRepository.insertRole(user1.getIdAccount(), x.getIdRole());
        }
    }
    /**
     * Created by: CuongVV
     * Date created: 28/2/2023
     * Function: check exists user by username
     * @param:username
     **/

    @Override
    public Boolean existsByUsername(String username) {
        for (int i = 0; i < iUserRepository.getAllUser().size(); i++) {
            if (iUserRepository.getAllUser().get(i).getUsernameAccount().equals(username)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Created by: CuongVV
     * Date created: 28/2/2023
     * Function: check exists user by email
     * @param:email
     **/

    @Override
    public Boolean existsByEmail(String email) {
        for (int i = 0; i < iUserRepository.getAllUser().size(); i++) {
            if (iUserRepository.getAllUser().get(i).getEmailAccount().equals(email)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Created by: CuongVV
     * Date created: 28/2/2023
     * Function: get all user
     * @param:none
     **/


    @Override
    public List<Account> findAll() {
        return iUserRepository.getAllUser();
    }

    /**
     * Created by: CuongVV
     * Date created: 28/2/2023
     * Function: get all user customer
     * @param:email
     **/


    @Override
    public List<Account> findAllCustomer() {
        return iUserRepository.findAllCustomer();
    }
    /**
     * Created by: CuongVV
     * Date created: 28/2/2023
     * Function: get all user employee
     * @param:email
     **/


    @Override
    public List<Account> findAllEmployee() {
        return iUserRepository.findAllEmployee();
    }

    /**
     * Created by: CuongVV
     * Date created: 28/2/2023
     * Function: get all user admin
     * @param:none
     **/
    @Override
    public List<Account> findAllAdmin() {
        return iUserRepository.findAllAdmin();
    }

    @Autowired
    private IUserRepository userRepository;

}