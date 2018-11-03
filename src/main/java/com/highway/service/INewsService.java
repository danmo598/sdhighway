package com.highway.service;

import com.highway.exception.BaseException;
import com.highway.model.News;
import com.highway.util.response.Page;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Creaed by fj on 2018/10/29
 */
public interface INewsService {
     List<News> getAllNews(Integer pageNo, Integer pageSize);


    Integer updateNews(News news);

    Integer deleteNews(Integer id);

    Page<News> getNewsByType(Integer pageNo, Integer pageSize, Integer type,boolean isPush) throws BaseException;

    News getNewsDetail(Integer id);

    Integer addNews(News news, MultipartFile url, HttpServletRequest request) throws Exception;
}
