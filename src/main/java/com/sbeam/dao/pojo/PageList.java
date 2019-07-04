package com.sbeam.dao.pojo;

import java.util.List;

public class PageList {
    List<TbAdmin> tbAdmins;
    Page pages;

    public List<TbAdmin> getTbAdmins() {
        return tbAdmins;
    }

    public void setTbAdmins(List<TbAdmin> tbAdmins) {
        this.tbAdmins = tbAdmins;
    }

    public Page getPages() {
        return pages;
    }

    public void setPages(Page pages) {
        this.pages = pages;
    }
}
