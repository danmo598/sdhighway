package com.highway.inter;

import com.highway.exception.BaseException;
import com.highway.model.News;
import com.highway.service.INewsService;
import com.highway.util.response.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "新闻相关接口")
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
    @ApiOperation(value="根据type和是否发布分页查询新闻", notes="0动态通知 1集团新闻 2媒体报道")
    public Page<News> getNewsByType(Integer pageNo, Integer pageSize, Integer type,boolean isPush) throws BaseException {
        return  newsService.getNewsByType(pageNo,pageSize,type,isPush);
    }


    /**
     * 获取新闻详情
     * @param id
     * @return
     */
    @GetMapping(value = "getNewsDetail")
    @ApiOperation(value="根据id查询新闻详情")
    public News getNewsDetail(Integer id){
        return newsService.getNewsDetail(id);
    }
}
