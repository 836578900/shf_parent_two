package com.mutongyyds.mapper;

import com.mutongyyds.entity.House;
import org.apache.ibatis.annotations.Param;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-11-30 19:13
 */
public interface HouseMapper extends BaseMapper<House> {
    void publish(@Param("houseId") long houseId,@Param("status") Integer status);
}
