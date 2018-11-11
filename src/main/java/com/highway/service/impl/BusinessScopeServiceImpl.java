package com.highway.service.impl;

import com.github.pagehelper.PageHelper;
import com.highway.exception.BaseException;
import com.highway.mapper.BusinessScopeMapper;
import com.highway.mapper.CompanyPrincipalMapper;
import com.highway.model.BusinessScope;
import com.highway.model.CompanyPrincipal;
import com.highway.model.PartyBuild;
import com.highway.service.BusinessScopeService;
import com.highway.util.enums.StatEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by Liu Chen on 2018/11/8.
 */
@Service
@Slf4j
public class BusinessScopeServiceImpl implements BusinessScopeService {


    @Autowired
    private BusinessScopeMapper businessScopeMapper;

    @Autowired
    private CompanyPrincipalMapper companyPrincipalMapper;

    @Override
    public Integer addBusinessScope(BusinessScope businessScope) {

        log.info("BusinessScopeService add businessScope,companyName[{}]",businessScope.getCompanyName());

        return businessScopeMapper.insertSelective(businessScope);

    }

    @Override
    public Integer removeBusinessScope(Integer businessScopeId) {

        log.info("BusinessScopeService remove businessScope by businessScopeId[{}]",businessScopeId);

        BusinessScope businessScope = businessScopeMapper.selectByPrimaryKey(businessScopeId);
        businessScope.setEnabled(false);

        return businessScopeMapper.updateByPrimaryKey(businessScope);

    }

    @Override
    public Integer updateBusinessScope(BusinessScope businessScope) {

        log.info("BusinessScopeService update businessScope by businessScopeId[{}] companyName[{}]",
                businessScope.getId(),businessScope.getCompanyName());

        return businessScopeMapper.updateByPrimaryKey(businessScope);

    }

    @Override
    public BusinessScope getBusinessScope(Integer businessScopeId) {

        log.info("BusinessScopeService get businessScope by businessScopeId[{}]",businessScopeId);

        return businessScopeMapper.getBusinessScopeById(businessScopeId);
    }

    @Override
    public List<BusinessScope> getBusinessScopes(Integer companyType, Integer pageSize, Integer pageNumber) throws BaseException {

        log.info("BusinessScopeService get businessScopes by companyType[{}] pageSize[{}] pageNumber[{}]",
                companyType,pageSize,pageNumber);

        PageHelper.startPage(pageNumber,pageSize,"id desc");
        Example example = new Example(PartyBuild.class);
        example.createCriteria().andEqualTo("partyBuildType",companyType)
                .andEqualTo("enabled",true);
        List<BusinessScope> businessScopes = businessScopeMapper.selectByExample(example);

        log.info("BusinessScopeService get partyBuilds [{}]",businessScopes.size());

        if(CollectionUtils.isEmpty(businessScopes)){
            throw new BaseException(StatEnum.STAT_NO_DATA);
        }

        for(BusinessScope businessScope : businessScopes) {

            log.info("BusinessScopeService get companyPrincipal by businessScopeId[{}]",businessScope.getId());

            List<CompanyPrincipal> companyPrincipals = companyPrincipalMapper.
                    selectPrincipalsByBusinessScopeId(businessScope.getId());

//            businessScope.setCompanyPrincipals(companyPrincipals);

        }

        return businessScopes;
    }

    @Override
    public List<BusinessScope> getBusinessScopesByCompanyName(String companyName) {

        return businessScopeMapper.getBusinessScopesByCompanyName(companyName);
    }


}
