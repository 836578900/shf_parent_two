package com.mutongyyds.service.impl;

import com.mutongyyds.entity.Community;
import com.mutongyyds.mapper.BaseMapper;
import com.mutongyyds.mapper.CommunityMapper;
import com.mutongyyds.mapper.DictMapper;
import com.mutongyyds.service.BaseService;
import com.mutongyyds.service.CommunityService;
import org.apache.dubbo.config.annotation.DubboReference;
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
 * @create 2022-11-29 22:20
 */
@DubboService
public class CommunityServiceImpl extends BaseServiceImpl<Community> implements CommunityService {
    @Autowired
    private CommunityMapper communityMapper;
    @Autowired
    private DictMapper dictMapper;

    @Override
    public BaseMapper<Community> getEntity() {
        return communityMapper;
    }

    @Override
    public List<Community> findAll() {
        return communityMapper.findAll();
    }

    @Override
    public Community getById(Serializable id) {
        Community community = communityMapper.getById(id);
        community.setAreaName(dictMapper.getById(community.getAreaId()).getName());
        community.setPlateName(dictMapper.getById(community.getPlateId()).getName());
        return community;
    }
}
