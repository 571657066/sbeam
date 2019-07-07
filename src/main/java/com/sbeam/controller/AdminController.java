package com.sbeam.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sbeam.dao.pojo.*;
import com.sbeam.service.AdminService;
import com.sbeam.service.impl.AdminServiceImpl;
import com.sbeam.util.JsonMsg;
import com.sbeam.utils.TypePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Resource
    AdminService adminService;

    @Autowired
    AdminServiceImpl AdminServiceImpl;

    /**
     * 对登录页面输入的用户名和密码做简单的判断
     * @param request
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public TbAdmin dologin(@RequestBody TbAdmin tbAdmin ,HttpServletRequest request) throws IOException {
        TbAdmin login = AdminServiceImpl.getLogin(tbAdmin);
        HttpSession session = request.getSession();
        if (login!=null){
            System.out.println("登陆成功");
            session.setAttribute("admin",login);
            return login;
        }else {
            return null;
        }
    }

    /**
     * 退出登录：从主页面跳转到登录页面
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    public String logout(){
        return "login";
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
        List<TbAdmin> articleList = adminService.listAllAdmin();
        //分页数据
        PageInfo<TbAdmin> pageInfo=new PageInfo<TbAdmin>(articleList);
        pageInfo.setList(articleList);
        //当前页下标
        pageInfo.setNavigateFirstPage(typePage.getCurrentPage());
        //当前页下标+2
        pageInfo.setNavigatePages(typePage.getCurrentPage()+2);
        return pageInfo;
    }

    /**
     * 管理员注册
     * @param tbAdmin
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/insert",method = RequestMethod.GET)
    public String addTbAdmin(@RequestBody TbAdmin tbAdmin){
        boolean b = adminService.addTbAdmin(tbAdmin);
        if (b){
            System.out.println("注册成功");
            return "true";
        }else {
            System.out.println("注册失败");
            return "false";
        }
    }

    /**
     * 管理员修改
     * @param tbAdmin
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update")
    public Object updateadmin(@RequestBody TbAdmin tbAdmin){
        int count = adminService.updateTbAdmin(tbAdmin);
        if (count>0){
            return true;
        }
        return false;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public Object delete(@RequestParam int id){
        TbAdmin tbAdmin = new TbAdmin();
        tbAdmin.setId(id);
        int cop = adminService.delAdmin(tbAdmin);
        if (cop>0){
            return true;
        }
        return false;
    }







}
