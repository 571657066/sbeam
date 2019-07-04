package com.sbeam.service.impl;

import com.sbeam.dao.mappering.TbDeveloperMapper;
import com.sbeam.dao.mappering.TbGameMapper;
import com.sbeam.dao.pojo.TbDeveloper;
import com.sbeam.dao.pojo.TbGame;
import com.sbeam.service.DeveloperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DeveloperServiceImpl implements DeveloperService {
    @Resource
    TbDeveloperMapper tbDeveloperMapper;

    @Resource
    TbGameMapper tbGameMapper;

    @Override
    public boolean discountGame(TbDeveloper developer, String gamename, Double discount) {
        TbDeveloper tbDeveloper = tbDeveloperMapper.selectDeveloper(developer);
        String releasedGame = tbDeveloper.getReleasedGame();
        if (releasedGame.indexOf(gamename)!=-1){
            TbGame game = tbGameMapper.selectOneGame(gamename);
            game.setDiscount(discount);
            tbGameMapper.updateOneGame(game);
            return true;
        }else {
            return false;
        }
    }
}
