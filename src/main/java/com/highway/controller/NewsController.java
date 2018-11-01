package com.highway.controller;

import com.github.pagehelper.PageInfo;
import com.highway.exception.BaseException;
import com.highway.model.News;
import com.highway.service.INewsService;
import com.highway.util.response.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "新闻相关接口")
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
    @ApiOperation(value="(后台)分页获取新闻")
    public PageInfo<News> getAllNews(@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize){
        List<News> newsList =  newsService.getAllNews(pageNo,pageSize);
        return new PageInfo<>(newsList);
    }


    /**
     * 添加新闻
     * @param news
     * @return
     */
    @PostMapping(value = "/addNews")
    @ApiOperation(value="(后台)添加一条新闻")
    public Integer addNews(@RequestBody News news){
        return  newsService.addNews(news);
    }

    /**
     * 更新新闻
     * @param news
     * @return
     */
    @PostMapping(value = "/updateUser")
    @ApiOperation(value="(后台)更新一条新闻")
    public Integer updateUser(@RequestBody News news){
        return  newsService.updateNews(news);
    }

    /**
     * 删除新闻
     * @param id
     * @return
     */
    @PostMapping(value = "/deleteNews")
    @ApiOperation(value="(后台)删除一条新闻")
    public  Integer deleteNews(@RequestParam("id") Integer id){
        return newsService.deleteNews(id);
    }

    /**
     * 分页获取新闻
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping(value="getNewsByType")
    @ApiOperation(value="(接口)根据type和是否发布分页查询新闻，0动态通知 1集团新闻 2媒体报道")
    public Page<News> getNewsByType(@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize,
                                  @RequestParam("type")  Integer type,@RequestParam("isPush") boolean isPush) throws BaseException {
        return  newsService.getNewsByType(pageNo,pageSize,type,isPush);
    }


    /**
     * 获取新闻详情
     * @param id
     * @return
     */
    @GetMapping(value = "getNewsDetail")
    @ApiOperation(value="(接口)根据id查询新闻详情")
    public News getNewsDetail(@RequestParam("id") Integer id){
        return newsService.getNewsDetail(id);
    }
}
