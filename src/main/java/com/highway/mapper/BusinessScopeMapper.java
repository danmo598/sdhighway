package com.highway.mapper;

import com.highway.model.BusinessScope;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Liu Chen on 2018/11/8.
 */
@Repository
public interface BusinessScopeMapper extends CommonMapper<BusinessScope> {

    BusinessScope getBusinessScopeById(@Param("businessScopeId") Integer businessScopeId);

    List<BusinessScope> getBusinessScopesByCompanyName(@Param("companyName") String companyName);
}
