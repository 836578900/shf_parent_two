package com.mutongyyds.mapper;

import com.mutongyyds.entity.HouseUser;

import java.util.List;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-12-01 23:13
 */
public interface HouseUserMapper extends BaseMapper<HouseUser> {
    List<HouseUser> findListByHouseId(long houseId);
}
