package com.lcvc.ebuy_maven_ssm.dao;

import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.util.SHA;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDaoTest {
	private AdminDao adminDao=new AdminDao();

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
