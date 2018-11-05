package com.highway.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sd_connect_us")
public class ConnectUs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @Column(name = "publish_date")
    private Date publishDate;

    @Column(name = "watch_times")
    private Integer watchTimes;

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
     * @return publish_date
     */
    public Date getPublishDate() {
        return publishDate;
    }

    /**
     * @param publishDate
     */
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    /**
     * @return watch_times
     */
    public Integer getWatchTimes() {
        return watchTimes;
    }

    /**
     * @param watchTimes
     */
    public void setWatchTimes(Integer watchTimes) {
        this.watchTimes = watchTimes;
    }

    /**
     * @return url1
     */
    public String getUrl1() {
        return url1;
    }

    /**
     * @param url1
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