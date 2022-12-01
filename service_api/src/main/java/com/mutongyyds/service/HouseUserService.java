package com.mutongyyds.service;

import com.mutongyyds.entity.HouseUser;

import java.util.List;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-12-01 23:08
 */
public interface HouseUserService extends BaseService<HouseUser> {
    List<HouseUser> findListByHouseId(long houseId);
}
