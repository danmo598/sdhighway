package com.highway.controller;

import com.highway.model.PartyBuild;
import com.highway.service.PartyBuildService;
import com.highway.validation.RespMessage;
import com.highway.validation.RespStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Liu Chen on 2018/10/29.
 */

@RestController
@RequestMapping(value = "party")
@Slf4j
public class PartyBuildController {

    @Autowired
    private PartyBuildService partyBuildService;

    public RespMessage addPartyBuilActivity(@RequestBody PartyBuild partyBuild) {

        log.info("add new partyBuild activity,title[{}]",partyBuild.getTitle());

        Integer newPartyBuildId = partyBuildService.savePartyBuildActivity(partyBuild);

        if (newPartyBuildId == null)
            return new RespMessage(RespStatus.SAVED_FAILED,RespStatus.SAVED_FAILED_MSG_CN);

        return new RespMessage(RespStatus.SUCCESS,RespStatus.SAVED_SUCCESS_MSG_CN);

    }
    

}
