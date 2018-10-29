package com.highway.inter;

import com.highway.exception.BaseException;
import com.highway.model.News;
import com.highway.service.INewsService;
import com.highway.util.response.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 新闻相关接口
 * Creaed by fj on 2018/10/29
 */
@RequestMapping(value = "newsInter")
@RestController
public class NewsInter {

    @Autowired
    INewsService newsService;

    /**
     * 分页获取新闻
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping(value="getNewsByType")
    public Page<News> getNewsByType(Integer pageNo, Integer pageSize, Integer type,boolean isPush) throws BaseException {
        return  newsService.getNewsByType(pageNo,pageSize,type,isPush);
    }


    /**
     * 获取新闻详情
     * @param id
     * @return
     */
    @GetMapping(value = "getNewsDetail")
    public News getNewsDetail(Integer id){
        return newsService.getNewsDetail(id);
    }
}
