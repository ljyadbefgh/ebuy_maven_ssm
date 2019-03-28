package com.lcvc.ebuy_maven_ssm.dao;

import com.lcvc.ebuy_maven_ssm.model.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

//这里不使用@Service也不会有问题，但是idea中会报错（工具问题），有强迫症的话可以加上@Service，这样idea可以查找
@Service
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
