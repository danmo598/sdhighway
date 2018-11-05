package com.highway.service;

import com.highway.model.ConnectUs;
import com.highway.model.Tenders;
import com.highway.util.response.Page;

/**
 * Creaed by fj on 2018/11/5
 */
public interface IConnectUsService {
    Page<ConnectUs> getConnects(Integer pageNo, Integer pageSize);

    Integer addConnects(ConnectUs connectUs);

    Integer updateConnects(ConnectUs connectUs);

    Integer deleteConnects(Integer id);
}
