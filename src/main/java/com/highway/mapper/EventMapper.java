package com.highway.mapper;

import com.highway.model.Event;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EventMapper extends CommonMapper<Event> {
    List<Event> getAllEvents(@Param("year") String year);
}