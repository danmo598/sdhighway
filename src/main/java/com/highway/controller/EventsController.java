package com.highway.controller;

import com.highway.model.Event;
import com.highway.service.IEventsService;
import com.highway.util.response.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


/**
 * Creaed by fj on 2018/11/5
 */
@RestController
@RequestMapping(value = "events")
@Api(value = "大事件相关接口")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EventsController {

    @Autowired
    IEventsService eventsService;

    /**
     * 分页获取大事件
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping(value="/getEvents")
    @ApiOperation(value="分页获取大事件")
    public Page<Event> getEvents(@RequestParam("pageNo") Integer pageNo,
                                 @RequestParam("pageSize") Integer pageSize,
                                 @RequestParam(value = "year",required = false) String year){
       return  eventsService.getEvents(pageNo,pageSize,year);
    }

    /**
     * 添加大事件
     * @param events
     * @return
     */
    @PostMapping(value = "/addEvents")
    @ApiOperation(value="(后台)添加一条大事件")
    public Integer addConnects(@RequestBody Event events) throws Exception {
        return  eventsService.addEvents(events);
    }

    /**
     * 更新大事件
     * @param events
     * @return
     */
    @PostMapping(value = "/updateTenders")
    @ApiOperation(value="(后台)更新一条大事件")
    public Integer updateEvents(@RequestBody Event events){
        return  eventsService.updateEvents(events);
    }

    /**
     * 删除大事件
     * @param id
     * @return
     */
    @PostMapping(value = "/deleteEvents")
    @ApiOperation(value="(后台)删除一条大事件")
    public  Integer deleteEvents(@RequestParam("id") Integer id){
        return eventsService.deleteEvents(id);
    }


}
