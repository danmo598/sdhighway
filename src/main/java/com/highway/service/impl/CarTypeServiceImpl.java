package com.highway.service.impl;

import com.highway.service.ICarTypeService;
import com.highway.mapper.CarTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.highway.util.response.Page;
import com.github.pagehelper.PageHelper;
import java.util.List;
import com.highway.model.CarType;
import tk.mybatis.mapper.entity.Example;

/**
 * CarType service 实现类
 *
 * @author fj123
 * @Date 2018-11-10
 */
 @Service
public class CarTypeServiceImpl  implements ICarTypeService{


     @Autowired
     CarTypeMapper carTypeMapper;

    @Override
    public Page<CarType> getCarType(Integer pageNo, Integer pageSize,Integer carId) {
        PageHelper.startPage(pageNo,pageSize);
        Example example = new Example(CarType.class);
        example.createCriteria().andEqualTo("carId",carId);
        List<CarType> list = carTypeMapper.selectByExample(example);
        return new Page<>(list);
    }

    @Override
    public Integer updateCarType(CarType carType,Integer adminId) {
         return carTypeMapper.updateByPrimaryKey(carType);
    }

    @Override
    public Integer insertCarType(CarType carType,Integer adminId) {
         return  carTypeMapper.insertSelective(carType);
    }

    @Override
    public Integer deleteCarType(CarType carType,Integer adminId) {
         return carTypeMapper.deleteByPrimaryKey(carType);
    }
}
