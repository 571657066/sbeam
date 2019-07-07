package com.sbeam.dao.pojo;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "shopcar")
public class TbShopcar   {
    @Id
    private Integer id;

    private String gamerid;


    private String gamername;


    private String gameid;

    private Long totalprice;

    public Long getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Long totalprice) {
        this.totalprice = totalprice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGamerid() {
        return gamerid;
    }

    public void setGamerid(String gamerid) {
        this.gamerid = gamerid;
    }

    public String getGamername() {
        return gamername;
    }

    public void setGamername(String gamername) {
        this.gamername = gamername;
    }

    public String getGameid() {
        return gameid;
    }

    public void setGameid(String gameid) {
        this.gameid = gameid;
    }
}
