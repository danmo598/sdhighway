package com.highway.service;

import com.highway.exception.BaseException;
import com.highway.model.CompanyPrincipal;

import java.util.List;

/**
 * Created by Liu Chen on 2018/11/11.
 */
public interface CompanyPrincipalService {
    Integer addCompanyPrincipal(CompanyPrincipal companyPrincipal);

    Integer removeCompanyPrincipal(Integer id);

    Integer updateCompanyPrincipal(CompanyPrincipal companyPrincipal);

    CompanyPrincipal getCompanyPrincipal(Integer id);

    List<CompanyPrincipal> getCompanyPrincipals(Integer pageSize, Integer pageNumber) throws BaseException;
}
