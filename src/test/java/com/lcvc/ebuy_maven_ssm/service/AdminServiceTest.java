package com.lcvc.ebuy_maven_ssm.service;

import com.lcvc.ebuy_maven_ssm.SpringJunitTest;
import org.junit.Test;

import javax.annotation.Resource;

public class AdminServiceTest  extends SpringJunitTest {
	@Resource
	private AdminService adminService;

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
