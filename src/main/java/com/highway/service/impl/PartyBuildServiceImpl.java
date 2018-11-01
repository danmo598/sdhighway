package com.highway.service.impl;

import com.highway.mapper.PartyBuildMapper;
import com.highway.model.PartyBuild;
import com.highway.service.PartyBuildService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liu Chen on 2018/10/30.
 */
@Service
@Slf4j
public class PartyBuildServiceImpl implements PartyBuildService {

    @Autowired
    private PartyBuildMapper partyBuildMapper;

    @Override
    public Integer savePartyBuild(PartyBuild partyBuild) {

        log.info("partyBuildService add new partyBuild activity,title[{}]",partyBuild.getTitle());

        return partyBuildMapper.insertSelective(partyBuild);
    }

    @Override
    public Integer updatePartyBuild(PartyBuild partyBuild) {

        log.info("partyBuildService update partyBuild by partyBuildId [{}]",partyBuild.getId());

        return partyBuildMapper.updateByPrimaryKey(partyBuild);

    }

    @Override
    public Integer removePartyBuild(Integer partyBuildId) {

        log.info("partyBuildService remove partyBuild by partyBuildId[{}]",partyBuildId);

        PartyBuild partyBuild = partyBuildMapper.selectByPrimaryKey(partyBuildId);
        partyBuild.setEnabled(false);

        return partyBuildMapper.updateByPrimaryKey(partyBuild);

    }

    @Override
    public PartyBuild viewPartyBuild(Integer partyBuildId) {

        log.info("partyBuildService get partyBuild by partyBuildId[{}]",partyBuildId);

        PartyBuild partyBuild = partyBuildMapper.selectOne(new PartyBuild().id(partyBuildId).enabled(true));
        partyBuild.setViewTimes(partyBuild.getViewTimes() + 1);

        partyBuildMapper.updateByPrimaryKey(partyBuild);

        log.info("partyBuildService view partyBuild,partyBuild title[{}] viewTimes[{}]",
                partyBuild.getTitle(),partyBuild.getViewTimes());

        return partyBuild;
    }

    @Override
    public List<PartyBuild> getPartyBuildInfo() {

        log.info("partyBuildService get partyBuildInfo");

        return partyBuildMapper.queryPartyBuilds();

    }


}
