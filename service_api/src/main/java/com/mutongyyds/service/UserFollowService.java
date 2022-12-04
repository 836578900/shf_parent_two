package com.mutongyyds.service;

import com.github.pagehelper.PageInfo;
import com.mutongyyds.entity.UserFollow;
import com.mutongyyds.vo.UserFollowVo;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-12-04 19:58
 */
public interface UserFollowService extends BaseService<UserFollow> {
    UserFollow findByHouseIdAndUserId(Long houseId,Long userId);
    PageInfo<UserFollowVo> findListPage(Integer pageNum,Integer pageSize,Long userId);
}
