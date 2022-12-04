package com.mutongyyds.mapper;

import com.mutongyyds.entity.UserFollow;
import com.mutongyyds.vo.UserFollowVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-12-04 20:08
 */
public interface UserFollowMapper extends BaseMapper<UserFollow> {
    UserFollow findByHouseIdAndUserId(@Param("houseId") Long houseId,@Param("userId") Long userId);
    List<UserFollowVo>  findUserFollowVoListByUserId(Long userId);
}
