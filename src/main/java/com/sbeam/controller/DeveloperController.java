package com.sbeam.controller;

import com.sbeam.dao.pojo.TbDeveloper;
import com.sbeam.dao.pojo.TbGame;
import com.sbeam.dto.AboutDiscountGame;
import com.sbeam.service.DeveloperService;
import com.sbeam.util.JsonMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class DeveloperController {

    @Resource
    DeveloperService developerService;

    /**
     * 开发商选择自己的游戏进行打折
     * json写成这样
     * {
     * "tbGame":{"gamename":"1"},
     * "tbDeveloper":{"developername":"1"},
     * "discount":"0.2"
     * }
     *
     * @param aboutDiscountGame
     * @return
     */
    @RequestMapping(value = "/developercontroller/discountgame", method = RequestMethod.POST)
    @ResponseBody
    public Object discountgame(@RequestBody AboutDiscountGame aboutDiscountGame) {
        Double discount = aboutDiscountGame.getDiscount();
        TbDeveloper tbDeveloper = aboutDiscountGame.getTbDeveloper();
        TbGame tbGame = aboutDiscountGame.getTbGame();
        boolean b = developerService.discountGame(tbDeveloper, tbGame.getGamename(), discount);
        if (b) {
            return JsonMsg.success();
        } else {
            return JsonMsg.fail();
        }
    }

    /**开发商发布游戏 此处的传入的tbgame必须包含 名字，价钱，折扣之类的信息
     * @param tbGame
     * @param session
     * @return
     */
    @RequestMapping(value = "/developercontroller/issuregame", method = RequestMethod.POST)
    @ResponseBody
    public Object issuregame(@RequestBody TbGame tbGame, HttpSession session) {
        TbDeveloper developer = (TbDeveloper) session.getAttribute("developer");
        boolean b = developerService.issueGame(tbGame, developer);
        if (b) {
            return JsonMsg.success();
        } else {
            return JsonMsg.fail();
        }
    }



    /**
     * 开发商登陆
     * @param tbDeveloper
     * @param request
     * @return true为开发商的用户名密码正常 反之
     * @author Judas
     */
    @RequestMapping(value = "/developercontroller/login", method = RequestMethod.POST)
    @ResponseBody
    public Object login(@RequestBody TbDeveloper tbDeveloper, HttpServletRequest request) {
//        System.out.println("喵喵喵");
        tbDeveloper = developerService.Login(tbDeveloper);
        HttpSession session = request.getSession();
        if (tbDeveloper != null) {
            session.setAttribute("developer", tbDeveloper);
            return JsonMsg.success();
        } else {
            return JsonMsg.fail();
        }
    }

    /**
     * 注册
     * @param tbDeveloper
     * @return true为注册成功 false为开发商已存在或注册失败
     * @author Judas
     */
    @RequestMapping(value = "/developercontroller/register", method = RequestMethod.POST)
    @ResponseBody
    public Object register(@RequestBody TbDeveloper tbDeveloper) {
        boolean falg = developerService.Register(tbDeveloper);
        if (falg) {
            return JsonMsg.success();
        } else {
            return JsonMsg.fail();
        }
    }

    /**
     * 根据gamer更新gamer
     * @param tbDeveloper
     * @return true为更新成功 反之
     * @author Judas
     */
    @RequestMapping(value = "/developercontroller/update", method = RequestMethod.POST)
    @ResponseBody
    public Object update(@RequestBody TbDeveloper tbDeveloper) {
        boolean falg = developerService.Update(tbDeveloper);
        if (falg) {
            return JsonMsg.success();
        } else {
            return JsonMsg.fail();
        }
    }
}