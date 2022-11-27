package com.mutongyyds.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mutongyyds.entity.Role;
import com.mutongyyds.mapper.BaseMapper;
import com.mutongyyds.mapper.RoleMapper;
import com.mutongyyds.service.RoleService;
import com.mutongyyds.util.CastUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-11-25 16:45
 */
@Service
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
