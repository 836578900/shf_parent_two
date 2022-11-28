package com.mutongyyds.service.impl;

import com.mutongyyds.entity.Role;
import com.mutongyyds.mapper.BaseMapper;
import com.mutongyyds.mapper.RoleMapper;
import com.mutongyyds.service.RoleService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-11-25 16:45
 */
@DubboService
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAll() {
        return roleMapper.findAll();
    }

    @Override
    public BaseMapper<Role> getEntity() {
        return roleMapper;
    }
}
