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
public interface RoleMapper {
    List<Role> findAll();

    void insert(Role role);

    Role getById(Integer id);

    void update(Role role);

    void delete(Integer id);
}
