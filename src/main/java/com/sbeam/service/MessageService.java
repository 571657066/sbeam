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
     * ɾ����������
     * @param id
     * @return
     */
    public Integer delAdmin(Integer id);

    /**
     * ������
     * @return
     */
    public List<Message> listAllAdmin();

    //��ѡɾ��
    Integer allDeleAtricleByIds(ArrayListVo arrayListVo);
}
