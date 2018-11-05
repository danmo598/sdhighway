package com.highway.service;

import com.highway.model.City;
import com.highway.model.Provincial;
import com.highway.model.Tenders;
import com.highway.util.response.Page;

import java.util.List;


/**
 * Creaed by fj on 2018/11/5
 */
public interface ITendersService {
    Page<Tenders> getTenders(Integer pageNo, Integer pageSize, Integer cityId);

    Integer addTenders(Tenders tenders);

    Integer updateTenders(Tenders tenders);

    Integer deleteTenders(Integer id);

    List<Provincial> selectAllPro();

    List<City> selectCityByPro(Integer pid);
}
