package com.lcvc.ebuy_maven_ssm.service;

import com.lcvc.ebuy_maven_ssm.dao.AdminDao;
import com.lcvc.ebuy_maven_ssm.service.impl.AdminService;
import com.lcvc.ebuy_maven_ssm.util.SHA;
import org.junit.Test;

public class AdminServiceTest {
	private AdminService adminService=new AdminService();

	@Test
	public void testLogin(){
		System.out.println(adminService.login("admin", "123"));
		System.out.println(adminService.login("user",  "123456"));
		System.out.println(adminService.login("user",  "123"));
	}

	@Test
	public void testUpdatePassword(){
		System.out.println(adminService.updatePassword( "111111", 1000));
		System.out.println(adminService.updatePassword( "111111", 2));
	}
}
