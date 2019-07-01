package com.sbeam.service;

import com.sbeam.dao.pojo.TbAdmin;
import org.springframework.stereotype.Service;


public interface AdminService {

    public Integer getLogin(String username,String password);
    public TbAdmin getTbAdmin(Integer id);
}
