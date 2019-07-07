package com.sbeam.service.impl;

import com.sbeam.dao.mappering.*;
import com.sbeam.dao.pojo.*;
import com.sbeam.dto.ArrayListVo;
import com.sbeam.service.UserService;
import com.sbeam.util.TotalPrice;
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

    @Resource
    TbShopcarMapper tbShopcarMapper;
    List<TbGame> list=null;
    @Resource
    TbCommentMapper tbCommentMapper;
    @Resource
    TbGameMapper tbGameMapper;

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
    public boolean receiveFrom() {
        return false;
    }

    @Override
    public boolean speakTo(TbComment tbComment, String gamername, String othername) {
        Gamer gamer = gamerMapper.selectGamer(gamername);
        Integer gamerId = gamer.getId();
        Gamer other = gamerMapper.selectGamer(othername);
        Integer otherId = other.getId();
        tbComment.setSpeakId(gamerId.toString());
        tbComment.setUserId(otherId);
        Integer integer = tbCommentMapper.insertOne(tbComment);
        if (integer>0){
            return true;
        }
        return false;
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

 @Override
    public boolean changeshopcar(Gamer gamer, TbGame game) {
        Integer flag=0;
        TbGame tbGame = tbGameMapper.selectOneGame(game.getGamename());
        TbShopcar tbShopcar = tbShopcarMapper.selectOneshopcar(gamer);
        if (tbShopcar.getGamerid().indexOf(tbGame.getId())!=-1) {
            //这里表示购物车添加一个
            if (tbShopcar == null) {
                flag = tbShopcarMapper.insertOneshopcar(gamer);
                if (flag < 0) {
                    return false;
                }
                tbShopcar = tbShopcarMapper.selectOneshopcar(gamer);
            }
            Integer gameid = tbGame.getId();
            TbShopcar shopcar = new TbShopcar();
            String gameidlist = tbShopcar.getGameid();
            if (gameidlist == null) {
                gameidlist = gameid.toString();
                shopcar.setGameid(gameidlist);
            } else {
                gameidlist = gameidlist.concat(",").concat(gameid.toString());
                shopcar.setGameid(gameidlist);
            }
            shopcar.setGamerid(gamer.getId().toString());
            shopcar.setGamername(gamer.getUsername());
            shopcar.setTotalprice(TotalPrice.gettotalpriceForid(gameidlist));
            tbShopcarMapper.updateShopcar(shopcar);
        }else {
            //这里表示购物车减少一个
            Integer gameId = tbGame.getId();
            String gamesid = tbShopcar.getGameid();
            String replace=null;
            if (gamesid.indexOf(gameId)==0){
                replace = gamesid.replace(gameId.toString() + ",", "");
            }else {
                replace=gamesid.replace(","+gameId.toString(),"");
            }
            tbShopcar.setGameid(replace);
            tbShopcar.setTotalprice(TotalPrice.gettotalpriceForid(gamesid));
            tbShopcarMapper.updateShopcar(tbShopcar);
        }
        return true;
    }


    /**
     *
     * @return
     */
    @Override
    public List<Gamer> getNewsInfoBy() {
        return gamerMapper.getNewsInfoBy();
    }

    //单删除
    @Override
    public Integer deleArticeById(Gamer article) {
        return gamerMapper.deleArticeById(article);
    }
    //模糊查询
    @Override
    public List<Gamer> seletcAtricleId(String getaTitle) {
        return gamerMapper.seletcAtricleId(getaTitle);
    }

    //多选删除
    @Override
    public Integer allDeleAtricleByIds(ArrayListVo arrayListVo) {
        return gamerMapper.allDeleAtricleByIds(arrayListVo);
    }

}
