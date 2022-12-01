package com.mutongyyds.service;

import com.mutongyyds.entity.Community;

import java.util.List;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-11-29 22:06
 */
public interface CommunityService extends BaseService<Community> {
    List<Community> findAll();
}
