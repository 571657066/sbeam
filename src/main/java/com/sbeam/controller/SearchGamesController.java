package com.sbeam.controller;


import com.sbeam.dao.pojo.Games;
import com.sbeam.service.SearchGamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SearchGamesController {

    @Autowired
    SearchGamesService searchGamesService;

    /**
     * 游戏查找
     * @param games
     * @return
     */
    @RequestMapping(value = "/searchGames",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Games> searchGames(@RequestBody Games games){
        String gamename = games.getGamename();

        List<Games> games1 = searchGamesService.secrchGames(gamename);

        return games1;

    }

    /**
     * 单个游戏详情展示
     * @param games
     * @return
     */
    @RequestMapping(value = "/getGameById",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public Games getGameById(@RequestBody Games games){
        int id = games.getId();

        Games games1 = searchGamesService.getGameById(id);

        return games1;

    }
}
