package com.highway.controller;

import com.github.pagehelper.PageInfo;
import com.highway.model.News;
import com.highway.service.INewsService;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Creaed by fj on 2018/10/29
 */
@RestController
public class NewsController {

    @Autowired
    INewsService newsService;

    @GetMapping(value="/getAllUsers")
    public PageInfo<News> getAllNews(Integer pageNo, Integer pageSize){
        List<News> newsList =  newsService.getAllNews(pageNo,pageSize);
        return new PageInfo<>(newsList);
    }

    @PostMapping(value = "/addNews")
    public Integer addNews(@RequestBody News news){
        return  newsService.addNews(news);
    }

    @PostMapping(value = "/updateUser")
    public Integer updateUser(@RequestBody News news){
        return  newsService.updateNews(news);
    }

    @PostMapping(value = "/deleteNews")
    public  Integer deleteNews(Integer id){
        return newsService.deleteNews(id);
    }

}
