package com.sbeam.dao.mappering;

import com.sbeam.dao.pojo.Message;
import com.sbeam.dto.ArrayListVo;

import java.util.List;

public interface MessageMpper {

    /**
     * 删除单个评论
     * @param id
     * @return
     */
    public Integer delMessage(Integer id);

    /**
     * 遍历所
     * @return
     */
    public List<Message> listAllMessage();

    //多选删除
    Integer allDeleMessage(ArrayListVo arrayListVo);
}
