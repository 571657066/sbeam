package com.sbeam.util;

import com.sbeam.dao.mappering.TbGameMapper;
import com.sbeam.dao.pojo.TbGame;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class TotalPrice {

    @Resource
    static TbGameMapper tbGameMapper;
    /**
     * 传入游戏名列表  返回一共多少钱
     * @param gameList
     * @return
     */
    public static Long gettotalpriceForname(String gameList){
        String[] arr=gameList.split(",");
        List<String> list = Arrays.asList(arr);
        Long nowPrice=null;
        Long sumPrice=null;
        for (String gamenme: list) {
            TbGame game = tbGameMapper.selectOneGame(gamenme);
             nowPrice = game.getNowPrice();
             sumPrice+=nowPrice;
        }
        return sumPrice;
    }

    /**
     * 传入游戏id列表  返回一共多少钱
     * @param gameidList
     * @return
     */
    public static Long gettotalpriceForid(String gameidList){
        String[] arr=gameidList.split(",");
        List<String> list = Arrays.asList(arr);
        Long nowPrice=null;
        Long sumPrice=null;
        for (String gameid: list) {
            TbGame game = tbGameMapper.selectOneForid(Integer.valueOf(gameid));
            nowPrice = game.getNowPrice();
            sumPrice+=nowPrice;
        }
        return sumPrice;
    }
}
