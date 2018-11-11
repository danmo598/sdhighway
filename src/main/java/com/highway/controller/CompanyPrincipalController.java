package com.highway.controller;

import com.highway.model.CompanyPrincipal;
import com.highway.service.CompanyPrincipalService;
import com.highway.validation.RespMessage;
import com.highway.validation.RespStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Liu Chen on 2018/11/11.
 */
@RestController
@RequestMapping(value = "/principal")
@Slf4j
@Api(value = "业务领域")
public class CompanyPrincipalController {

    @Autowired
    private CompanyPrincipalService companyPrincipalService;

    @PostMapping(value = "/add")
    @ApiOperation(value="(后台)添加公司负责人")
    public RespMessage addCompanyPrincipal(@RequestBody CompanyPrincipal companyPrincipal) {

        Integer addCompanyPrincipalId = companyPrincipalService.addCompanyPrincipal(companyPrincipal);

        if(addCompanyPrincipalId == null)
            return new RespMessage(RespStatus.SAVED_FAILED,RespStatus.SAVED_FAILED_MSG_CN);

        log.info("save companyPrincipal success");

        return new RespMessage(RespStatus.SUCCESS,RespStatus.SUCCESS_MSG_CN);

    }

    @GetMapping(value = "/remove")
    @ApiOperation(value="(后台)删除公司负责人")
    public RespMessage removeCompanyPrincipal(@Param("id")Integer id) {

        Integer removeId = companyPrincipalService.removeCompanyPrincipal(id);

        if(removeId == null)
            return new RespMessage(RespStatus.REMOVE_FAILED,RespStatus.REMOVE_FAILED_MSG_CN);

        log.info("remove companyPrincipal success");

        return new RespMessage(RespStatus.SUCCESS,RespStatus.SUCCESS_MSG_CN);

    }

    @PostMapping(value = "/update")
    @ApiOperation(value="(后台)更新公司负责人信息")
    public RespMessage updateCompanyPrincipal(@RequestBody CompanyPrincipal companyPrincipal) {

        Integer updateId = companyPrincipalService.updateCompanyPrincipal(companyPrincipal);

        if(updateId == null)
            return new RespMessage(RespStatus.UPDATE_FAILED,RespStatus.UPDATE_FAILED_MSG_CN);

        log.info("update companyPrincipal success");

        return new RespMessage(RespStatus.SUCCESS,RespStatus.SUCCESS_MSG_CN);

    }

    @GetMapping(value = "/companyprincipal")
    @ApiOperation(value="根据id获取公司负责人信息")
    public CompanyPrincipal getCompanyPrincipal(@Param("id")Integer id) {
        return companyPrincipalService.getCompanyPrincipal(id);
    }

}
