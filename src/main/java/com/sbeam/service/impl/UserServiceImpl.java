package com.sbeam.service.impl;

import com.sbeam.dao.mappering.GamerMapper;
import com.sbeam.dao.mappering.TbFriendsMapper;
import com.sbeam.dao.pojo.Gamer;
import com.sbeam.dao.pojo.TbGame;
import com.sbeam.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {
    @Resource
    GamerMapper gamerMapper;

    @Resource
    TbFriendsMapper tbFriendsMapper;

    List<TbGame> list=null;
    @Override
    public Gamer Login(Gamer gamer) {
        gamer = gamerMapper.selectOneUser(gamer);
        //gamer如果为空 即账号或密码错误
        return gamer;
    }

    @Override
    public boolean Register(Gamer gamer) {
        Gamer gamer1 = gamerMapper.selectOneUser(gamer);
        if (gamer1==null){
            int i = gamerMapper.insertOneUser(gamer);
            if(i>0){
                return true;
            }
        }
            return false;


    }

    @Override
    public boolean Update(Gamer gamer) {
        int i = gamerMapper.updateOneUser(gamer);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public String selectWishGame(Gamer gamer) {
         String list = gamerMapper.selectWishGame(gamer);
        return list;
    }


    @Override
    public boolean addWishGame(Gamer gamer,String games) {
        String list = gamerMapper.selectWishGame(gamer);
        String newgames = list.concat(",").concat(games);
        String username = gamer.getUsername();
        Map<String, String> map = new HashMap<>();
        map.put(username,newgames);
        int i = gamerMapper.addWishGame(map);
        if (i>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean addHadGame(Gamer gamer,String games) {
        String list = gamerMapper.selectHadGame(gamer);
        String newgames = list.concat(",").concat(games);
        String username = gamer.getUsername();
        Map<String, String> map = new HashMap<>();
        map.put(username,newgames);
        int i = gamerMapper.addHadGame(map);
        if (i>0){
            return true;
        }
        return false;
    }

    @Override
    public String selectHadGame(Gamer gamer) {
        String list=gamerMapper.selectHadGame(gamer);
        return list;
    }

    @Override
    public List<String> selectFriend(Gamer gamer) {
        String str = tbFriendsMapper.selectFriend(gamer);
        String[] friend=str.split(",");
        List<String> friends = (List<String>) Arrays.asList(friend);
        return friends;
    }


    @Override
    public boolean addFriend(Gamer gamer,String friendname) {
        Map<Integer, String> map = new HashMap<>();
        String str = tbFriendsMapper.selectFriend(gamer);
        Integer id = tbFriendsMapper.selectFriendId(friendname);
        String friends = str.concat(",").concat(id.toString());
        Integer gamerId = gamer.getId();
        map.put(gamerId,friends);
        int flag = tbFriendsMapper.updateFriends(map);
        if (flag>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deletFriend(Gamer gamer, String friendname) {
        Map<Integer, String> map = new HashMap<>();
        String str = tbFriendsMapper.selectFriend(gamer);
        String fridens = str.replace(friendname, "");
        Integer gamerId = gamer.getId();
        map.put(gamerId,fridens);
        int flag = tbFriendsMapper.updateFriends(map);
        if (flag>0){
            return true;
        }
        return false;
    }

    @Override
    public Gamer selectOne(String gamername) {
        Gamer gamer = gamerMapper.selectGamer(gamername);
        return gamer;
    }




}
