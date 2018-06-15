
package com.phoenix.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserVO implements Serializable {

    private static final long serialVersionUID = -125375525997353959L;

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
