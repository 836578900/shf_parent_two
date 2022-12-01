package com.mutongyyds.service.impl;

import com.mutongyyds.entity.Admin;
import com.mutongyyds.entity.HouseBroker;
import com.mutongyyds.mapper.BaseMapper;
import com.mutongyyds.mapper.HouseBrokerMapper;
import com.mutongyyds.service.HouseBrokerService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-12-01 23:10
 */
@DubboService
public class HouseBrokerServiceImpl extends BaseServiceImpl<HouseBroker> implements HouseBrokerService {
    @Autowired
    private HouseBrokerMapper houseBrokerMapper;

    @Override
    public List<HouseBroker> findListByHouseId(long houseId) {
        return houseBrokerMapper.findListByHouseId(houseId);
    }

    @Override
    public List<Admin> findHouseOtherBroker(long houseId) {
        List<HouseBroker> brokerList = houseBrokerMapper.findListByHouseId(houseId);
        ArrayList<Long> ids = new ArrayList<>();
        for (HouseBroker houseBroker : brokerList) {
            ids.add(houseBroker.getBrokerId());
        }
        return houseBrokerMapper.findHouseOtherBroker(ids);
    }

    @Override
    public BaseMapper<HouseBroker> getEntity() {
        return houseBrokerMapper;
    }
}
