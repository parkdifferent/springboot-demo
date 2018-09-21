package com.phoenix.dao.mapper;

import com.phoenix.common.model.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /* define */
    List<User> getListWithPage(Map<String, Object> map);

    List<User> getAll(Map<String, Object> map);
}