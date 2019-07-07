package com.sbeam.service.impl;

import com.sbeam.dao.mappering.TbCommentMapper;
import com.sbeam.dao.mappering.TbGameMapper;
import com.sbeam.dao.pojo.TbComment;
import com.sbeam.dao.pojo.TbGame;
import com.sbeam.dto.ArrayListVo;
import com.sbeam.service.GameService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class GameServiceImpl implements GameService {
    @Resource
    TbGameMapper tbGameMapper;

    @Resource
    TbCommentMapper tbCommentMapper;
    @Override
    public Double SelectIsDiscount(String gamename) {
        Double discount = tbGameMapper.SelectIsDiscount(gamename);
        return discount;
    }

    @Override
    public TbGame selectOneGame(String gamename) {
        TbGame tbGame = tbGameMapper.selectOneGame(gamename);
        return tbGame;
    }

    @Override
    public List<TbComment> selectGameTopic(TbGame tbGame) {
        TbGame game = tbGameMapper.selectOneGame(tbGame.getGamename());
        String topicid = game.getTopicId();
        //此处需要模糊查询
        List<TbComment> comments = tbCommentMapper.selectLikeOne(topicid);
        return comments;
    }

    @Override
    public List<TbGame> getNewsInfoBy() {
        return tbGameMapper.getNewsInfoBy();
    }

    //单删除
    @Override
    public Integer deleArticeById(TbGame article) {
        return tbGameMapper.deleArticeById(article);
    }
    //模糊查询
    @Override
    public List<TbGame> seletcAtricleId(String getaTitle) {
        return tbGameMapper.seletcAtricleId(getaTitle);
    }

    //多选删除
    @Override
    public Integer allDeleAtricleByIds(ArrayListVo arrayListVo) {
        return tbGameMapper.allDeleAtricleByIds(arrayListVo);
    }

}
