package com.highway.service;

import com.highway.model.News;
import com.highway.util.response.Page;

import java.util.List;

/**
 * Creaed by fj on 2018/10/29
 */
public interface INewsService {
     List<News> getAllNews(Integer pageNo, Integer pageSize);

    Integer addNews(News news);

    Integer updateNews(News news);

    Integer deleteNews(Integer id);

    Page<News> getNewsByType(Integer pageNo, Integer pageSize, Integer type,boolean isPush);

    News getNewsDetail(Integer id);
}
