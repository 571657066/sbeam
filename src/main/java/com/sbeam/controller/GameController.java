package com.sbeam.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sbeam.dao.pojo.TbComment;
import com.sbeam.dao.pojo.TbGame;
import com.sbeam.dto.ArrayListVo;
import com.sbeam.service.GameService;
import com.sbeam.utils.TypePage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@Controller
@RequestMapping(value = "/game")
public class GameController {

    @Resource
    GameService gameService;


    /**
     * 根据单个游戏的游戏名获取该游戏的全部信息
     * @author Judas
     * @param tbGame
     * @return
     */
    @RequestMapping(value = "/selectonegame",method = RequestMethod.POST)
    @ResponseBody
    public Object selectonegame(@RequestBody TbGame tbGame) {
        TbGame game = gameService.selectOneGame(tbGame.getGamename());
        return game;
    }

    /**
     * 查询这个游戏的全部评论
     * @param tbGame
     * @return
     */
    @RequestMapping(value = "/selectgametopic",method = RequestMethod.POST)
    @ResponseBody
    public Object selectgametopic(@RequestBody TbGame tbGame) {
        List<TbComment> tbComments = gameService.selectGameTopic(tbGame);
        return tbComments;
    }


    /**
     * 分页
     * @param typePage
     * @return
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object getNewTypeInfoBy(@RequestBody TypePage typePage){
        PageHelper.startPage(typePage.getCurrentPage(),typePage.getPageCount());
        //该页的用户集合
        List<TbGame> articleList = gameService.getNewsInfoBy();
        System.out.println(articleList.get(0).toString());
        //分页数据
        PageInfo<TbGame> pageInfo=new PageInfo<TbGame>(articleList);
        pageInfo.setList(articleList);
        //当前页下标
        pageInfo.setNavigateFirstPage(typePage.getCurrentPage());
        //当前页下标+2
        pageInfo.setNavigatePages(typePage.getCurrentPage()+2);
        return pageInfo;
    }
    //伪删除deleById
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object deleById(@RequestParam int id){
        System.out.println(id);
        TbGame tbGame = new TbGame();
        tbGame.setId(id);
        Integer i= gameService.deleArticeById(tbGame);
        return i>0?true:false;
    }
    //模糊查询
    @RequestMapping("seletcAtricleId")
    public Object seletctId(@RequestBody TypePage typePage){

        System.out.println("11111111111111111111111111111111111111");

        PageHelper.startPage(typePage.getCurrentPage(),typePage.getPageCount());
        System.out.println(typePage.getaTitle()+"taTitle我我");

        List<TbGame> articleList= gameService.seletcAtricleId(typePage.getaTitle());
        System.out.println("我爱你");
        System.out.println(typePage.getCurrentPage()+"CurrentPage我我");
        System.out.println(typePage.getPageCount()+"PageCount()我我");

        PageInfo<TbGame> pageInfo=new PageInfo<TbGame>(articleList);
        pageInfo.setList(articleList);
        //当前页下标
        pageInfo.setNavigateFirstPage(typePage.getCurrentPage());
        //当前页下标+2
        pageInfo.setNavigatePages(typePage.getCurrentPage()+2);
        return  pageInfo;
    }
    //多选删除
    @RequestMapping("allDeleAtricleByIds")
    public Object allDeleAtricleByIds(@RequestBody ArrayListVo arrayListVo){

        return gameService.allDeleAtricleByIds(arrayListVo);
    }




}
