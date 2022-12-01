package com.mutongyyds.service;

import com.mutongyyds.entity.House;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-11-30 19:11
 */
public interface HouseService extends BaseService<House> {
    void publish(long houseId,Integer status);
}
