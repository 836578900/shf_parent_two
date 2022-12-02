package com.mutongyyds.mapper;

import com.mutongyyds.entity.UserInfo;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-12-02 22:41
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    UserInfo findUserInfoByPhone(String phone);
}
