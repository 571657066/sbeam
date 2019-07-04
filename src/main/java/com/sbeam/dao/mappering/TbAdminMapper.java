package com.sbeam.dao.mappering;

import com.sbeam.dao.pojo.TbAdmin;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TbAdminMapper extends Mapper<TbAdmin> {

    /**
     * 验证管理员密码
     * @param adminname
     * @param password
     * @return
     */
    public TbAdmin getLogin(String adminname,String password);

    /**
     *  查询单个管理员信息
     * @param id
     * @return
     */
    public TbAdmin getTbAdmin(Integer id);

    /**
     * 分页查询
     * @param tbAdmin
     * @return
     */
    public List<TbAdmin> listAllPage(TbAdmin tbAdmin);

    /**
     * 添加管理员
     * @param tbAdmin
     * @return
     */
    public Integer addTbAdmin(TbAdmin tbAdmin);

    /**
     * 修改管理信息
     * @param tbAdmin
     * @return
     */
    public Integer updateTbAdmin(TbAdmin tbAdmin);

    /**
     * 伪删除
     * @param tbAdmin
     * @return
     */
    public Integer delAdmin(TbAdmin tbAdmin);

    /**
     * 遍历所
     * @return
     */
    public List<TbAdmin> listAllAdmin();

}