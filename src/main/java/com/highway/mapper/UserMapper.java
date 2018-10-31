package com.highway.mapper;

import com.highway.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends CommonMapper<User> {

    User selectByUserName(@Param("userName") String userName);
}