package com.highway.service;

import com.highway.model.CarDetail;
import com.highway.util.response.Page;
/**
 * CarDetail service
 *
 * @author fj123
 * @Date 2018-11-10
 */
public interface ICarDetailService {



    Integer updateCarDetail(CarDetail carDetail,Integer adminId);

    Integer insertCarDetail(CarDetail carDetail,Integer adminId);

    Integer deleteCarDetail(CarDetail carDetail,Integer adminId);

    Page<CarDetail> getCarDetail(Integer pageNo, Integer pageSize, Integer typeId);
}
