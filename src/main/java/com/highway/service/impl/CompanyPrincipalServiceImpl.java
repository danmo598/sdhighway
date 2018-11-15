package com.highway.service.impl;

import com.github.pagehelper.PageHelper;
import com.highway.exception.BaseException;
import com.highway.mapper.CompanyPrincipalMapper;
import com.highway.model.BusinessScope;
import com.highway.model.CompanyPrincipal;
import com.highway.model.PartyBuild;
import com.highway.service.CompanyPrincipalService;
import com.highway.util.enums.StatEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by Liu Chen on 2018/11/11.
 */
@Service
@Slf4j
public class CompanyPrincipalServiceImpl implements CompanyPrincipalService {

    @Autowired
    private CompanyPrincipalMapper companyPrincipalMapper;

    @Override
    public Integer addCompanyPrincipal(CompanyPrincipal companyPrincipal) {

        return companyPrincipalMapper.insertSelective(companyPrincipal);

    }

    @Override
    public Integer removeCompanyPrincipal(Integer id) {

        return companyPrincipalMapper.deleteByPrimaryKey(id);

    }

    @Override
    public Integer updateCompanyPrincipal(CompanyPrincipal companyPrincipal) {
        return companyPrincipalMapper.updateByPrimaryKey(companyPrincipal);
    }

    @Override
    public CompanyPrincipal getCompanyPrincipal(Integer id) {
        return companyPrincipalMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CompanyPrincipal> getCompanyPrincipals(Integer pageSize, Integer pageNumber) throws BaseException {

        PageHelper.startPage(pageNumber,pageSize,"id desc");
        Example example = new Example(PartyBuild.class);
        example.createCriteria().andEqualTo("enabled",true);

        List<CompanyPrincipal> companyPrincipals = companyPrincipalMapper.selectByExample(example);

        log.info("companyPrincipals get companyPrincipals [{}]",companyPrincipals.size());

        if(CollectionUtils.isEmpty(companyPrincipals)){
            throw new BaseException(StatEnum.STAT_NO_DATA);
        }

        return companyPrincipals;
    }
}
