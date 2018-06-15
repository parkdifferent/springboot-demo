
package com.phoenix.controller;

import com.phoenix.dto.UserForm;
import com.phoenix.model.User;
import com.phoenix.model.UserVO;
import com.phoenix.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author tianFeng
 * @version 1.0, 2018/06/15
 */

@Controller
@RequestMapping(value = "user")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @ApiOperation(value = "test", httpMethod = "GET", notes = "test")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public UserVO test() {
        User user = new User();
        user.setUserName("phoenix");
        user.setAge(24);
        user.setCreated(new Date());

        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);

        LOG.trace("-----------------------------------trace");
        LOG.debug("-----------------------------------debug");
        LOG.info("-----------------------------------info");
        LOG.warn("-----------------------------------warn");
        LOG.error("-----------------------------------error");

        return userVO;

    }

    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value = "getAll", method= RequestMethod.GET)
    @ResponseBody
    public List<UserVO> getAll(UserForm userForm) {
        List<User> userList = userService.getAll(userForm);

        List<UserVO> userVOList = new ArrayList<>();
        UserVO userVO = null;
        if (!CollectionUtils.isEmpty(userList)) {
            for (User user : userList) {
                userVO = new UserVO();
                BeanUtils.copyProperties(user, userVO);
                userVOList.add(userVO);
            }
        }

        return userVOList;
    }

    @ApiOperation(value="获取用户分页列表", notes="")
    @RequestMapping(value = "getUserList", method= RequestMethod.GET)
    @ResponseBody
    public List<UserVO> getUserList(UserForm userForm) {
        List<User> userList = userService.getListWithPage(userForm);

        List<UserVO> userVOList = new ArrayList<>();
        UserVO userVO = null;
        if (!CollectionUtils.isEmpty(userList)) {
            for (User user : userList) {
                userVO = new UserVO();
                BeanUtils.copyProperties(user, userVO);
                userVOList.add(userVO);
            }
        }

        return userVOList;
    }

    @ApiOperation(value="获取用户详情", notes="")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public UserVO getById(@PathVariable Long id) {
        User user = userService.getById(id);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }

    @ApiOperation(value="新增用户", notes="")
    @RequestMapping(value = "",method = RequestMethod.POST)
    @ResponseBody
    public int add(@RequestBody UserForm userForm) {
        userForm.setCreated(new Date());
        return userService.save(userForm);
    }

    @ApiOperation(value="更新用户", notes="")
    @RequestMapping(value = "",method = RequestMethod.PUT)
    @ResponseBody
    public int update(@RequestBody UserForm userForm) {
        userForm.setUpdated(new Date());
        return userService.update(userForm);
    }

    @ApiOperation(value="删除用户", notes="")
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public int delete(@PathVariable Long id) {
        return userService.deleteById(id);
    }


}
