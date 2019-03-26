package com.lcvc.ebuy_maven_ssm.dao;

import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.util.SHA;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDaoTest {
	private AdminDao adminDao;

	@Test
	public void testLogin(){
		//打开数据库，耗费资源巨大，建议项目中只打开一次
		SqlSessionFactory sessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
		//创建SqlSession，SqlSession类似于JDBC中的Connection，
		SqlSession session = sessionFactory.openSession();
		try {
			//获取mapper接口代理对象
			AdminDao adminDao = session.getMapper(AdminDao.class);
			System.out.println(adminDao.login("admin", SHA.getResult("123")));
			System.out.println(adminDao.login("user",  SHA.getResult("123456")));
			System.out.println(adminDao.login("user",  SHA.getResult("111")));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Test
	public void testUpdatePassword(){
		//打开数据库，耗费资源巨大，建议项目中只打开一次
		SqlSessionFactory sessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
		//创建SqlSession，SqlSession类似于JDBC中的Connection，
		SqlSession session = sessionFactory.openSession();
		try {
			//获取mapper接口代理对象
			AdminDao adminDao = session.getMapper(AdminDao.class);
			System.out.println(adminDao.updatePassword( SHA.getResult("111111"), 1000));
			System.out.println(adminDao.updatePassword( SHA.getResult("111111"), 2));
		} catch (Exception e) {
			e.printStackTrace();
			//回滚事务，取消此次数据库的所有更改操作
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
