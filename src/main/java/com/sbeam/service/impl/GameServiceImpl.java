package com.sbeam.service.impl;

import com.sbeam.dao.mappering.TbCommentMapper;
import com.sbeam.dao.mappering.TbGameMapper;
import com.sbeam.dao.pojo.TbComment;
import com.sbeam.dao.pojo.TbGame;
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
        String topicid = game.getTopicid();
        //此处需要模糊查询
        List<TbComment> comments = tbCommentMapper.selectLikeOne(topicid);
        return comments;
    }


}
