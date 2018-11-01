package com.highway.service;

import com.highway.model.PartyBuild;

import java.util.List;

/**
 * Created by Liu Chen on 2018/10/30.
 */
public interface PartyBuildService {

    Integer savePartyBuild(PartyBuild partyBuild);

    Integer updatePartyBuild(PartyBuild partyBuild);

    Integer removePartyBuild(Integer partyBuildId);

    PartyBuild viewPartyBuild(Integer partyBuildId);

    List<PartyBuild> getPartyBuildInfo();

}
