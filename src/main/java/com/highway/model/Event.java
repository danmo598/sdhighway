package com.highway.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sd_event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 是否是精简版
     */
    private Boolean simple;

    private String year;

    @Column(name = "create_time")
    private Date createTime;

    private String events;

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
     * 获取是否是精简版
     *
     * @return simple - 是否是精简版
     */
    public Boolean getSimple() {
        return simple;
    }

    /**
     * 设置是否是精简版
     *
     * @param simple 是否是精简版
     */
    public void setSimple(Boolean simple) {
        this.simple = simple;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return events
     */
    public String getEvents() {
        return events;
    }

    /**
     * @param events
     */
    public void setEvents(String events) {
        this.events = events;
    }
}