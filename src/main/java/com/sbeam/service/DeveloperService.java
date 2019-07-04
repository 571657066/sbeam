package com.sbeam.service;

import com.sbeam.dao.pojo.TbDeveloper;

public interface DeveloperService {
    /**
     * 开发商给自己的游戏打折
     * @param gamename
     * @param discount
     * @return
     */
    boolean discountGame(TbDeveloper developer, String gamename, Double discount);
}
