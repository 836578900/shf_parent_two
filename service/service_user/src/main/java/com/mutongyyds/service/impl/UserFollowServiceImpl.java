package com.mutongyyds.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mutongyyds.entity.UserFollow;
import com.mutongyyds.mapper.BaseMapper;
import com.mutongyyds.mapper.UserFollowMapper;
import com.mutongyyds.service.DictService;
import com.mutongyyds.service.UserFollowService;
import com.mutongyyds.vo.UserFollowVo;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-12-04 20:07
 */
@DubboService
public class UserFollowServiceImpl extends BaseServiceImpl<UserFollow> implements UserFollowService {
    @Autowired
    private UserFollowMapper userFollowMapper;
    @DubboReference
    private DictService dictService;

    @Override
    public BaseMapper<UserFollow> getEntity() {
        return userFollowMapper;
    }

    @Override
    public UserFollow findByHouseIdAndUserId(Long houseId, Long userId) {
        return userFollowMapper.findByHouseIdAndUserId(houseId,userId);
    }

    @Override
    public PageInfo<UserFollowVo> findListPage(Integer pageNum, Integer pageSize, Long userId) {
        PageHelper.startPage(pageNum,pageSize);
        List<UserFollowVo> userFollowVoList = userFollowMapper.findUserFollowVoListByUserId(userId);
        for (UserFollowVo userFollowVo : userFollowVoList) {
            userFollowVo.setHouseTypeName(dictService.getById(userFollowVo.getHouseTypeId()).getName());
            userFollowVo.setFloorName(dictService.getById(userFollowVo.getFloorId()).getName());
            userFollowVo.setDirectionName(dictService.getById(userFollowVo.getDirectionId()).getName());
        }
        return new PageInfo<>(userFollowVoList,3);
    }
}
