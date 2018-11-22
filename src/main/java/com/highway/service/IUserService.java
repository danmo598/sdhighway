package com.highway.service;

import com.highway.exception.BaseException;
import com.highway.model.Car;
import com.highway.model.User;
import com.highway.util.response.Page;

/**
 * Creaed by fj on 2018/10/31
 */
public interface IUserService {
    boolean login(User user) throws BaseException;

    Integer updateUser(User user);

    Integer addUser(User user);

    Page<User> getUserList(Integer pageNo, Integer pageSize);
}
