package com.sbeam.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sbeam.dao.pojo.*;
import com.sbeam.service.AdminService;
import com.sbeam.service.impl.AdminServiceImpl;
import com.sbeam.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Resource
    AdminService adminService;

    @Autowired
    AdminServiceImpl AdminServiceImpl;
    /**
     * 登录：跳转到登录页面
     * @return
     */
    @RequestMapping(value = "/getlogin", method = RequestMethod.GET)
    public String login(){
        return "lohdfgin";

    }

    /**
     * 对登录页面输入的用户名和密码做简单的判断
     * @param request
     * @return
     */
    @RequestMapping(value = "/admin/dologin", method = RequestMethod.POST)
    @ResponseBody
    public TbAdmin dologin(@RequestBody TbAdmin tbAdmin ,HttpServletRequest request) throws IOException {
        System.out.println(tbAdmin.getAdminname()+tbAdmin.getPassword());
        TbAdmin login = adminService.getLogin(tbAdmin.getAdminname(), tbAdmin.getPassword());
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
     * 跳转到主页面
     * @return
     */
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(){
        return "magsin";
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
     * 分页显示
     * @param pageNo
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list")
    public Object pageList(@RequestBody Page2 page2){
        System.out.println(page2.getPageNo()+"吃屎");

        PageHelper.startPage(page2.getPageNo(),page2.getPageSize());
        TbAdmin tbAdmin = new TbAdmin();
        List<TbAdmin> list = adminService.listAllPage(tbAdmin);
        PageInfo<TbAdmin> pageInfo = new PageInfo<>(list);
        Page page = new Page();
        page.setCurrentPage(pageInfo.getPageNum());
        page.setPageCount(pageInfo.getPages());

        PageList pageList = new PageList();
        pageList.setPages(page);
        pageList.setTbAdmins(list);
        return pageList;

    }


}
