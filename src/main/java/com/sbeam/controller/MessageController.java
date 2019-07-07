package com.sbeam.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sbeam.dao.pojo.Message;
import com.sbeam.dao.pojo.TbMessage;
import com.sbeam.service.MessageService;
import com.sbeam.service.impl.MessageServiceImpl;
import com.sbeam.utils.TypePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/message")
public class MessageController {

    @Resource
    MessageService messageService;


    /**
     * 分页
     * @param typePage
     * @return
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object getNewTypeInfoBy(@RequestBody TypePage typePage){
        System.out.println(typePage.getCurrentPage()+typePage.getPageCount());
        PageHelper.startPage(typePage.getCurrentPage(),typePage.getPageCount());
        //该页的用户集合
        List<Message> articleList = messageService.listAllAdmin();
        //分页数据
        PageInfo<Message> pageInfo=new PageInfo<Message>(articleList);
        pageInfo.setList(articleList);
        //当前页下标
        pageInfo.setNavigateFirstPage(typePage.getCurrentPage());
        //当前页下标+2
        pageInfo.setNavigatePages(typePage.getCurrentPage()+2);
        return pageInfo;
    }


    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public Object delete(@RequestParam int id){
        int cop = messageService.delAdmin(id);
        if (cop>0){
            return true;
        }
        return false;
    }






}
