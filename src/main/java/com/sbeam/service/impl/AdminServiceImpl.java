package com.sbeam.service.impl;

import com.sbeam.dao.mappering.TbAdminMapper;
import com.sbeam.dao.pojo.TbAdmin;
import com.sbeam.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    TbAdminMapper tbAdminMapper;

    @Override
    public Integer getLogin(String username, String password) {
        return tbAdminMapper.getLogin(username,password);
    }

    @Override
    public TbAdmin getTbAdmin(Integer id) {
        return tbAdminMapper.getTbAdmin(id);
    }
}
