package com.sbeam.dao.mappering;

import com.sbeam.dao.pojo.TbAdmin;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TbAdminMapper extends Mapper<TbAdmin> {

    /**
     * ��֤����Ա����
     * @param adminname
     * @param password
     * @return
     */
    public TbAdmin getLogin(String adminname,String password);

    /**
     *  ��ѯ��������Ա��Ϣ
     * @param id
     * @return
     */
    public TbAdmin getTbAdmin(Integer id);

    /**
     * ��ҳ��ѯ
     * @param tbAdmin
     * @return
     */
    public List<TbAdmin> listAllPage(TbAdmin tbAdmin);

    /**
     * ��ӹ���Ա
     * @param tbAdmin
     * @return
     */
    public Integer addTbAdmin(TbAdmin tbAdmin);

    /**
     * �޸Ĺ�����Ϣ
     * @param tbAdmin
     * @return
     */
    public Integer updateTbAdmin(TbAdmin tbAdmin);

    /**
     * αɾ��
     * @param tbAdmin
     * @return
     */
    public Integer delAdmin(TbAdmin tbAdmin);

    /**
     * ������
     * @return
     */
    public List<TbAdmin> listAllAdmin();

}