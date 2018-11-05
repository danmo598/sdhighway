package com.highway.service.impl;

import com.github.pagehelper.PageHelper;
import com.highway.mapper.CityMapper;
import com.highway.mapper.ProvincialMapper;
import com.highway.mapper.TendersMapper;
import com.highway.model.City;
import com.highway.model.Provincial;
import com.highway.model.Tenders;
import com.highway.service.ITendersService;
import com.highway.util.response.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Creaed by fj on 2018/11/5
 */
@Service
public class TendersServiceImpl implements ITendersService {

    @Autowired
    TendersMapper tendersMapper;

    @Autowired
    ProvincialMapper provincialMapper;

    @Autowired
    CityMapper cityMapper;

    @Override
    public Page<Tenders> getTenders(Integer pageNo, Integer pageSize, Integer cityId) {
        PageHelper.startPage(pageNo,pageSize,"publish_date desc");
        Example example = new Example(Tenders.class);
        example.createCriteria().andEqualTo("cityId",cityId);
        List<Tenders> tendersList = tendersMapper.selectByExample(example);
        return new Page<>(tendersList);
    }

    @Override
    public Integer addTenders(Tenders tenders) {
        return tendersMapper.insertSelective(tenders);
    }

    @Override
    public Integer updateTenders(Tenders tenders) {
        return tendersMapper.updateByPrimaryKey(tenders);
    }

    @Override
    public Integer deleteTenders(Integer id) {
        return tendersMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Provincial>  selectAllPro() {
        return provincialMapper.selectAll();
    }

    @Override
    public List<City> selectCityByPro(Integer pid) {
        Example example = new Example(City.class);
        example.createCriteria().andEqualTo("pid",pid);
        return cityMapper.selectByExample(example);
    }
}
