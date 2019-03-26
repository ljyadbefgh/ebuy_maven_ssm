package com.lcvc.ebuy_maven_ssm.dao;

import com.lcvc.ebuy_maven_ssm.model.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminDao {

	/**
	 * 登录
	 *@param username 账户名
	 *@param password 密码
	 *@return null表示登录失败
	 */
	Admin login(@Param(value = "username") String username, @Param(value = "password") String password);



	/**
	 * 更改指定账户的密码
	 * @param newPass 更改后的密码
	 * @param id 要更改密码的账户主键
	 * @return 更改了多少条记录
	 */
	int updatePassword(@Param(value = "password")String newPass,@Param(value = "id")Integer id);
}
