package com.highway.service;

import com.highway.model.CarType;
import com.highway.util.response.Page;
import io.swagger.models.auth.In;

/**
 * CarType service
 *
 * @author fj123
 * @Date 2018-11-10
 */
public interface ICarTypeService {


    Page<CarType> getCarType(Integer pageNo, Integer pageSize, Integer carId);

    Integer updateCarType(CarType carType,Integer adminId);

    Integer insertCarType(CarType carType,Integer adminId);

    Integer deleteCarType(CarType carType,Integer adminId);
}
