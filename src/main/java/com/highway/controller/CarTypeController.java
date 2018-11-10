package com.highway.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.highway.service.ICarTypeService;
import com.highway.model.CarType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.highway.util.response.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 *   @description : CarType 控制器
 *   ---------------------------------
 *      @author fj123
 *   @since 2018-11-10
 */

@RestController
@RequestMapping("/carType")
@Api(value = "CarTypeController 接口")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CarTypeController {

    private final Logger logger = LoggerFactory.getLogger(CarTypeController.class);

    @Autowired
    public ICarTypeService carTypeService;

    /**
     * @description : 获取分页列表
     * ---------------------------------
     * @author : fj123
     * @since : Create in 2018-11-10
     */
    @GetMapping(value = "/getCarTypeList")
    @ApiOperation(value="分页查询列表")
    public Page<CarType> getCarTypeList(@RequestParam("pageNo")Integer pageNo
                                    ,@RequestParam("pageSize")Integer pageSize,
                                        @RequestParam(value = "carId",required = false) Integer carId) {
           return carTypeService.getCarType(pageNo,pageSize,carId);
    }

    /**
     * @description : 新增 CarType
     * ---------------------------------
     * @author : fj123
     * @since : Create in 2018-11-10
     */
    @PostMapping(value = "/insertCarType")
     @ApiOperation(value="新增")
    public Integer insertCarType(@RequestBody CarType carType,Integer adminId) {
           return carTypeService.insertCarType(carType,adminId);
    }

    /**
     * @description : 删除CarType
     * ---------------------------------
     * @author : fj123
     * @since : Create in 2018-11-10
     */
    @PostMapping(value = "/deleteCarType")
     @ApiOperation(value="删除")
    public Integer deleteCarType(@RequestBody CarType carType,Integer adminId) {
            return carTypeService.deleteCarType(carType,adminId);
    }

    /**
     * @description : 通过id更新CarType
     * ---------------------------------
     * @author : fj123
     * @since : Create in 2018-11-10
     */
    @PostMapping(value = "/updateCarType")
     @ApiOperation(value="修改")
    public Integer updateCarType(@RequestBody CarType carType,Integer adminId) {
            return carTypeService.updateCarType(carType,adminId);
    }


}