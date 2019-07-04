package com.sbeam.dao.mappering;

import com.sbeam.dao.pojo.TbGame;
import tk.mybatis.mapper.common.Mapper;

public interface TbGameMapper extends Mapper<TbGame> {
    /**
     * 查询某用户的愿望单或者游戏列表里是否有折扣游戏
     * @param gamename
     * @return
     */
    Double SelectIsDiscount(String gamename);

    /**
     * 根据游戏名获取该游戏的全部信息
     * @param gamename
     * @return
     */
    TbGame selectOneGame(String gamename);

    /**
     * 更新
     * @param tbGame
     * @return
     */
    Integer updateOneGame(TbGame tbGame);

}