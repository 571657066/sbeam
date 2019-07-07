package com.sbeam.service;

import com.sbeam.dao.pojo.TbComment;
import com.sbeam.dao.pojo.TbGame;
import com.sbeam.dto.ArrayListVo;

import java.util.List;
import java.util.Map;

public interface GameService {
    /**
     * 查询单个游戏是否打折
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
     * 获取该游戏的全部评论
     * @param tbGame
     * @return
     */
    List<TbComment> selectGameTopic(TbGame tbGame);

    //分页1
    List<TbGame> getNewsInfoBy();
    //单删
    Integer deleArticeById(TbGame article);
    //模糊查询
    List<TbGame> seletcAtricleId(String getaTitle);
    //多选删除
    Integer allDeleAtricleByIds(ArrayListVo arrayListVo);

}
