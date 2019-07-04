package com.sbeam.service.impl;

import com.sbeam.dao.mappering.TbCommentMapper;
import com.sbeam.dao.mappering.TbGameMapper;
import com.sbeam.dao.mappering.TbMessageMapper;
import com.sbeam.dao.pojo.Gamer;
import com.sbeam.dao.pojo.TbComment;
import com.sbeam.dao.pojo.TbGame;
import com.sbeam.dao.pojo.TbMessage;
import com.sbeam.service.MessageService;
import com.sbeam.util.NewMessageId;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MessageServiceImpl implements MessageService {

    @Resource
    TbMessageMapper tbMessageMapper;

    @Resource
    TbGameMapper tbGameMapper;

    @Resource
    TbCommentMapper tbCommentMapper;
    @Override
    public boolean insertOrUpdateComment(Gamer gamer,  TbGame tbGame, TbComment tbComment) {
        TbComment comment=null;
        TbGame game = tbGameMapper.selectOneGame(tbGame.getGamename());
        Integer gamerId = gamer.getId();
        comment=tbComment;
        comment.setUserId(gamerId);
        if(game.getTopicid()!=null){
            comment.setSpeakId(game.getTopicid());
            Integer integer = tbCommentMapper.insertOne(tbComment);
            if(integer>0){
                TbMessage message = new TbMessage();
                message.setTopicName(game.getGamename()+"的评论");
                TbMessage tbMessage = tbMessageMapper.selectOne(message);
                String formUid = tbMessage.getFormUid();
                formUid = formUid.concat(",").concat(gamer.getId().toString());
                tbMessage.setFormUid(formUid);
                Integer f = tbMessageMapper.updateOne(game.getGamename() + "的评论");
                if (f>0){
                return true;}else {
                    return false;
                }
            }else {
                return false;
            }
        }else {
            String messageId = NewMessageId.getMessageId(game.getGamename()+":");
            TbMessage tbMessage = new TbMessage();
            tbMessage.setTopicType("游戏评论");
            tbMessage.setTopicName(tbGame.getGamename()+"的评论");
            tbMessage.setTopicId(game.getGamename()+":");
            Integer integer = tbMessageMapper.insertOne(tbMessage);
            if (integer>0){
                game.setTopicid(game.getGamename()+":");
                Integer flag = tbGameMapper.updateOneGame(game);
                if (flag>0){
                    comment.setSpeakId(messageId);
                    Integer falg = tbCommentMapper.insertOne(tbComment);
                    if(falg>0){
                        return true;
                    }else {
                        return false;
                    }
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
