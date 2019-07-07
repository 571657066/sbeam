package com.sbeam.dao.mappering;

import com.sbeam.dao.pojo.Gamer;
import com.sbeam.dao.pojo.TbShopcar;
import tk.mybatis.mapper.common.Mapper;

public interface TbShopcarMapper extends Mapper<TbShopcar> {

    /**
     * 更新购物车
     * @param tbShopcar
     * @return
     */
    Integer updateShopcar(TbShopcar tbShopcar);

    /**
     * 查询某用户的购物车
     * @return
     */
    TbShopcar selectOneshopcar(Gamer gamer);

    /**
     * 为gamer添加数据库
     * @param gamer
     * @return
     */
    Integer insertOneshopcar(Gamer gamer);
}
