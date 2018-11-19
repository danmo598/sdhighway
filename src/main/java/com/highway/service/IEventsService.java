package com.highway.service;

import com.highway.model.ConnectUs;
import com.highway.model.Event;
import com.highway.util.response.Page;

import java.util.Date;
import java.util.List;

/**
 * Creaed by fj on 2018/11/5
 */
public interface IEventsService {
    Page<Event> getEvents(Integer pageNo, Integer pageSize, String year,boolean simple);

    Integer addEvents(Event events);

    Integer updateEvents(Event events);

    Integer deleteEvents(Integer id);

    List<Event> getAllEvents(String year);
}
