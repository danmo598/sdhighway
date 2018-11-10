package com.highway.service;

import com.highway.model.Car;
import com.highway.util.response.Page;
/**
 * Car service
 *
 * @author fj123
 * @Date 2018-11-10
 */
public interface ICarService {


    Page<Car> getCar(Integer pageNo, Integer pageSize,Integer companyId);

    Integer updateCar(Car car);

    Integer insertCar(Car car);

    Integer deleteCar(Integer id);
}
