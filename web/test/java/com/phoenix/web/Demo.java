package com.phoenix.web;

/**
 * @Auther: tianFeng
 * @Date: 2023-02-10 11:30
 */
public class Demo {

    public String hello() {
        //System.out.println("hello world!");
        return "hello world!";
    }

    // 用户登录系统方法：
    /*public String LoginSystem(String userName, String password) {
        String result = "";

        // 根据用户名从数据库中获取密码信息，判断密码是否正确。
        // SQL语句：SELECT password FROM users WHERE username=username;
        ResultSet rs = statement.executeQuery("SELECT password FROM users WHERE username=" + userName);

        if (rs.next()) {
            // 验证用户密码是否正确。
            if (password.equals(rs.getString("password"))) {
                // 登录成功
                result = "success";
            } else {
                // 密码错误，登录失败
                result = "failure";
            }
        } else {
            result = "notfound"; // 用户名不存在，用户未注册
        }
        return result;
    }*/


}
