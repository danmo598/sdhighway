package com.highway.service;

import com.highway.model.CompanyPrincipal;

/**
 * Created by Liu Chen on 2018/11/11.
 */
public interface CompanyPrincipalService {
    Integer addCompanyPrincipal(CompanyPrincipal companyPrincipal);

    Integer removeCompanyPrincipal(Integer id);

    Integer updateCompanyPrincipal(CompanyPrincipal companyPrincipal);

    CompanyPrincipal getCompanyPrincipal(Integer id);
}
