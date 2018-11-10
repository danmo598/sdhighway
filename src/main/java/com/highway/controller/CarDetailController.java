package com.highway.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.highway.service.ICarDetailService;
import com.highway.model.CarDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.highway.util.response.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 *   @description : CarDetail 控制器
 *   ---------------------------------
 *      @author fj123
 *   @since 2018-11-10
 */

@RestController
@RequestMapping("/carDetail")
@Api(value = "CarDetailController 接口")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CarDetailController {

    private final Logger logger = LoggerFactory.getLogger(CarDetailController.class);

    @Autowired
    public ICarDetailService carDetailService;

    /**
     * @description : 获取分页列表
     * ---------------------------------
     * @author : fj123
     * @since : Create in 2018-11-10
     */
    @GetMapping(value = "/getCarDetailList")
    @ApiOperation(value="分页查询列表")
    public Page<CarDetail> getCarDetailList(@RequestParam("pageNo")Integer pageNo
                                    ,@RequestParam("pageSize")Integer pageSize,
                                    @RequestParam(value = "type_id",required = false)Integer typeId) {
           return carDetailService.getCarDetail(pageNo,pageSize,typeId);
    }

    /**
     * @description : 新增 CarDetail
     * ---------------------------------
     * @author : fj123
     * @since : Create in 2018-11-10
     */
    @PostMapping(value = "/insertCarDetail")
     @ApiOperation(value="新增")
    public Integer insertCarDetail(@RequestBody CarDetail carDetail,Integer adminId) {
           return carDetailService.insertCarDetail(carDetail,adminId);
    }

    /**
     * @description : 删除CarDetail
     * ---------------------------------
     * @author : fj123
     * @since : Create in 2018-11-10
     */
    @PostMapping(value = "/deleteCarDetail")
     @ApiOperation(value="删除")
    public Integer deleteCarDetail(@RequestBody CarDetail carDetail,Integer adminId) {
            return carDetailService.deleteCarDetail(carDetail,adminId);
    }

    /**
     * @description : 通过id更新CarDetail
     * ---------------------------------
     * @author : fj123
     * @since : Create in 2018-11-10
     */
    @PostMapping(value = "/updateCarDetail")
     @ApiOperation(value="修改")
    public Integer updateCarDetail(@RequestBody CarDetail carDetail,Integer adminId) {
            return carDetailService.updateCarDetail(carDetail,adminId);
    }


}