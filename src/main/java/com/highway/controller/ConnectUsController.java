package com.highway.controller;

import com.highway.model.ConnectUs;
import com.highway.service.IConnectUsService;
import com.highway.util.response.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Creaed by fj on 2018/11/5
 */
@RestController
@RequestMapping(value = "connectUs")
@Api(value = "联系我们相关接口")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ConnectUsController {

    @Autowired
    IConnectUsService connectUsService;

    /**
     * 分页获取联系我们
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping(value="/getConnects")
    @ApiOperation(value="分页获取联系我们")
    public Page<ConnectUs> getConnects(@RequestParam("pageNo") Integer pageNo,
                                    @RequestParam("pageSize") Integer pageSize){
       return  connectUsService.getConnects(pageNo,pageSize);
    }

    /**
     * 添加联系我们
     * @param connectUs
     * @return
     */
    @PostMapping(value = "/addConnects")
    @ApiOperation(value="(后台)添加一条联系我们")
    public Integer addConnects(@RequestBody ConnectUs connectUs) throws Exception {
        return  connectUsService.addConnects(connectUs);
    }

    /**
     * 更新联系我们
     * @param connectUs
     * @return
     */
    @PostMapping(value = "/updateTenders")
    @ApiOperation(value="(后台)更新一条联系我们")
    public Integer updateConnects(@RequestBody ConnectUs connectUs){
        return  connectUsService.updateConnects(connectUs);
    }

    /**
     * 删除联系我们
     * @param id
     * @return
     */
    @PostMapping(value = "/deleteConnects")
    @ApiOperation(value="(后台)删除一条联系我们")
    public  Integer deleteConnects(@RequestParam("id") Integer id){
        return connectUsService.deleteConnects(id);
    }


}
