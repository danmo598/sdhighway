package com.highway.service.impl;

import com.github.pagehelper.PageHelper;
import com.highway.mapper.NewsMapper;
import com.highway.model.News;
import com.highway.service.INewsService;
import com.highway.util.response.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Creaed by fj on 2018/10/29
 */
@Service
public class NewsServiceImpl implements INewsService {

    @Autowired
    NewsMapper newsMapper;

    @Override
    public List<News> getAllNews(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        return newsMapper.selectAll();
    }

    @Override
    public Integer addNews(News news) {
        return newsMapper.insertSelective(news);
    }

    @Override
    public Integer updateNews(News news) {
        return newsMapper.updateByPrimaryKey(news);
    }

    @Override
    public Integer deleteNews(Integer id) {
        return newsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Page<News> getNewsByType(Integer pageNo, Integer pageSize, Integer type,boolean isPush) {
       PageHelper.startPage(pageNo,pageSize,"date desc");
       Example example = new Example(News.class);
       example.createCriteria().andEqualTo("type",type).andEqualTo("isPush",isPush);
       List<News> newsList = newsMapper.selectByExample(example);
       return new Page<>(newsList);
    }

    @Override
    public News getNewsDetail(Integer id) {
        return newsMapper.selectByPrimaryKey(id);
    }
}
