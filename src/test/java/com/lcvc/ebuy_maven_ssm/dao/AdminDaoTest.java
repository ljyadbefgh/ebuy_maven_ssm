package com.lcvc.ebuy_maven_ssm.dao;

import com.lcvc.ebuy_maven_ssm.SpringJunitTest;
import com.lcvc.ebuy_maven_ssm.util.SHA;
import org.junit.Test;

import javax.annotation.Resource;

public class AdminDaoTest extends SpringJunitTest {
	@Resource
	private AdminDao adminDao;

	@Test
	public void testLogin(){
		System.out.println(adminDao.login("admin", SHA.getResult("123")));
		System.out.println(adminDao.login("user",  SHA.getResult("123456")));
		System.out.println(adminDao.login("user",  SHA.getResult("111")));
	}

	@Test
	public void testUpdatePassword(){
		System.out.println(adminDao.updatePassword( SHA.getResult("111111"), 1000));
		System.out.println(adminDao.updatePassword( SHA.getResult("111111"), 2));
	}
}
