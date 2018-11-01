package com.highway.mapper;

import com.highway.model.PartyBuild;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Liu Chen on 2018/10/30.
 */
@Repository
public interface PartyBuildMapper extends CommonMapper<PartyBuild> {
    List<PartyBuild> queryPartyBuilds();
}
