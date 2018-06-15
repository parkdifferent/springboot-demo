package com.phoenix.service;

import com.phoenix.dto.UserForm;
import com.phoenix.model.User;

import java.util.List;

/**
 * @author tianFeng
 * @version 1.0, 2018/06/15
 */

public interface UserService {

    User getById(Long id);

    int deleteById(Long id);

    int save(UserForm userForm);

    int update(UserForm userForm);

    /* define */
    List<User> getListWithPage(UserForm userForm);

    List<User> getAll(UserForm userForm);
}
