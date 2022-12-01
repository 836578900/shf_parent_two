package com.mutongyyds.service;

import com.mutongyyds.entity.HouseImage;

import java.util.List;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-12-01 23:03
 */
public interface HouseImageService extends BaseService<HouseImage> {
    List<HouseImage> findListByHouseIdAndType(long houseId,Integer type);
}
