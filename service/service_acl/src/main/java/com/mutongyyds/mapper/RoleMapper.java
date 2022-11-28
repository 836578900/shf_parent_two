package com.mutongyyds.mapper;

import com.mutongyyds.entity.Role;

import java.util.List;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-11-25 16:42
 */
public interface RoleMapper extends BaseMapper<Role>{
    List<Role> findAll();

}
