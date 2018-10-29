package com.highway.controller;

import com.github.pagehelper.PageInfo;
import com.highway.model.News;
import com.highway.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Creaed by fj on 2018/10/29
 */

/**
 * 新闻模块
 */
@RestController
@RequestMapping(value = "news")
public class NewsController {

    @Autowired
    INewsService newsService;

    /**
     * 分页获取新闻
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping(value="/getAllNews")
    public PageInfo<News> getAllNews(Integer pageNo, Integer pageSize){
        List<News> newsList =  newsService.getAllNews(pageNo,pageSize);
        return new PageInfo<>(newsList);
    }


    /**
     * 添加新闻
     * @param news
     * @return
     */
    @PostMapping(value = "/addNews")
    public Integer addNews(@RequestBody News news){
        return  newsService.addNews(news);
    }

    /**
     * 更新新闻
     * @param news
     * @return
     */
    @PostMapping(value = "/updateUser")
    public Integer updateUser(@RequestBody News news){
        return  newsService.updateNews(news);
    }

    /**
     * 删除新闻
     * @param id
     * @return
     */
    @PostMapping(value = "/deleteNews")
    public  Integer deleteNews(Integer id){
        return newsService.deleteNews(id);
    }



}
