package com.mutongyyds.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mutongyyds.entity.House;
import com.mutongyyds.mapper.BaseMapper;
import com.mutongyyds.mapper.DictMapper;
import com.mutongyyds.mapper.HouseMapper;
import com.mutongyyds.service.HouseService;
import com.mutongyyds.vo.HouseQueryVo;
import com.mutongyyds.vo.HouseVo;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-11-30 19:12
 */
@DubboService
public class HouseServiceImpl extends BaseServiceImpl<House> implements HouseService {
    @Autowired
    private HouseMapper houseMapper;
    @Autowired
    private DictMapper dictMapper;

    @Override
    public BaseMapper<House> getEntity() {
        return houseMapper;
    }

    @Override
    public void publish(long houseId, Integer status) {
        houseMapper.publish(houseId,status);
    }

    @Override
    public PageInfo<HouseVo> findListPage(Integer pageNum, Integer pageSize, HouseQueryVo houseQueryVo) {
        PageHelper.startPage(pageNum,pageSize);
        List<HouseVo> page = houseMapper.findListPage(houseQueryVo);
        for (HouseVo houseVo : page) {
            houseVo.setHouseTypeName(dictMapper.getById(houseVo.getHouseTypeId()).getName());
            houseVo.setFloorName(dictMapper.getById(houseVo.getFloorId()).getName());
            houseVo.setDirectionName(dictMapper.getById(houseVo.getDirectionId()).getName());
        }
        return new PageInfo<>(page,3);
    }

    @Override
    public House getById(Serializable id) {
        House house = houseMapper.getById(id);
        house.setHouseTypeName(dictMapper.getById(house.getHouseTypeId()).getName());
        house.setFloorName(dictMapper.getById(house.getFloorId()).getName());
        house.setBuildStructureName(dictMapper.getById(house.getBuildStructureId()).getName());
        house.setDirectionName(dictMapper.getById(house.getDirectionId()).getName());
        house.setDecorationName(dictMapper.getById(house.getDecorationId()).getName());
        house.setHouseUseName(dictMapper.getById(house.getHouseUseId()).getName());
        return house;
    }
}
