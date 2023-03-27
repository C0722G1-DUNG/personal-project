package com.example.shopinterior.service.account;

import com.example.shopinterior.dto.request.UpdateUserForm;
import com.example.shopinterior.entity.account.User;


import java.util.List;
import java.util.Optional;

public interface IUserService {
    User findById(int id);

    /**
     * Created by: CuongVV
     * Date created: 28/2/2023
     * Function: find User by username
     * @param:username
     **/
    Optional<User> findByUsername(String username);

    /**
     * Created by: CuongVV
     * Date created: 28/2/2023
     * Function: update user
     * @param:updateUserForm
     **/
    void updateUser(UpdateUserForm updateUserForm);
    /**
     * Created by: CuongVV
     * Date created: 28/2/2023
     * Function: changer password
     * @param:password,username
     **/
    void changePassword(String password,String username);
    /**
     * Created by: CuongVV
     * Date created: 28/2/2023
     * Function: insert into table user to register account
     * @param:user
     **/
    void save(User user);
    /**
     * Created by: CuongVV
     * Date created: 28/2/2023
     * Function: check exists user by username
     * @param:username
     **/
    Boolean existsByUsername(String username);
    /**
     * Created by: CuongVV
     * Date created: 28/2/2023
     * Function: check exists user by email
     * @param:email
     **/
    Boolean existsByEmail(String email);

    /**
     * Created by: CuongVV
     * Date created: 28/2/2023
     * Function: get all user
     * @param:none
     **/
    List<User> findAll();
    /**
     * Created by: CuongVV
     * Date created: 28/2/2023
     * Function: get all CUSTOMER
     * @param:none
     **/
    List<User> findAllCustomer();
    /**
     * Created by: CuongVV
     * Date created: 28/2/2023
     * Function: get all EMPLOYEE
     * @param:none
     **/
    List<User> findAllEmployee();
    /**
     * Created by: CuongVV
     * Date created: 28/2/2023
     * Function: get all ADMIN
     * @param:none
     **/
    List<User> findAllAdmin();
    /**
     * Created by: DungND
     * Date created: 26/3/2023
     * Function: findByID
     * @param:id
     **/
    Optional<User> findByIdAccount(Integer idAccount);
}
