package com.sbeam.service;



import com.sbeam.dao.pojo.*;
import com.sbeam.dto.ArrayListVo;

import java.util.List;

public interface MessageService {

    /**
     * @param gamer
     * @param tbGame
     * @param tbComment
     * @return
     */
    boolean insertOrUpdateComment(Gamer gamer, TbGame tbGame, TbComment tbComment);

    /**
     * 删除单个评论
     * @param id
     * @return
     */
    public Integer delAdmin(Integer id);

    /**
     * 遍历所
     * @return
     */
    public List<Message> listAllAdmin();

    //多选删除
    Integer allDeleAtricleByIds(ArrayListVo arrayListVo);
}
