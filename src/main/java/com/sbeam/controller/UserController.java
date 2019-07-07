package com.sbeam.controller;
import com.sbeam.dao.pojo.Article;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sbeam.dao.pojo.*;
import com.sbeam.dto.AboutMessageOrComment;
import com.sbeam.dto.ArrayListVo;
import com.sbeam.service.GameService;
import com.sbeam.service.MessageService;
import com.sbeam.service.impl.UserServiceImpl;
import com.sbeam.util.JsonMsg;
import com.sbeam.util.RemindToBuyGame;
import com.sbeam.utils.TypePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/usercontroller")
public class UserController {


    @Autowired
    UserServiceImpl userService;

    @Resource
    GameService gameService;

    @Resource
    JsonMsg jsonMsg;

    @Resource
    MessageService messageService;
    /**
     * 登陆
     * @param gamer
     * @param request
     * @return true为用户名密码正常 反之
     * @author Judas
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Object login(@RequestBody Gamer gamer, HttpServletRequest request) {
//        System.out.println("喵喵喵");
        gamer = userService.Login(gamer);
        HttpSession session = request.getSession();
        if (gamer != null) {
            session.setAttribute("user", gamer);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 注册
     * @param gamer
     * @return true为注册成功 false为用户名已存在或注册失败
     * @author Judas
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Object register(@RequestBody Gamer gamer, HttpServletResponse response) {
        boolean falg = userService.Register(gamer);
        if (falg) {
            return JsonMsg.success();
        } else {
            return JsonMsg.fail();
        }
    }

    /**
     * 根据gamer更新gamer
     * @param gamer
     * @param response
     * @return true为注册成功 反之
     * @author Judas
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Object update(@RequestBody Gamer gamer, HttpServletResponse response) {
        boolean falg = userService.Update(gamer);
        if (falg) {
            return JsonMsg.success();
        } else {
            return JsonMsg.fail();
        }
    }

    /**
     * 添加游戏进愿望单
     * @param tbGame
     * @param request
     * @return
     * @author Judas
     */
    @RequestMapping(value = "/addwishgames", method = RequestMethod.POST)
    @ResponseBody
    public Object addwishgames(@RequestBody TbGame tbGame, HttpServletRequest request) {
        String gamename = tbGame.getGamename();
        Gamer gamer = (Gamer) request.getSession().getAttribute("user");
        boolean falg = userService.addWishGame(gamer, gamename);
        if (falg) {
            return JsonMsg.success();
        } else {
            return JsonMsg.fail();
        }
    }

    /**
     * 用户购买游戏后调用
     * @param tbGame
     * @param request
     * @return
     * @author Judas
     */
    @RequestMapping(value = "/addhadgames", method = RequestMethod.POST)
    @ResponseBody
    public Object addhadgames(@RequestBody TbGame tbGame, HttpServletRequest request) {
        String gamename = tbGame.getGamename();
        Gamer gamer = (Gamer) request.getSession().getAttribute("user");
        boolean falg = userService.addHadGame(gamer, gamename);
        if (falg) {
            return JsonMsg.success();
        } else {
            return JsonMsg.fail();
        }
    }

    /**
     * 获取愿望单里的折扣游戏
     *
     * @param session
     * @param request
     * @return
     * @author Judas
     */
    @RequestMapping(value = "/getdiscountgame", method = RequestMethod.POST)
    @ResponseBody
    public Object getdiscountgame(HttpSession session, HttpServletRequest request) {
        Gamer gamer = (Gamer) request.getSession().getAttribute("user");
        String wishList = gamer.getWishList();
        List<String> remind = RemindToBuyGame.Remind(session);
        return remind;
    }

    /**
     * 前端json必须写成
     *      {
     * 	        "tbGame":{"gamename":"1"},
     * 	        "tbComment":{"content":"喵喵喵"}
     *      }
     * 因为这里需要传过来两个对象
     * 将用户的评论写到数据库相应的几个表
     * 这里逻辑很复杂
     * @author Judas
     * @param param
     * @param session
     * @return
     */
    @RequestMapping(value = "/discussGame",method = RequestMethod.POST)
    @ResponseBody
    public Object discussGame(@RequestBody AboutMessageOrComment param, HttpSession session) {
        TbGame tbGame = param.getTbGame();
        TbComment tbComment = param.getTbComment();
        Gamer gamer = (Gamer) session.getAttribute("user");
        String haveGames = gamer.getHaveGames();
        if(haveGames.indexOf(tbGame.getGamename())!=-1){
            //进到这里表示用户有这个游戏 可以对此评论
            //TODO 获取该游戏的about_topicid 如果about_topicid为空 则在message里新建一个并将id给about_topicid
            //TODO 将评论内容 用户id about_topicid放在tbComment里然后放数据库 (这里about_topicid给service层处理)
        boolean b = messageService.insertOrUpdateComment(gamer, tbGame, tbComment);
        if (b){
            return JsonMsg.success();
        }else {
            return JsonMsg.fail();
        }
        }else{
            jsonMsg.setCode(300);
            jsonMsg.setMsg("用户没有这个游戏，不能评论");
            return jsonMsg;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    public Object updateuser(@RequestBody String gamername,HttpServletRequest request) {
        Gamer gamer = userService.selectOne(gamername);
        HttpSession session = request.getSession();
        if (gamer != null) {
            session.setAttribute("user", gamer);
            return gamer;
        }
        return false;
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
        List<Gamer> articleList = userService.getNewsInfoBy();
        //分页数据
        PageInfo<Gamer> pageInfo=new PageInfo<Gamer>(articleList);
        pageInfo.setList(articleList);
        //当前页下标
        pageInfo.setNavigateFirstPage(typePage.getCurrentPage());
        //当前页下标+2
        pageInfo.setNavigatePages(typePage.getCurrentPage()+2);
        return pageInfo;
    }
    //伪删除deleById
    @RequestMapping("deleArticeById")
    public Object deleById(@RequestBody Gamer gamer){

        Integer i= userService.deleArticeById(gamer);

        return i;
    }
    //模糊查询
    @RequestMapping("seletcAtricleId")
    public Object seletctId(@RequestBody TypePage typePage){

        System.out.println("11111111111111111111111111111111111111");

        PageHelper.startPage(typePage.getCurrentPage(),typePage.getPageCount());
        System.out.println(typePage.getaTitle()+"taTitle我我");

        List<Gamer> articleList= userService.seletcAtricleId(typePage.getaTitle());
        System.out.println("我爱你");
        System.out.println(typePage.getCurrentPage()+"CurrentPage我我");
        System.out.println(typePage.getPageCount()+"PageCount()我我");

        PageInfo<Gamer> pageInfo=new PageInfo<Gamer>(articleList);
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

        return userService.allDeleAtricleByIds(arrayListVo);
    }

}
