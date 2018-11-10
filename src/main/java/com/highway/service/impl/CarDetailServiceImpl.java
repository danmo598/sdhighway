package com.highway.service.impl;

import com.highway.service.ICarDetailService;
import com.highway.mapper.CarDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.highway.util.response.Page;
import com.github.pagehelper.PageHelper;
import java.util.List;
import com.highway.model.CarDetail;
import tk.mybatis.mapper.entity.Example;

/**
 * CarDetail service 实现类
 *
 * @author fj123
 * @Date 2018-11-10
 */
 @Service
public class CarDetailServiceImpl  implements ICarDetailService{


     @Autowired
     CarDetailMapper carDetailMapper;

    @Override
    public Page<CarDetail> getCarDetail(Integer pageNo, Integer pageSize,Integer typeId) {
        PageHelper.startPage(pageNo,pageSize);
        Example example = new Example(CarDetail.class);
        example.createCriteria().andEqualTo("typeId",typeId);
        List<CarDetail> list = carDetailMapper.selectByExample(example);
        return new Page<>(list);
    }

    @Override
    public Integer updateCarDetail(CarDetail carDetail) {
         return carDetailMapper.updateByPrimaryKey(carDetail);
    }

    @Override
    public Integer insertCarDetail(CarDetail carDetail) {
         return  carDetailMapper.insertSelective(carDetail);
    }

    @Override
    public Integer deleteCarDetail(CarDetail carDetail) {
         return carDetailMapper.deleteByPrimaryKey(carDetail);
    }
}
