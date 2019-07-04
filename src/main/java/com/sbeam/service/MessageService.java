package com.sbeam.service;



import com.sbeam.dao.pojo.Gamer;
import com.sbeam.dao.pojo.TbComment;
import com.sbeam.dao.pojo.TbGame;
import com.sbeam.dao.pojo.TbMessage;

public interface MessageService {

    /**
     * @param gamer
     * @param tbGame
     * @param tbComment
     * @return
     */
    boolean insertOrUpdateComment(Gamer gamer, TbGame tbGame, TbComment tbComment);
}
