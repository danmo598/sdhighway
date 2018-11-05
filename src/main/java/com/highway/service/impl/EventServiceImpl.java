package com.highway.service.impl;

import com.github.pagehelper.PageHelper;
import com.highway.mapper.EventMapper;
import com.highway.model.Event;
import com.highway.service.IEventsService;
import com.highway.util.response.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * Creaed by fj on 2018/11/5
 */
@Service
public class EventServiceImpl implements IEventsService {

    @Autowired
    EventMapper eventMapper;

    @Override
    public Page<Event> getEvents(Integer pageNo, Integer pageSize, Date year) {
        PageHelper.startPage(pageNo,pageSize);
        Example example = new Example(Event.class);
        List<Event> eventList = eventMapper.selectByExample(example);
        return new Page<>(eventList);
    }

    @Override
    public Integer addEvents(Event events) {
        return eventMapper.insertSelective(events);
    }

    @Override
    public Integer updateEvents(Event events) {
        return eventMapper.updateByPrimaryKey(events);
    }

    @Override
    public Integer deleteEvents(Integer id) {
        return eventMapper.deleteByPrimaryKey(id);
    }
}
