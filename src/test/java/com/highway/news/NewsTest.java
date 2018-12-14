package com.highway.news;

import com.highway.common.ICommonJunit;
import com.highway.exception.BaseException;
import com.highway.model.Car;
import com.highway.model.CarType;
import com.highway.model.News;
import com.highway.service.ICarService;
import com.highway.service.ICarTypeService;
import com.highway.service.INewsService;
import com.highway.util.response.Page;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * Creaed by fj on 2018/10/29
 */

public class NewsTest  extends ICommonJunit{

    @Autowired
    INewsService newsService;

    @Autowired
    ICarService carService;

    @Autowired
    ICarTypeService carTypeService;

    @Test
    public void addNews() throws Exception {
        News news = new News();
        news.setContent("内容");
        newsService.addNews(news);
    }

    @Test
    public void updateNews(){
        News news = new News();
        news.setContent("test11");
        news.setId(23);
        news.setIsPush(true);
        newsService.updateNews(news);
    }

    @Test
    public void getNews(){
        List<News> newsList = newsService.getAllNews(1,10,"");
        System.out.println(newsList);
        System.out.println(newsList.size());
    }

    @Test
    public void getNewsByType() throws BaseException {
        Page<News> newsPage = newsService.getNewsByType(1,10,0,false);
        System.out.println(newsPage);

    }

    @Test
    public void getFileName(){
        String fileName = "push.jpg";
        String name =fileName.split("\\.")[0];
       // String name = Arrays.toString(ss);
        System.out.println(name);
    }

    @Test
    public  void getCar(){
        //carService.getCar(1,10,1);
        Car car = new Car();
        car.setCompanyId(1);
        car.setName("222");
        car.setId(1);
        car.setName("ww");
      //  carService.insertCar(car);
        carService.updateCar(car);

    }

    @Test
    public  void getCarType(){
        //carService.getCar(1,10,1);
        CarType carType = new CarType();
       ;
        carType.setId(1);
        carType.setName("ww");
        //  carService.insertCar(car);
        carTypeService.updateCarType(carType);

    }

    @Test
    public void getNewsDetail(){
        newsService.getNewsDetail(24);
    }
}
