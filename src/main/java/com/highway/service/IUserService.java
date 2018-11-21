package com.highway.service;

import com.highway.exception.BaseException;
import com.highway.model.User; /**
 * Creaed by fj on 2018/10/31
 */
public interface IUserService {
    boolean login(User user) throws BaseException;

    Integer updateUser(User user);

    Integer addUser(User user);
}
