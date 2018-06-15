
package com.phoenix.service.impl;

import com.phoenix.dao.UserMapper;
import com.phoenix.dto.UserForm;
import com.phoenix.model.User;
import com.phoenix.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tianFeng
 * @version $Id: UserServiceImpl.java, v0.1 2017/10/28 16:11 tianFeng Exp $
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> getAll(UserForm userForm) {
        Map<String, Object> map = new HashMap<>();
        List<User> userList = userMapper.getAll(map);
        return userList;
    }

    @Override
    public List<User> getListWithPage(UserForm userForm) {
        Map<String, Object> map = new HashMap<>();
        map.put("offset", 0);
        map.put("limit", 3);
        List<User> userList = userMapper.getListWithPage(map);
        return userList;
    }

    @Override
    public User getById(Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public int deleteById(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int save(UserForm userForm) {
        User user = new User();
        BeanUtils.copyProperties(userForm, user);
        return userMapper.insert(user);

    }

    @Override
    public int update(UserForm userForm) {
        User user = new User();
        BeanUtils.copyProperties(userForm, user);
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
