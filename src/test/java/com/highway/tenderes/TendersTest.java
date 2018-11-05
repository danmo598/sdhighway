package com.highway.tenderes;

import com.highway.common.ICommonJunit;
import com.highway.model.City;
import com.highway.service.IConnectUsService;
import com.highway.service.ITendersService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Creaed by fj on 2018/11/5
 */
public class TendersTest extends ICommonJunit {

    @Autowired
    ITendersService tendersService;

    @Autowired
    IConnectUsService connectUsService;

    @Test
    public void selectTenders(){
      // tendersService.getTenders(1,10,2);
       //List<City> cityList = tendersService.selectCityByPro(16);
        connectUsService.getConnects(1,10);
        //System.out.println(cityList.size());
    }
}
