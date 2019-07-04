package com.sbeam.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sbeam.dao.mappering.TbAdminMapper;
import com.sbeam.dao.pojo.TbAdmin;
import com.sbeam.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    TbAdminMapper tbAdminMapper;

    @Override
    public TbAdmin getLogin(String username, String password) {
        return tbAdminMapper.getLogin(username,password);
    }

    @Override
    public TbAdmin getTbAdmin(Integer id) {
        return tbAdminMapper.getTbAdmin(id);
    }

    @Override
    public List<TbAdmin> listAllPage(TbAdmin tbAdmin) {
        return tbAdminMapper.listAllPage(tbAdmin);
    }

    @Override
    public boolean addTbAdmin(TbAdmin tbAdmin) {
        tbAdmin.setPassword(tbAdmin.getPassword());
        int b = tbAdminMapper.addTbAdmin(tbAdmin);

        if (b>0){
            return true;
        }
        return false;
    }

    @Transactional
    public Integer updateTbAdmin(TbAdmin tbAdmin) {
        int count = tbAdminMapper.updateTbAdmin(tbAdmin);
        System.out.println(count);
        return count;
    }

    @Override
    public Integer delAdmin(TbAdmin tbAdmin) {
        return tbAdminMapper.delAdmin(tbAdmin);
    }

    @Override
    public List<TbAdmin> listAllAdmin() {

        return tbAdminMapper.listAllAdmin();
    }


}
