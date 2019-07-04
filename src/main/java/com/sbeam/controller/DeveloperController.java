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

@Controller
public class DeveloperController {

    @Resource
    DeveloperService developerService;

    /**
     *
     * @param aboutDiscountGame
     * @return
     */
    @RequestMapping(value = "/developercontroller/discountgame",method = RequestMethod.POST)
    @ResponseBody
    public Object discountgame(@RequestBody AboutDiscountGame aboutDiscountGame) {
        Double discount = aboutDiscountGame.getDiscount();
        TbDeveloper tbDeveloper = aboutDiscountGame.getTbDeveloper();
        TbGame tbGame = aboutDiscountGame.getTbGame();
        boolean b = developerService.discountGame(tbDeveloper, tbGame.getGamename(), discount);
        if (b){
            return JsonMsg.success();
        }else {
            return JsonMsg.fail();
        }
    }
}
