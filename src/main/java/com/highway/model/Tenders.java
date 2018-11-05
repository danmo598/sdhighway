package com.highway.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sd_tenders")
public class Tenders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    /**
     * 发布时间
     */
    @Column(name = "publish_date")
    private Date publishDate;

    /**
     * 浏览次数
     */
    @Column(name = "watch_times")
    private Integer watchTimes;

    /**
     * 省份id
     */
    @Column(name = "pro_id")
    private Integer proId;

    /**
     * 省份name
     */
    @Column(name = "pro_name")
    private String proName;

    /**
     * 城市id
     */
    @Column(name = "city_id")
    private Integer cityId;

    /**
     * 城市name
     */
    @Column(name = "city_name")
    private String cityName;

    /**
     * 标文附件下载连接地址
     */
    private String url1;

    private String url2;

    private String url3;

    private String url4;

    private String url5;

    private String content;

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
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取发布时间
     *
     * @return publish_date - 发布时间
     */
    public Date getPublishDate() {
        return publishDate;
    }

    /**
     * 设置发布时间
     *
     * @param publishDate 发布时间
     */
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    /**
     * 获取浏览次数
     *
     * @return watch_times - 浏览次数
     */
    public Integer getWatchTimes() {
        return watchTimes;
    }

    /**
     * 设置浏览次数
     *
     * @param watchTimes 浏览次数
     */
    public void setWatchTimes(Integer watchTimes) {
        this.watchTimes = watchTimes;
    }

    /**
     * 获取省份id
     *
     * @return pro_id - 省份id
     */
    public Integer getProId() {
        return proId;
    }

    /**
     * 设置省份id
     *
     * @param proId 省份id
     */
    public void setProId(Integer proId) {
        this.proId = proId;
    }

    /**
     * 获取省份name
     *
     * @return pro_name - 省份name
     */
    public String getProName() {
        return proName;
    }

    /**
     * 设置省份name
     *
     * @param proName 省份name
     */
    public void setProName(String proName) {
        this.proName = proName;
    }

    /**
     * 获取城市id
     *
     * @return city_id - 城市id
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * 设置城市id
     *
     * @param cityId 城市id
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * 获取城市name
     *
     * @return city_name - 城市name
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * 设置城市name
     *
     * @param cityName 城市name
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * 获取标文附件下载连接地址
     *
     * @return url1 - 标文附件下载连接地址
     */
    public String getUrl1() {
        return url1;
    }

    /**
     * 设置标文附件下载连接地址
     *
     * @param url1 标文附件下载连接地址
     */
    public void setUrl1(String url1) {
        this.url1 = url1;
    }

    /**
     * @return url2
     */
    public String getUrl2() {
        return url2;
    }

    /**
     * @param url2
     */
    public void setUrl2(String url2) {
        this.url2 = url2;
    }

    /**
     * @return url3
     */
    public String getUrl3() {
        return url3;
    }

    /**
     * @param url3
     */
    public void setUrl3(String url3) {
        this.url3 = url3;
    }

    /**
     * @return url4
     */
    public String getUrl4() {
        return url4;
    }

    /**
     * @param url4
     */
    public void setUrl4(String url4) {
        this.url4 = url4;
    }

    /**
     * @return url5
     */
    public String getUrl5() {
        return url5;
    }

    /**
     * @param url5
     */
    public void setUrl5(String url5) {
        this.url5 = url5;
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }
}