package com.sbeam.dto;

import com.sbeam.dao.pojo.TbDeveloper;
import com.sbeam.dao.pojo.TbGame;

public class AboutDiscountGame {
    private TbDeveloper tbDeveloper;
    private TbGame tbGame;
    private Double discount;

    public TbDeveloper getTbDeveloper() {
        return tbDeveloper;
    }

    public void setTbDeveloper(TbDeveloper tbDeveloper) {
        this.tbDeveloper = tbDeveloper;
    }

    public TbGame getTbGame() {
        return tbGame;
    }

    public void setTbGame(TbGame tbGame) {
        this.tbGame = tbGame;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
