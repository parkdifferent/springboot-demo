
package com.phoenix.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author tianFeng
 * @version 1.0, 2018/06/15
 */

@Data
public class UserForm extends PageQuery {

    private static final long serialVersionUID = -4557272540920344841L;

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
