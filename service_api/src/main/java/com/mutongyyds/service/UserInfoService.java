package com.mutongyyds.service;

import com.mutongyyds.entity.UserInfo;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-12-02 22:39
 */
public interface UserInfoService extends BaseService<UserInfo> {
   UserInfo findUserInfoByPhone(String phone);
}
