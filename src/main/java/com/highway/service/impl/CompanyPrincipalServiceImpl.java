package com.highway.service.impl;

import com.highway.mapper.CompanyPrincipalMapper;
import com.highway.model.CompanyPrincipal;
import com.highway.service.CompanyPrincipalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return companyPrincipalMapper.selectById(id);
    }
}
