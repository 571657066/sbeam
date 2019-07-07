package com.sbeam.controller;

import com.sbeam.dao.pojo.Gamers;

import com.sbeam.dao.pojo.Games;
import com.sbeam.service.LikeGamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 用户游戏推荐
 *
 */
@Controller
public class LikeGamesController {

    @Autowired
    LikeGamesService likeGamesService;

    //用户点击类型推荐
    @RequestMapping(value = "/clickType",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Games> clickType(@RequestBody Games games){

        System.out.println(games+"点击类型");
        String type1 = games.getType();
        List<Games> games1 = likeGamesService.getGamesByType(type1);

        return games1;
    }

    //根据用户喜欢类型推荐
    @RequestMapping(value = "/likeGames",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Games> getLikeGames(@RequestBody Gamers gamers){

        int id = gamers.getId();

        String games1 = likeGamesService.likeTypes(id);

        String[] split = games1.split(",");

        List<Games> games = likeGamesService.likeTypesGet(split);

        return games;
    }
}
