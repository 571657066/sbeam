package com.sbeam.task;

import com.sbeam.dao.mappering.GamerMapper;
import com.sbeam.dao.mappering.TbGameMapper;
import com.sbeam.util.RemindToBuyGame;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class MindToBuy {

    @Resource
    GamerMapper gamerMapper;

    @Scheduled(cron ="0 00 00 ? * MON" )  //每个星期一 0点0分0秒执行
    public void sendtoemailtobuy(){
        List<String> list = gamerMapper.selectallForTask();
        for (String gamename :
                list) {
             RemindToBuyGame.Remind(null, gamename);
        }
    }
}
