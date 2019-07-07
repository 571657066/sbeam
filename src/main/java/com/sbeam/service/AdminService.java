package com.sbeam.service;

import com.sbeam.dao.pojo.Gamer;
import com.sbeam.dao.pojo.TbAdmin;
import com.sbeam.dto.ArrayListVo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AdminService {

    public TbAdmin getLogin(TbAdmin tbAdmin);
    public TbAdmin getTbAdmin(Integer id);
    public List<TbAdmin> listAllPage(TbAdmin tbAdmin);
    public boolean addTbAdmin(TbAdmin tbAdmin);
    public Integer updateTbAdmin(TbAdmin tbAdmin);
    public Integer delAdmin(TbAdmin tbAdmin);
    public List<TbAdmin> listAllAdmin();

    //¶àÑ¡É¾³ý
    Integer allDeleAtricleByIds(ArrayListVo arrayListVo);
}
