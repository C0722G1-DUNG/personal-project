package com.example.shopinterior.repository;

import com.example.shopinterior.entity.account.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


@Transactional
@Repository
public interface IUserRepository extends JpaRepository<Account, Integer> {


    /**
     * Created by: CuongVV
     * Date created: 28/2/2023
     * Function: get user by username
     *
     * @param:username
     **/
    @Query(value = "select * from account where username = :username", nativeQuery = true)
    Optional<Account> findByUsername(@Param("username") String username);


    @Modifying
    @Query(value = "update account set name = :name,phone_number = :phone_number,email = :email," +
            " address = :address,age = :age,gender = :gender,date_of_birth = :date_of_birth,avatar = :avatar" +
            " where username = :username  ", nativeQuery = true)
    void updateUser(@Param("name") String name, @Param("phone_number") String phoneNumber, @Param("email") String email
            , @Param("address") String address, @Param("age") Integer age, @Param("gender") Boolean gender
            , @Param("date_of_birth") String dateOfBirth, @Param("avatar") String avatar, @Param("username") String username);

    /**
     * Created by: CuongVV
     * Date created: 28/2/2023
     * Function: change password
     *
     * @param:username,password
     **/
    @Modifying
    @Query(value = "update account set password = :password where username = :username", nativeQuery = true)
    void changePassword(@Param("password") String password, @Param("username") String username);

    /**
     * Created by: CuongVV
     * Date created: 28/2/2023
     * Function: get all user
     *
     * @param:none
     **/
    @Query(value = "select * from account", nativeQuery = true)
    List<Account> getAllUser();

    /**
     * Created by: CuongVV
     * Date created: 28/2/2023
     * Function: insert into table user to register account
     *
     * @param:name,username,password,email
     **/
    @Modifying
    @Query(value = "insert into account (name,username,email,password) values (:name,:username,:email,:password)", nativeQuery = true)
    void save(@Param("name") String name, @Param("username") String username, @Param("email") String email, @Param("password") String password);

    /**
     * Created by: CuongVV
     * Date created: 28/2/2023
     * Function: set role to user
     *
     * @param:user_id,role_id
     **/
    @Modifying
    @Query(value = "insert into user_roles (user_id,roles_id) values (:user,:role)", nativeQuery = true)
    void insertRole(@Param("user") int userID, @Param("role") int roleID);

    @Query(value = "select * from account where username = :username", nativeQuery = true)
    Account userLogin(@Param("username") String username);

    /**
     * Created by: CuongVV
     * Date created: 28/2/2023
     * Function: set role to user
     *
     * @param:none
     **/
    @Query(value = "select * from account join user_roles on user.id = user_roles.user_id join role r on user_roles.roles_id = r.id where r.name = 'ROLE_CUSTOMER'", nativeQuery = true)
    List<Account> findAllCustomer();

    @Query(value = "select * from account join user_roles on user.id = user_roles.user_id join role r on user_roles.roles_id = r.id where r.name = 'ROLE_EMPLOYEE'", nativeQuery = true)
    List<Account> findAllEmployee();

    @Query(value = "select * from account join user_roles on user.id = user_roles.user_id join role r on user_roles.roles_id = r.id where r.name = 'ROLE_ADMIN'", nativeQuery = true)
    List<Account> findAllAdmin();

    /**
     * Created by: LongPT
     * Date created: 27/2/2023
     * Function: get all customer
     *
     * @param name
     * @param address
     * @param pageable
     * @Repository public interface IUserRepository extends JpaRepository<User, Integer> {
     */

    @Query(value = "select `account`.* " +
            " from `user` " +
            "         join `user_roles` on `user`.id = `user_roles`.user_id " +
            "         join `role` on `role`.id = `user_roles`.roles_id " +
            "where role.name = 'ROLE_CUSTOMER' " +
            "  and user.name like concat('%', :name, '%') " +
            "  and user.address like concat('%', :address, '%')"
            , nativeQuery = true)
    Page<Account> findAllCustomer(Pageable pageable, @Param("name") String name, @Param("address") String address);

    /**
     * Created by: LongPT
     * Date created: 27/2/2023
     * Function: get all customer
     *
     * @param pageable
     */
    @Query(value = "select `account`.*" +
            " from `user` " +
            "         join `user_roles` on `user`.id = `user_roles`.user_id " +
            "         join `role` on `role`.id = `user_roles`.roles_id " +
            "where role.name = 'ROLE_CUSTOMER' "
            , nativeQuery = true)
    Page<Account> findAllCustomerNoParam(Pageable pageable);

    /**
     * Created by: LongPT
     * Date created: 27/2/2023
     * Function: get customer by id
     *
     * @param id
     */
    @Query(value = "select * from account join user_roles on user.id = user_roles.user_id join role on role.id = user_roles.roles_id where role.name = 'ROLE_CUSTOMER' and user.id = :id",
            countQuery = "select * from user join user_roles on user.id = user_roles.user_id join role on role.id = user_roles.roles_id where role.name = 'ROLE_CUSTOMER' and user.id = :id"
            , nativeQuery = true)
    Optional<Account> findCustomerById(@Param("id") Integer id);

    /**
     * Created by: HuyNL
     * Date created: 1/3/2023
     * Function: get customer list & search
     */

    @Query(value = "select u.* from `account` u join `user_roles` ur on u.id = ur.user_id join `role` r on ur.roles_id = r.id  where r.name = 'ROLE_CUSTOMER' and u.gender like %:genderSearch% and u.age like %:ageSearch%", countQuery = "select * from `user` where gender like %:genderSearch% and age like %:ageSearch%", nativeQuery = true)
    Page<Account> findAll(@Param("genderSearch") String genderSearch, @Param("ageSearch") String age, Pageable pageable);

    @Query(value = "select u.* from `account` u join `user_roles` ur on u.id = ur.user_id join `role` r on ur.roles_id = r.id  where r.name = 'ROLE_CUSTOMER' and u.gender = :genderSearch and u.age like %:ageSearch% ", countQuery = "select * from `user` where gender like %:genderSearch% and age like %:ageSearch%", nativeQuery = true)
    Page<Account> findAllByGender(@Param("genderSearch") boolean genderSearch, @Param("ageSearch") String age, Pageable pageable);

    @Query(value = "select count(u.id) from `account` u join `bill` b on u.id = b.user_id " +
            "    join `bill_history` bh on b.id = bh.bill_id where u.id =:id group by u.id", nativeQuery = true)
    Integer selectQuantity(@Param("id") int id);

    @Query(value = "select u.* from `account` u join `bill` b on u.id = b.user_id join `bill_history` bh on b.id = bh.bill_id group by u.id", nativeQuery = true)
    List<Account> getUserHasBuy();

}
