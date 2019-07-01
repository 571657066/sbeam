package com.sbeam.util;

import com.sbeam.dao.mappering.TbGameMapper;
import com.sbeam.dao.pojo.TbGame;

import javax.annotation.Resource;

public class SelectIsDiscount {
    @Resource
    static TbGameMapper tbGameMapper;

    public static Double selectGame(TbGame tbGame){
        Double discount = tbGameMapper.SelectIsDiscount(tbGame.getGamename());
        return discount;
    }

    public static Double selectGame(String gamename){
        Double discount = tbGameMapper.SelectIsDiscount(gamename);
        return discount;
    }
}
