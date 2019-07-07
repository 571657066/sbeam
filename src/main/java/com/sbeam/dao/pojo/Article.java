package com.sbeam.dao.pojo;

import java.sql.Date;

public class Article {

    private int aId;
    private String aTitle;
    private String body;
    private Date releaseTime;
    private String source;
    private int like;
    private int typeId;
    private int status;

    public Article() {
    }

    public Article(int aId, String aTitle, String body, Date releaseTime, String source, int like, int typeId, int status) {
        this.aId = aId;
        this.aTitle = aTitle;
        this.body = body;
        this.releaseTime = releaseTime;
        this.source = source;
        this.like = like;
        this.typeId = typeId;
        this.status = status;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getaTitle() {
        return aTitle;
    }

    public void setaTitle(String aTitle) {
        this.aTitle = aTitle;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Article{" +
                "aId=" + aId +
                ", aTitle='" + aTitle + '\'' +
                ", body='" + body + '\'' +
                ", releaseTime=" + releaseTime +
                ", source='" + source + '\'' +
                ", like=" + like +
                ", typeId=" + typeId +
                ", status=" + status +
                '}';
    }
}
