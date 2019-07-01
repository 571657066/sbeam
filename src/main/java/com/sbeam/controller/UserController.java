package com.sbeam.controller;

import com.sbeam.dao.pojo.Gamer;
import com.sbeam.dao.pojo.TbGame;
import com.sbeam.service.GameService;
import com.sbeam.service.impl.UserServiceImpl;
import com.sbeam.util.RemindToBuyGame;
import com.sun.xml.internal.bind.v2.TODO;
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
import java.io.IOException;
import java.util.List;

@Controller
public class UserController {


    @Autowired
    UserServiceImpl userService;

    @Resource
    GameService gameService;

    /**
     * 登陆
     * @author Judas
     * @param gamer
     * @param request
     * @return true为用户名密码正常 反之
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Object login(@RequestBody Gamer gamer, HttpServletRequest request){
//        System.out.println("喵喵喵");
        gamer = userService.Login(gamer);
        HttpSession session = request.getSession();
        if (gamer!=null){
            session.setAttribute("user",gamer);
            return gamer;
        }else {
            return false;
        }
    }

    /**
     * 注册
     * @author Judas
     * @param gamer
     * @return true为注册成功 false为用户名已存在或注册失败
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public Object register(@RequestBody Gamer gamer,HttpServletResponse response) {
        boolean falg = userService.Register(gamer);
        if (falg){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 根据gamer更新gamer
     * @author Judas
     * @param gamer
     * @param response
     * @return true为注册成功 反之
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public Object update(@RequestBody Gamer gamer,HttpServletResponse response) {
        boolean falg = userService.Update(gamer);
        if (falg){
            return true;
        }else {
            return false;
        }
    }

    @RequestMapping(value = "/addwishgames",method = RequestMethod.POST)
    @ResponseBody
    public Object addwishgames(@RequestBody TbGame tbGame, HttpServletRequest request) {
        String gamename = tbGame.getGamename();
        Gamer gamer = (Gamer) request.getSession().getAttribute("user");
        boolean falg = userService.addWishGame(gamer, gamename);
        if(falg){
            return true;
        }else {
            return false;
        }
    }

    @RequestMapping(value = "/getdiscountgame",method = RequestMethod.POST)
    @ResponseBody
    public Object getdiscountgame( HttpSession session,HttpServletRequest request) {
        Gamer gamer = (Gamer)request.getSession().getAttribute("user");
        String wishList = gamer.getWishList();
        List<String> remind = RemindToBuyGame.Remind(session);
        return remind;
    }
}
