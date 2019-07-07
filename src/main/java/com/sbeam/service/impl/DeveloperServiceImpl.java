package com.sbeam.service.impl;

import com.sbeam.dao.mappering.TbDeveloperMapper;
import com.sbeam.dao.mappering.TbGameMapper;
import com.sbeam.dao.pojo.Gamer;
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
            double v = game.getNowPrice() * discount;
            game.setNowPrice(new Double(v).longValue());
            if (game.getLowestPrice()>game.getNowPrice()){
                game.setLowestPrice(game.getNowPrice());
            }
            tbGameMapper.updateOneGame(game);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean issueGame(TbGame tbGame,TbDeveloper tbDeveloper) {
        String developername = tbDeveloper.getDevelopername();
        tbGame.setDeveloper(developername);
        Integer flag = tbGameMapper.insertOne(tbGame);
        if (flag>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public TbDeveloper Login(TbDeveloper tbDeveloper) {
        TbDeveloper tbDeveloper1 = tbDeveloperMapper.selectOneDeveloper(tbDeveloper);
        return tbDeveloper1;
    }

    @Override
    public boolean Register(TbDeveloper tbDeveloper) {
        int i = tbDeveloperMapper.insertOneDeveloper(tbDeveloper);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean Update(TbDeveloper tbDeveloper) {
        int i = tbDeveloperMapper.updateOneDeveloper(tbDeveloper);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }
}
