package com.example.shopinterior.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Integer id;
    private String name;
    private String username;
    private String password;
    private String phoneNumber;
    private String email;
    private String address;
    private Integer age;
    private Boolean gender;
    private String dateOfBirth;
    private String avatar;
}
