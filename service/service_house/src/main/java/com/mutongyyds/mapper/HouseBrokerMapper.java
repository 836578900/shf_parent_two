package com.mutongyyds.mapper;

import com.mutongyyds.entity.Admin;
import com.mutongyyds.entity.HouseBroker;

import java.util.List;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-12-01 23:15
 */
public interface HouseBrokerMapper extends BaseMapper<HouseBroker> {
    List<HouseBroker> findListByHouseId(long houseId);

    List<Admin> findHouseOtherBroker(List<Long> ids);
}
