package com.highway.service;

import com.highway.exception.BaseException;
import com.highway.model.BusinessScope;

import java.util.List;

/**
 * Created by Liu Chen on 2018/11/8.
 */
public interface BusinessScopeService {
    Integer addBusinessScope(BusinessScope businessScope);

    Integer removeBusinessScope(Integer businessScopeId);

    Integer updateBusinessScope(BusinessScope businessScope);

    BusinessScope getBusinessScope(Integer businessScopeId);

    List<BusinessScope> getBusinessScopes(Integer companyType, Integer pageSize, Integer pageNumber) throws BaseException;

    List<BusinessScope> getBusinessScopesByCompanyName(String companyName);
}
