package com.sbeam.service.impl;

import com.sbeam.dao.mappering.TbGameMapper;
import com.sbeam.dao.pojo.TbGame;
import com.sbeam.service.GameService;


import javax.annotation.Resource;

public class GameServiceImpl implements GameService {
    @Resource
    TbGameMapper tbGameMapper;

    @Override
    public Double SelectIsDiscount(String gamename) {
        Double discount = tbGameMapper.SelectIsDiscount(gamename);
        return discount;
    }
}
