package com.highway.model;

import javax.persistence.*;

@Table(name = "sd_provincial")
public class Provincial {
    @Id
    private Integer pid;

    @Column(name = "Provincial")
    private String provincial;

    /**
     * @return pid
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * @param pid
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * @return Provincial
     */
    public String getProvincial() {
        return provincial;
    }

    /**
     * @param provincial
     */
    public void setProvincial(String provincial) {
        this.provincial = provincial;
    }
}