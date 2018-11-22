package com.highway.service.impl;

import com.github.pagehelper.PageHelper;
import com.highway.exception.BaseException;
import com.highway.mapper.UserMapper;
import com.highway.model.Car;
import com.highway.model.User;
import com.highway.service.IUserService;
import com.highway.util.MD5Util;
import com.highway.util.enums.StatEnum;
import com.highway.util.response.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Creaed by fj on 2018/10/31
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean login(User user) throws BaseException {
        User userDb = userMapper.selectByUserName(user.getUserName());
        if(userDb==null){
            throw new BaseException(StatEnum.USER_NOT_EXIST);
        }
        String password = MD5Util.MD5Encode(user.getPassword(), "utf-8");
        if(!password.equals(userDb.getPassword())){
            throw new BaseException(StatEnum.PASSWORD_ERROR);
        }
        return true;
    }

    @Override
    public Integer updateUser(User user) {
        String password = MD5Util.MD5Encode(user.getPassword(), "utf-8");
        user.setPassword(password);
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public Integer addUser(User user) {
        String password = MD5Util.MD5Encode(user.getPassword(), "utf-8");
        user.setPassword(password);
        return userMapper.insertSelective(user);
    }

    @Override
    public Page<User> getUserList(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<User> userList = userMapper.selectAll();
        return new Page<>(userList);
    }
}
