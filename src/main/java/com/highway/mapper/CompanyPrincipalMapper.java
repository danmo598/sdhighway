package com.highway.mapper;

import com.highway.model.CompanyPrincipal;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Liu Chen on 2018/11/8.
 */
@Repository
public interface CompanyPrincipalMapper extends CommonMapper<CompanyPrincipal> {
    List<CompanyPrincipal> selectPrincipalsByBusinessScopeId(@Param("businessScopeId") Integer businessScopeId);

    CompanyPrincipal selectById(@Param("id") Integer id);
}
