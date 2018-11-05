package com.highway.service;

import com.highway.model.ConnectUs;
import com.highway.model.Event;
import com.highway.util.response.Page;

import java.util.Date; /**
 * Creaed by fj on 2018/11/5
 */
public interface IEventsService {
    Page<Event> getEvents(Integer pageNo, Integer pageSize, Date year);

    Integer addEvents(Event events);

    Integer updateEvents(Event events);

    Integer deleteEvents(Integer id);
}
