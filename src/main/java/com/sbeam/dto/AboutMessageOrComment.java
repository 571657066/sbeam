package com.sbeam.dto;

import com.sbeam.dao.pojo.TbComment;
import com.sbeam.dao.pojo.TbGame;

public class AboutMessageOrComment {

    private TbGame tbGame;
    private TbComment tbComment;

    public TbComment getTbComment() {
        return tbComment;
    }

    public void setTbComment(TbComment tbComment) {
        this.tbComment = tbComment;
    }

    public TbGame getTbGame() {
        return tbGame;
    }

    public void setTbGame(TbGame tbGame) {
        this.tbGame = tbGame;
    }
}
