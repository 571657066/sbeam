package com.sbeam.controller;

import com.sbeam.dao.pojo.Games;
import com.sbeam.service.RecommendGamesUservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 游客、用户推荐游戏
 */
@Controller
public class RecommendController {
    @Autowired
    RecommendGamesUservice recommendGamesUservice;

    //随机推荐
    @RequestMapping(value = "/recommendGames",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Games> Recommend(){
        List<Games> games = recommendGamesUservice.getRecommend();
        System.out.println(games);
        return games;
    }

    //销量热门推荐
    @RequestMapping(value = "/sealPopularGames",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Games> sealPopularGames(){
        List<Games> games = recommendGamesUservice.sealPopular();
        System.out.println(games);
        return games;
    }

    //底裤折扣推荐
    @RequestMapping(value = "/lowDiscount",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Games> lowDiscount(){
        List<Games> games = recommendGamesUservice.lowDiscount();
        System.out.println(games);
        return games;
    }
}
