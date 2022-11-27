package com.mutongyyds.mapper;

import com.mutongyyds.entity.Role;

import java.util.List;
import java.util.Map;

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
