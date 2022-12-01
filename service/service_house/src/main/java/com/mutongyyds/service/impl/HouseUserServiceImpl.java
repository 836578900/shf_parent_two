package com.mutongyyds.service.impl;

import com.mutongyyds.entity.HouseUser;
import com.mutongyyds.mapper.BaseMapper;
import com.mutongyyds.mapper.HouseUserMapper;
import com.mutongyyds.service.HouseUserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-12-01 23:11
 */
@DubboService
public class HouseUserServiceImpl extends BaseServiceImpl<HouseUser> implements HouseUserService {
    @Autowired
    private HouseUserMapper houseUserMapper;

    @Override
    public List<HouseUser> findListByHouseId(long houseId) {
        return houseUserMapper.findListByHouseId(houseId);
    }

    @Override
    public BaseMapper<HouseUser> getEntity() {
        return houseUserMapper;
    }
}
