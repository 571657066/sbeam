package com.sbeam.controller;

import com.sbeam.dao.pojo.Gamer;
import com.sbeam.dao.pojo.TbGame;
import com.sbeam.service.UserService;
import com.sbeam.util.JsonMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ShopController {
    @Resource
    UserService userService;

    /**
     * 用户在游戏页面点击添加购物车时调用这个
     * @param tbGame
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/shopcontroller/changeshopcar",method = RequestMethod.POST)
    public Object changeshopcar(@RequestBody TbGame tbGame, HttpSession session)
    {
        Gamer gamer = (Gamer) session.getAttribute("user");
        boolean flag = userService.changeshopcar(gamer, tbGame);
        if (flag){
            return JsonMsg.success();
        }else {
            return JsonMsg.fail();
        }
    }

    /**
     * 购物车里的游戏同时埋单成功之后更改数据库数据
     * @param list
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/shopcontroller/maidan",method = RequestMethod.POST)
    public Object maidan(@RequestBody List<TbGame> list, HttpSession session)
    {
        Gamer gamer = (Gamer) session.getAttribute("user");
        for (TbGame tbGame:list) {
            boolean flag1 = userService.changeshopcar(gamer, tbGame);
            boolean flag2 = userService.addHadGame(gamer, tbGame.getGamename());
            if ((!flag1)||(!flag2))
                return JsonMsg.fail();
        }
            return JsonMsg.success();
    }

}
