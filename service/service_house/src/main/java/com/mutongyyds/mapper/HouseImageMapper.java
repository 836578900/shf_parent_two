package com.mutongyyds.mapper;

import com.mutongyyds.entity.HouseImage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-12-01 23:16
 */
public interface HouseImageMapper extends BaseMapper<HouseImage> {
    List<HouseImage> findListByHouseIdAndType(@Param("houseId") long houseId,@Param("type") Integer type);
}
