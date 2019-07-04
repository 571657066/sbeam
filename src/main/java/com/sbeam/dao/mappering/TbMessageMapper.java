package com.sbeam.dao.mappering;

import com.sbeam.dao.pojo.TbMessage;
import tk.mybatis.mapper.common.Mapper;

public interface TbMessageMapper extends Mapper<TbMessage> {
    /**
     * 将tbmessage添加到数据库
     * @param tbMessage
     * @return
     */
    Integer insertOne(TbMessage tbMessage);

    /**
     * 根据tbMessage的name查询整个tbmessage
     * @param tbMessage
     * @return
     */
    TbMessage selectOne(TbMessage tbMessage);

    /**
     * 根据名字更新该message
     * @param topicName
     * @return
     */
    Integer updateOne(String topicName);
}