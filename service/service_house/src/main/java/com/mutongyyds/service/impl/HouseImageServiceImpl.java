package com.mutongyyds.service.impl;

import com.mutongyyds.entity.HouseImage;
import com.mutongyyds.mapper.BaseMapper;
import com.mutongyyds.mapper.HouseImageMapper;
import com.mutongyyds.service.HouseImageService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-12-01 23:09
 */
@DubboService
public class HouseImageServiceImpl extends BaseServiceImpl<HouseImage> implements HouseImageService {
    @Autowired
    private HouseImageMapper houseImageMapper;

    @Override
    public List<HouseImage> findListByHouseIdAndType(long houseId, Integer type) {
        return houseImageMapper.findListByHouseIdAndType(houseId,type);
    }

    @Override
    public BaseMapper<HouseImage> getEntity() {
        return houseImageMapper;
    }
}
