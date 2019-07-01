package com.sbeam.pojo;

import javax.persistence.*;

@Table(name = "admin_info")
public class TbAdmin {
    @Id
    private Integer id;

    @Column(name = "adminName")
    private String adminname;

    private String password;

    private Integer flag;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return adminName
     */
    public String getAdminname() {
        return adminname;
    }

    /**
     * @param adminname
     */
    public void setAdminname(String adminname) {
        this.adminname = adminname == null ? null : adminname.trim();
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * @return flag
     */
    public Integer getFlag() {
        return flag;
    }

    /**
     * @param flag
     */
    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}