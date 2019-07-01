package com.sbeam.controller;

import com.sbeam.dao.pojo.Gamer;
import com.sbeam.service.impl.UserServiceImpl;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class UserController {


    @Autowired
    UserServiceImpl userservice;

    /**
     * 登陆
     * @author Judas
     * @param gamer
     * @param request
     * @param response
     * @return true为用户名密码正常 反之
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Object login(@RequestBody Gamer gamer, HttpServletRequest request,HttpServletResponse response){
//        System.out.println("喵喵喵");
        gamer = userservice.Login(gamer);
        HttpSession session = request.getSession();
        if (gamer!=null){
            session.setAttribute("user",gamer);
            System.out.println("喵喵喵");
            return true;
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
        boolean falg = userservice.Register(gamer);
        if (falg){
            System.out.println("喵喵喵");
            return true;
        }else {
            return false;
        }
    }
}
