package com.sbeam.dao.mappering;

import com.sbeam.dao.pojo.TbGame;
import com.sbeam.dto.ArrayListVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TbGameMapper extends Mapper<TbGame> {
    /**
     * 查询某用户的愿望单或者游戏列表里是否有折扣游戏
     * @param gamename
     * @return
     */
    Double SelectIsDiscount(String gamename);

    /**
     * 根据游戏名获取该游戏的全部信息
     * @param gamename
     * @return
     */
    TbGame selectOneGame(String gamename);

    /**
     * 更新
     * @param tbGame
     * @return
     */
    Integer updateOneGame(TbGame tbGame);

    /**
     * 添加游戏
     * @param tbGame
     * @return
     */
    Integer insertOne(TbGame tbGame);

    /**
     * 根据id找到这个游戏(这个函数不应该有的)
     * @param id
     * @return
     */
    TbGame selectOneForid(Integer id);

    //分页1
    List<TbGame> getNewsInfoBy();
    //单删
    Integer deleArticeById(TbGame article);
    //模糊查询
    List<TbGame> seletcAtricleId(String getaTitle);
    //多选删除
    Integer allDeleAtricleByIds(ArrayListVo arrayListVo);

}