package com.sbeam.dao.mappering;

import com.sbeam.dao.pojo.TbComment;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TbCommentMapper extends Mapper<TbComment> {
    //这个不应该提供
    /**
     * 根据tbComment更新数据库里的
     * @param tbComment
     * @return
     */
    Integer updateOne(TbComment tbComment);

    /**
     * 添加该评论
     * @param tbComment
     * @return
     */
    Integer insertOne(TbComment tbComment);

    List<TbComment> selectLikeOne(String topicid);
}