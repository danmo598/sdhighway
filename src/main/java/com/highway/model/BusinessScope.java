package com.highway.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Liu Chen on 2018/11/6.
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@Table(name="business_scope")
public class BusinessScope {

    @Id
    private Integer id;

    private String companyName;

    private String companyImage;

    private String companyAbstract;

    private String companyType;

    private String companyDetail;

    private String detailAddress;

    private Boolean enabled = true;

    @Transient
    private List<CompanyPrincipal> companyPrincipals;

}
