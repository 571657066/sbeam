package com.sbeam.controller;

import com.sbeam.dao.pojo.TbComment;
import com.sbeam.dao.pojo.TbGame;
import com.sbeam.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;


@Controller
public class GameController {

    @Resource
    GameService gameService;


    /**
     * 根据单个游戏的游戏名获取该游戏的全部信息
     * @author Judas
     * @param tbGame
     * @return
     */
    @RequestMapping(value = "/gamecontroller/selectonegame",method = RequestMethod.POST)
    @ResponseBody
    public Object selectonegame(@RequestBody TbGame tbGame) {
        TbGame game = gameService.selectOneGame(tbGame.getGamename());
        return game;
    }

    @RequestMapping(value = "/gamecontroller/selectgametopic",method = RequestMethod.POST)
    @ResponseBody
    public Object selectgametopic(@RequestBody TbGame tbGame) {
        List<TbComment> tbComments = gameService.selectGameTopic(tbGame);
        return tbComments;
    }
}
