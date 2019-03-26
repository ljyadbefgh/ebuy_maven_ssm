package com.lcvc.ebuy_maven_ssm.service.impl;

import com.lcvc.ebuy_maven_ssm.dao.AdminDao;
import com.lcvc.ebuy_maven_ssm.dao.SqlSessionFactoryUtil;
import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.util.SHA;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class AdminService {
    private AdminDao adminDao;

    /**
     * 根据账户名和密码去数据库查询，进行登录判断
     * @param username 账户名
     * @param password 密码
     * @return true表示登录成功,false表示登录失败
     */
    public Admin login(String username, String password){
        Admin admin=null;
        //将密码加密后再进行比对
        password= SHA.getResult(password);
        //打开数据库，耗费资源巨大，建议项目中只打开一次
        SqlSessionFactory sessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        //创建SqlSession，SqlSession类似于JDBC中的Connection，
        SqlSession session = sessionFactory.openSession();
        try {
            //获取mapper接口代理对象
            adminDao = session.getMapper(AdminDao.class);
            admin=adminDao.login(username, password);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return admin;
    }

    /**
     * 修改指定账户的密码为新密码
     * @param newPass 更改后的密码
     * @param id 要更改密码的账户主键
     * @return true表示密码更改成功，false表示密码更改失败
     */
    public boolean updatePassword(String newPass,Integer id){
        boolean status=false;//默认编辑失败
        newPass= SHA.getResult(newPass);//将新密码加密
        //打开数据库，耗费资源巨大，建议项目中只打开一次
        SqlSessionFactory sessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        //创建SqlSession，SqlSession类似于JDBC中的Connection，
        SqlSession session = sessionFactory.openSession();
        try {
            //获取mapper接口代理对象
            adminDao = session.getMapper(AdminDao.class);
            int i=adminDao.updatePassword(newPass, id);
            if(i>0){//如果密码数量>0
                status=true;
                //提交事务，只有提交后更改才会真正的执行
                session.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务，取消此次数据库的所有更改操作
            session.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return status;
    }
}
