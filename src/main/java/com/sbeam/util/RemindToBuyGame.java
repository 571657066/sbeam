package com.sbeam.util;

import com.sbeam.dao.mappering.GamerMapper;
import com.sbeam.dao.mappering.TbGameMapper;
import com.sbeam.dao.pojo.Gamer;
import com.sbeam.dao.pojo.TbGame;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Judas
 * 这个类作用：当用户愿望单里的游戏打折时提醒用户购买游戏
 */
public class RemindToBuyGame {

    @Resource
    static TbGameMapper tbGameMapper;

    @Resource
    static GamerMapper gamerMapper;
    /**
     * 登陆时提醒
     * @param session
     * @return
     */
    public static List<String> Remind(HttpSession session){
        Double discount=null;
        List<String> list = new ArrayList<>();                          //放有打折游戏的集合
        Gamer gamer = (Gamer) session.getAttribute("user");
        String wishList = gamer.getWishList();
        String[] games=wishList.split(",");
        for (String str: games) {
             discount = SelectIsDiscount.selectGame(str);
             //该游戏打折
             if (discount<0){
                 list.add(str);
             }
        }
            return list;
    }

    /**用户的愿望单里的打折邮箱 发邮件给用户提醒他
     * 邮件提醒
     * @param gamer
     * @return
     */
    public static boolean Remind(Gamer gamer,String gamename){
        String text=null;
        Double discount=null;
        List<String> list = new ArrayList<>();
        if (gamer==null){
             gamer = gamerMapper.selectGamer(gamename);
        }
        String email = gamer.getEmail();
        if (email==null){   //用户邮箱都拿不到 还发什么
            return false;
        }
        String wishList = gamer.getWishList();
        String[] games=wishList.split(",");
        for (String str: games) {
            discount = SelectIsDiscount.selectGame(str);
            //该游戏打折
            if (discount<0){
                list.add(str);
            }
        }
        for (String str : list) {
            TbGame tbGame = tbGameMapper.selectOneGame(str);
            Long nowPrice = tbGame.getNowPrice();
            text=text.concat(str+":"+nowPrice.toString()+"/n");
        }
        try {
            SendEmail.sendMail(email,"你愿望单里有游戏打折中"+text);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
