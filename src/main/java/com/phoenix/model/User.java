package com.phoenix.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id;

    private String userName;

    private String password;

    private String name;

    private Integer age;

    private Boolean sex;

    private Date birthday;

    private Date created;

    private Date updated;
}