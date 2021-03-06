package com.highway.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Created by Liu Chen on 2018/11/7.
 */
@Data
@NoArgsConstructor
public class CompanyPrincipal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer businessScopeId;

    private String name;

    private String phone1;

    private String phone2;

    private String phone3;

    private String phone4;

    private String phone5;

    private String email;

    private String type;

    private Boolean enabled = true;

    @Transient
    private BusinessScope businessScope;

}
