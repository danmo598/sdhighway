package com.highway.controller;

import com.github.pagehelper.PageInfo;
import com.highway.model.City;
import com.highway.model.News;
import com.highway.model.Provincial;
import com.highway.model.Tenders;
import com.highway.service.ITendersService;
import com.highway.util.response.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Creaed by fj on 2018/11/5
 */
@RestController
@RequestMapping(value = "tenders")
@Api(value = "招标相关接口")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TendersController {

    @Autowired
    ITendersService tendersService;

    /**
     * 分页获取招标信息
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping(value="/getTenders")
    @ApiOperation(value="分页获取招标信息")
    public Page<Tenders> getTenders(@RequestParam("pageNo") Integer pageNo,
                                    @RequestParam("pageSize") Integer pageSize,
                                    @RequestParam("cityId")Integer cityId){
       return  tendersService.getTenders(pageNo,pageSize,cityId);
    }

    /**
     * 添加招标信息
     * @param tenders
     * @return
     */
    @PostMapping(value = "/addTenders")
    @ApiOperation(value="(后台)添加一条招标信息")
    public Integer addTenders(@RequestBody Tenders tenders) throws Exception {
        return  tendersService.addTenders(tenders);
    }

    /**
     * 更新招标信息
     * @param tenders
     * @return
     */
    @PostMapping(value = "/updateTenders")
    @ApiOperation(value="(后台)更新一条招标信息")
    public Integer updateTenders(@RequestBody Tenders tenders){
        return  tendersService.updateTenders(tenders);
    }

    /**
     * 删除招标信息
     * @param id
     * @return
     */
    @PostMapping(value = "/deleteTenders")
    @ApiOperation(value="(后台)删除一条招标信息")
    public  Integer deleteTenders(@RequestParam("id") Integer id){
        return tendersService.deleteTenders(id);
    }

    /**
     * 获取所有省份
     * @return
     */
    @GetMapping(value="/selectAllPro")
    @ApiOperation(value="获取所有省份")
    public List<Provincial> selectAllPro(){
        return tendersService.selectAllPro();
    }

    /**
     * 用省份获取城市
     * @return
     */
    @GetMapping(value="/selectCityByPro")
    @ApiOperation(value="用省份获取城市")
    public List<City> selectCityByPro(@Param("pid") Integer pid){
        return tendersService.selectCityByPro(pid);
    }

}
