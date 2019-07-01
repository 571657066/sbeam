package com.sbeam.util;

import com.sbeam.dao.pojo.Gamer;
import com.sbeam.dao.pojo.TbGame;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Judas
 * 这个类作用：当用户愿望单里的游戏打折时提醒用户购买游戏
 */
public class RemindToBuyGame {

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
}
