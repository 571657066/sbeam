package com.sbeam.dao.mappering;

import com.sbeam.dao.pojo.Gamer;
import tk.mybatis.mapper.common.Mapper;

public interface GamerMapper extends Mapper<Gamer> {
    /**
     * 根据gamer查询gamer是否存在
     * @param gamer
     * @return
     */
    Gamer selectOneUser(Gamer gamer);

    int insertOneUser(Gamer gamer);
}