package com.highway.service;

import com.highway.model.CarDetail;
import com.highway.util.response.Page;
import io.swagger.models.auth.In;

/**
 * CarDetail service
 *
 * @author fj123
 * @Date 2018-11-10
 */
public interface ICarDetailService {



    Integer updateCarDetail(CarDetail carDetail);

    Integer insertCarDetail(CarDetail carDetail);

    Integer deleteCarDetail(Integer id);

    Page<CarDetail> getCarDetail(Integer pageNo, Integer pageSize, Integer typeId);
}
