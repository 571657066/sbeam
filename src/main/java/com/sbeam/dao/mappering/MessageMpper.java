package com.sbeam.dao.mappering;

import com.sbeam.dao.pojo.Message;
import com.sbeam.dto.ArrayListVo;

import java.util.List;

public interface MessageMpper {

    /**
     * ɾ����������
     * @param id
     * @return
     */
    public Integer delMessage(Integer id);

    /**
     * ������
     * @return
     */
    public List<Message> listAllMessage();

    //��ѡɾ��
    Integer allDeleMessage(ArrayListVo arrayListVo);
}
