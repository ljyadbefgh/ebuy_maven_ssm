package com.lcvc.ebuy_maven_ssm.service;

import com.lcvc.ebuy_maven_ssm.model.Admin;

public interface AdminService {
    /**
     * 根据账户名和密码去数据库查询，进行登录判断
     * @param username 账户名
     * @param password 密码
     * @return true表示登录成功,false表示登录失败
     */
    Admin login(String username, String password);

    /**
     * 修改指定账户的密码为新密码
     * @param newPass 更改后的密码
     * @param id 要更改密码的账户主键
     * @return true表示密码更改成功，false表示密码更改失败
     */
    boolean updatePassword(String newPass,Integer id);
}
