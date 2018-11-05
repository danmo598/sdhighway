package com.highway.controller;

import com.highway.exception.BaseException;
import com.highway.model.User;
import com.highway.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Creaed by fj on 2018/10/31
 */
@RestController
@RequestMapping(value = "users")
@Api("用户相关接口")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    @Autowired
    IUserService userService;

    /**
     * 登录
     * @param user
     */
    @PostMapping(value = "userLogin")
    @ApiOperation(value = "(后台)登录")
    public boolean  login(@RequestBody User user) throws BaseException {
       return userService.login(user);
    }
}
