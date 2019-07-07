package com.sbeam.service;

import com.sbeam.dao.pojo.Gamer;
import com.sbeam.dao.pojo.TbDeveloper;
import com.sbeam.dao.pojo.TbGame;

public interface DeveloperService {
    /**
     * 开发商给自己的游戏打折
     * @param gamename
     * @param discount
     * @return
     */
    boolean discountGame(TbDeveloper developer, String gamename, Double discount);

    /**
     * 开发商发布游戏(游戏未审核),此处传入的游戏必须信息完整
     * @param tbGame
     * @return
     */
    boolean issueGame(TbGame tbGame, TbDeveloper tbDeveloper);

    /**
     * 根据tbdeveloper查询这个tbdeveloper是否存在
     * @param tbDeveloper
     * @return
     */
    TbDeveloper Login(TbDeveloper tbDeveloper);

    /**
     * 根据tbdeveloper添加这个tbdeveloper
     * @param tbDeveloper
     * @return
     */
    boolean Register(TbDeveloper tbDeveloper);

    /**
     * 根据tbDeveloper更新tbDeveloper
     * @param tbDeveloper
     * @return
     */
    boolean Update(TbDeveloper tbDeveloper);

}
