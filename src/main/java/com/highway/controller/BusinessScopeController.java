package com.highway.controller;

import com.highway.dto.ResponseDTO;
import com.highway.exception.BaseException;
import com.highway.model.BusinessScope;
import com.highway.service.BusinessScopeService;
import com.highway.validation.RespMessage;
import com.highway.validation.RespStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Liu Chen on 2018/11/8.
 */
@RestController
@RequestMapping(value = "/business")
@Slf4j
@Api(value = "业务领域")
@CrossOrigin
public class BusinessScopeController {

    @Autowired
    private BusinessScopeService businessScopeService;

    @PostMapping(value = "/add")
    @ApiOperation(value="(后台)添加业务领域")
    public RespMessage addBusinessScope(@RequestBody BusinessScope businessScope) {

        log.info("add businessScope info,companyName[{}] companyAbstract",
                businessScope.getCompanyName(),businessScope.getCompanyAbstract());

        Integer saveBusinessScopeId = businessScopeService.addBusinessScope(businessScope);

        if(saveBusinessScopeId == null)
            return new RespMessage(RespStatus.SAVED_FAILED,RespStatus.SAVED_FAILED_MSG_CN);

        log.info("save businessScope success");

        return new RespMessage(RespStatus.SUCCESS,RespStatus.SUCCESS_MSG_CN);

    }

    @GetMapping(value = "/remove")
    @ApiOperation(value="(后台)删除业务领域")
    public RespMessage removeBusinessScope(@Param("businessScopeId") Integer businessScopeId) {

        log.info("remove businessScope by businessScopeId[{}]",businessScopeId);

        Integer removeBusinessScopeId = businessScopeService.removeBusinessScope(businessScopeId);

        if(removeBusinessScopeId == null)
            return new RespMessage(RespStatus.REMOVE_FAILED,RespStatus.REMOVE_FAILED_MSG_CN);

        log.info("remove businessScope[{}] success",businessScopeId);

        return new RespMessage(RespStatus.SUCCESS,RespStatus.SUCCESS_MSG_CN);

    }

    @PostMapping(value = "/update")
    @ApiOperation(value="(后台)更新业务领域")
    public RespMessage updateBusinessScope(@RequestBody BusinessScope businessScope) {

        log.info("update businessScope companyName[{}]",businessScope.getCompanyName());

        Integer updateBusinessScopeId = businessScopeService.updateBusinessScope(businessScope);

        if(updateBusinessScopeId == null)
            return new RespMessage(RespStatus.UPDATE_FAILED,RespStatus.UPDATE_FAILED_MSG_CN);

        log.info("update businessScope[{}] success",updateBusinessScopeId);

        return new RespMessage(RespStatus.SUCCESS,RespStatus.SUCCESS_MSG_CN);

    }

    @GetMapping(value = "/businessscope")
    @ApiOperation(value="根据id获取业务领域详情")
    public BusinessScope getBusinessScope(@Param("businessScopeId") Integer businessScopeId) {

        log.info("get businessScope detail by businessScopeId[{}]",businessScopeId);

        return businessScopeService.getBusinessScope(businessScopeId);

    }

    @GetMapping(value = "/businessscopes")
    @ApiOperation(value="分页查询业务领域")
    public ResponseDTO getBusinessScopes(@Param("companyType")Integer companyType,
                                         @Param("pageSize")Integer pageSize,
                                         @Param("pageNumber")Integer pageNumber) throws BaseException {

        log.info("get partyBuilds by partyBuild type[{}] pageSize[{}] pageNumber[{}]",companyType,pageSize,pageNumber);

        return new ResponseDTO(businessScopeService.getBusinessScopes(companyType,pageSize,pageNumber),pageSize,pageNumber);

    }

    @GetMapping(value = "/companyname")
    @ApiOperation(value="根据公司名称模糊查询业务领域")
    public List<BusinessScope> getBusinessScopesByCompanyName(@Param("companyName") String companyName) {

        log.info("get businessScopes by companyName[{}]",companyName);

        return businessScopeService.getBusinessScopesByCompanyName(companyName);

    }


}
