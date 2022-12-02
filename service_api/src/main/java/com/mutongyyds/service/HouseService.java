package com.mutongyyds.service;

import com.github.pagehelper.PageInfo;
import com.mutongyyds.entity.House;
import com.mutongyyds.vo.HouseQueryVo;
import com.mutongyyds.vo.HouseVo;

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
    PageInfo<HouseVo> findListPage(Integer pageNum, Integer pageSize, HouseQueryVo houseQueryVo);
}
