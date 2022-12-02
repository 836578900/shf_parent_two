package com.mutongyyds.service.impl;

import com.mutongyyds.entity.UserInfo;
import com.mutongyyds.mapper.BaseMapper;
import com.mutongyyds.mapper.UserInfoMapper;
import com.mutongyyds.service.UserInfoService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-12-02 22:40
 */
@DubboService
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfo> implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public BaseMapper<UserInfo> getEntity() {
        return userInfoMapper;
    }

    @Override
    public UserInfo findUserInfoByPhone(String phone) {
        return userInfoMapper.findUserInfoByPhone(phone);
    }
}
