package com.mutongyyds.service;

import com.mutongyyds.entity.Role;

import java.util.List;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-11-25 16:44
 */
public interface RoleService extends BaseService<Role>{
    List<Role> findAll();

}
