package com.lcvc.ebuy_maven_ssm.service.impl;

import com.lcvc.ebuy_maven_ssm.dao.AdminDao;
import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.service.AdminService;
import com.lcvc.ebuy_maven_ssm.util.SHA;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminDao adminDao;

    @Override
    public Admin login(String username, String password){
        //将密码加密后再进行比对
        password= SHA.getResult(password);
        return adminDao.login(username, password);
    }

    @Override
    public boolean updatePassword(String newPass,Integer id){
        boolean status=false;//默认编辑失败
        newPass= SHA.getResult(newPass);//将新密码加密
        int i=adminDao.updatePassword(newPass, id);
        if(i>0){//如果密码数量>0
            status=true;
        }
        return status;
    }
}
