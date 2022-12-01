package com.mutongyyds.service;

import com.mutongyyds.entity.Admin;
import com.mutongyyds.entity.HouseBroker;

import java.util.List;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-12-01 23:06
 */
public interface HouseBrokerService extends BaseService<HouseBroker> {
    List<HouseBroker> findListByHouseId(long houseId);

    List<Admin> findHouseOtherBroker(long houseId);
}
