package com.highway.service.impl;

import com.github.pagehelper.PageHelper;
import com.highway.exception.BaseException;
import com.highway.mapper.PartyBuildMapper;
import com.highway.model.News;
import com.highway.model.PartyBuild;
import com.highway.service.PartyBuildService;
import com.highway.util.enums.StatEnum;
import com.highway.util.response.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

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

    @Override
    public Page<PartyBuild> getPartyBuilds(Integer partyBuildType, Integer pageSize, Integer pageNumber) {

        log.info("partyBuildService query partyBuilds by type[{}] pageSize[{}] pageNumber[{}]",partyBuildType,
                pageSize,pageNumber);

        PageHelper.startPage(pageNumber,pageSize,"id desc");
        Example example = new Example(PartyBuild.class);
        example.createCriteria().andEqualTo("partyBuildType",partyBuildType)
                .andEqualTo("enabled",true);
        List<PartyBuild> partyBuilds = partyBuildMapper.selectByExample(example);

        log.info("partyBuildService get partyBuilds [{}]",partyBuilds.size());

        if(CollectionUtils.isEmpty(partyBuilds)){
            return new Page<PartyBuild>(new ArrayList<PartyBuild>());
        }

        return new Page<>(partyBuilds);
    }


}
