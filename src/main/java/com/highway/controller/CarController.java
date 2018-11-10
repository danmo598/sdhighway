package com.highway.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.highway.service.ICarService;
import com.highway.model.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.highway.util.response.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 *   @description : Car 控制器
 *   ---------------------------------
 *      @author fj123
 *   @since 2018-11-10
 */

@RestController
@RequestMapping("/car")
@Api(value = "CarController 接口")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CarController {

    private final Logger logger = LoggerFactory.getLogger(CarController.class);

    @Autowired
    public ICarService carService;

    /**
     * @description : 获取分页列表
     * ---------------------------------
     * @author : fj123
     * @since : Create in 2018-11-10
     */
    @GetMapping(value = "/getCarList")
    @ApiOperation(value="分页查询列表")
    public Page<Car> getCarList(@RequestParam("pageNo")Integer pageNo
                                ,@RequestParam("pageSize")Integer pageSize,
                                @RequestParam(value = "companyId",required = false) Integer companyId) {
           return carService.getCar(pageNo,pageSize,companyId);
    }

    /**
     * @description : 新增 Car
     * ---------------------------------
     * @author : fj123
     * @since : Create in 2018-11-10
     */
    @PostMapping(value = "/insertCar")
     @ApiOperation(value="新增")
    public Integer insertCar(@RequestBody Car car,Integer adminId) {
           return carService.insertCar(car,adminId);
    }

    /**
     * @description : 删除Car
     * ---------------------------------
     * @author : fj123
     * @since : Create in 2018-11-10
     */
    @PostMapping(value = "/deleteCar")
     @ApiOperation(value="删除")
    public Integer deleteCar(@RequestBody Car car,Integer adminId) {
            return carService.deleteCar(car,adminId);
    }

    /**
     * @description : 通过id更新Car
     * ---------------------------------
     * @author : fj123
     * @since : Create in 2018-11-10
     */
    @PostMapping(value = "/updateCar")
     @ApiOperation(value="修改")
    public Integer updateCar(@RequestBody Car car,Integer adminId) {
            return carService.updateCar(car,adminId);
    }


}