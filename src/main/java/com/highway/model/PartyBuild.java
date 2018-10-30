package com.highway.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Liu Chen on 2018/10/30.
 */
@Data
@NoArgsConstructor
public class PartyBuild {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String promulgator;

    private Integer viewTimes;

    private Integer type;

    private String url;

    @Column(name = "isPush")
    private Boolean isPush;

    private Date date;

    private String content;

}
