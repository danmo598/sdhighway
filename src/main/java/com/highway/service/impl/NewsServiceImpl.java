package com.highway.service.impl;

import com.github.pagehelper.PageHelper;
import com.highway.exception.BaseException;
import com.highway.mapper.NewsMapper;
import com.highway.model.News;
import com.highway.service.INewsService;
import com.highway.util.enums.StatEnum;
import com.highway.util.response.Page;
import com.highway.util.upload.UploadUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Creaed by fj on 2018/10/29
 */
@Service
public class NewsServiceImpl implements INewsService {

    @Resource
    NewsMapper newsMapper;


    @Autowired
    UploadUtil uploadUtil;


    @Override
    public List<News> getAllNews(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize,"date desc");
        return newsMapper.selectAll();
    }

    @Override
    public Integer addNews(News news) {
        return newsMapper.insertSelective(news);
    }

    @Override
    public String uploadFiles(MultipartFile url, HttpServletRequest request) throws Exception {
        return uploadUtil.handleImg(url,request);
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
    public Page<News> getNewsByType(Integer pageNo, Integer pageSize, Integer type,boolean isPush) throws BaseException {
       PageHelper.startPage(pageNo,pageSize,"date desc");
       Example example = new Example(News.class);
       example.createCriteria().andEqualTo("type",type).andEqualTo("isPush",isPush);
       List<News> newsList = newsMapper.selectByExample(example);
       if(CollectionUtils.isEmpty(newsList)){
           throw new BaseException(StatEnum.STAT_NO_DATA);
       }
       return new Page<>(newsList);
    }

    @Override
    public News getNewsDetail(Integer id) {
        return newsMapper.selectByPrimaryKey(id);
    }
}
