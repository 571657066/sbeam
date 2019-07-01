package com.sbeam.dao.mappering;

import com.sbeam.dao.pojo.TbAdmin;
import tk.mybatis.mapper.common.Mapper;

public interface TbAdminMapper extends Mapper<TbAdmin> {
    public TbAdmin getLogin(String username,String password);
    public TbAdmin getTbAdmin(Integer id);
}