package com.highway.service.impl;

import com.highway.mapper.PartyBuildMapper;
import com.highway.model.PartyBuild;
import com.highway.service.PartyBuildService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Liu Chen on 2018/10/30.
 */
@Service
@Slf4j
public class PartyBuildServiceImpl implements PartyBuildService {

    @Autowired
    private PartyBuildMapper partyBuildMapper;

    @Override
    public Integer savePartyBuildActivity(PartyBuild partyBuild) {

        log.info("partyBuildService add new partyBuild activity,title[{}]",partyBuild.getTitle());

        return partyBuildMapper.insertSelective(partyBuild);
    }


}
