package com.mutongyyds.mapper;

import com.mutongyyds.entity.Community;

import java.util.List;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-11-29 22:22
 */
public interface CommunityMapper extends BaseMapper<Community> {
    List<Community> findAll();
}
