package com.highway.controller;

import com.highway.model.PartyBuild;
import com.highway.service.PartyBuildService;
import com.highway.util.response.Page;
import com.highway.validation.RespMessage;
import com.highway.validation.RespStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Liu Chen on 2018/10/29.
 */

@RestController
@RequestMapping(value = "/party")
@Slf4j
public class PartyBuildController {

    @Autowired
    private PartyBuildService partyBuildService;

    @PostMapping(value = "/addpartybuild")
    public RespMessage addPartyBuild(@RequestBody PartyBuild partyBuild) {

        log.info("add new partyBuild activity,title[{}]",partyBuild.getTitle());

        Integer newPartyBuildId = partyBuildService.savePartyBuild(partyBuild);

        if (newPartyBuildId == null)
            return new RespMessage(RespStatus.SAVED_FAILED,RespStatus.SAVED_FAILED_MSG_CN);

        return new RespMessage(RespStatus.SUCCESS,RespStatus.SAVED_SUCCESS_MSG_CN);

    }

    @GetMapping(value = "/partybuild")
    public PartyBuild viewPartyBuild(@Param("partyBuildId") Integer partyBuildId) {

        log.info("viewPartyBuild by partyBuildId[{}]",partyBuildId);

        return partyBuildService.viewPartyBuild(partyBuildId);

    }

    @PostMapping(value = "/updatePartyBuild")
    public RespMessage updatePartyBuild(@RequestBody PartyBuild partyBuild) {

        log.info("update partyBuild by partyBuildId[{}]",partyBuild.getId());

        Integer updatePartyBuildId = partyBuildService.updatePartyBuild(partyBuild);

        if(updatePartyBuildId == null)
            return new RespMessage(RespStatus.UPDATE_FAILED,RespStatus.UPDATE_FAILED_MSG_CN);

        return new RespMessage(RespStatus.SUCCESS,RespStatus.SAVED_SUCCESS_MSG_CN);

    }

    @GetMapping(value = "/removePartyBuild")
    public RespMessage removePartyBuild(@Param("partyBuildId") Integer partyBuildId) {

        log.info("remove partyBuild by partyBuildId[{}]",partyBuildId);

        Integer removePartyBuildId = partyBuildService.removePartyBuild(partyBuildId);

        if(removePartyBuildId == null )
            return new RespMessage(RespStatus.REMOVE_FAILED,RespStatus.REMOVE_FAILED_MSG_CN);

        return new RespMessage(RespStatus.SUCCESS,RespStatus.SUCCESS_MSG_CN);

    }

    @GetMapping(value = "/partybuildindex")
    public List<PartyBuild> partyBuildInfoIndex() {

        log.info("get partyBuildInfo to partyBuildIndex");

        return partyBuildService.getPartyBuildInfo();

    }

    @GetMapping(value = "/type")
    public Page<PartyBuild> getPartyBuilds(@Param("partyBuildType")Integer partyBuildType,
                                           @Param("pageSize")Integer pageSize,
                                           @Param("pageNumber")Integer pageNumber) {

        log.info("get partyBuilds by partyBuild type[{}] pageSize[{}] pageNumber[{}]",partyBuildType,pageSize,pageNumber);

        return partyBuildService.getPartyBuilds(partyBuildType,pageSize,pageNumber);

    }
    

}
