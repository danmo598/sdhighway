package com.highway.service.impl;

import com.highway.service.ICarService;
import com.highway.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.highway.util.response.Page;
import com.github.pagehelper.PageHelper;
import java.util.List;
import com.highway.model.Car;
import tk.mybatis.mapper.entity.Example;

/**
 * Car service 实现类
 *
 * @author fj123
 * @Date 2018-11-10
 */
 @Service
public class CarServiceImpl  implements ICarService{


     @Autowired
     CarMapper carMapper;

    @Override
    public Page<Car> getCar(Integer pageNo, Integer pageSize,Integer companyId) {
        PageHelper.startPage(pageNo,pageSize);
        Example example = new Example(Car.class);
        example.createCriteria().andEqualTo("companyId",companyId);
        List<Car> list = carMapper.selectByExample(example);
        return new Page<>(list);
    }

    @Override
    public Integer updateCar(Car car,Integer adminId) {
         return carMapper.updateByPrimaryKey(car);
    }

    @Override
    public Integer insertCar(Car car,Integer adminId) {
         return  carMapper.insertSelective(car);
    }

    @Override
    public Integer deleteCar(Car car,Integer adminId) {
         return carMapper.deleteByPrimaryKey(car);
    }
}
