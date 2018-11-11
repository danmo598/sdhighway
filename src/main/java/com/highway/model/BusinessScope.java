package com.highway.model;

import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Liu Chen on 2018/11/6.
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class BusinessScope {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String companyName;

    private String companyImage;

    private String companyAbstract;

    private String companyType;

    private String companyDetail;

    private String detailAddress;

    private Boolean enabled = true;

    private List<CompanyPrincipal> companyPrincipals;

}
