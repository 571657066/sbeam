package com.sbeam.dao.mappering;

import com.sbeam.dao.pojo.TbDeveloper;
import tk.mybatis.mapper.common.Mapper;


public interface TbDeveloperMapper extends Mapper<TbDeveloper> {
    /**
     * 根据tbDeveloper的账户名密码 查询tbDeveloper是否存在
     * @param tbDeveloper
     * @return
     */
    TbDeveloper selectOneDeveloper(TbDeveloper tbDeveloper);

    /**
     * 根据tbDeveloper添加用户
     * @param tbDeveloper
     * @return
     */
    int insertOneDeveloper(TbDeveloper tbDeveloper);

    /**
     * 根据tbDeveloper更新tbDeveloper
     * @param tbDeveloper
     * @return
     */
    int updateOneDeveloper(TbDeveloper tbDeveloper);

    /**
     * 根据账户名查出该开发商全部信息
     * @param tbDeveloper
     * @return
     */
    TbDeveloper selectDeveloper(TbDeveloper tbDeveloper);




}