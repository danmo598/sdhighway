package com.highway.service.impl;

import com.github.pagehelper.PageHelper;
import com.highway.mapper.ConnectUsMapper;
import com.highway.model.ConnectUs;
import com.highway.model.Tenders;
import com.highway.service.IConnectUsService;
import com.highway.util.response.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Creaed by fj on 2018/11/5
 */
@Service
public class ConnectUsServiceImpl implements IConnectUsService {

    @Autowired
    private ConnectUsMapper connectUsMapper;

    @Override
    public Page<ConnectUs> getConnects(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize,"publishDate desc");
        List<ConnectUs> connectUsList = connectUsMapper.selectAll();
        connectUsList.stream().forEach(connectUs -> {
            if(connectUs!=null && connectUs.getWatchTimes()!=null){
                connectUs.setWatchTimes(connectUs.getWatchTimes()+1);
                connectUsMapper.updateByPrimaryKey(connectUs);
            }
        });
        return new Page<>(connectUsList);
    }

    @Override
    public Integer addConnects(ConnectUs connectUs) {
        return connectUsMapper.insertSelective(connectUs);
    }

    @Override
    public Integer updateConnects(ConnectUs connectUs) {
        return connectUsMapper.updateByPrimaryKey(connectUs);
    }

    @Override
    public Integer deleteConnects(Integer id) {
        return connectUsMapper.deleteByPrimaryKey(id);
    }
}
