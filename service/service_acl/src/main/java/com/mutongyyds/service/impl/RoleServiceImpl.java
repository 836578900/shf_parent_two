package com.mutongyyds.service.impl;

import com.mutongyyds.entity.Role;
import com.mutongyyds.mapper.AdminRoleMapper;
import com.mutongyyds.mapper.BaseMapper;
import com.mutongyyds.mapper.RoleMapper;
import com.mutongyyds.service.RoleService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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
@DubboService
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private AdminRoleMapper adminRoleMapper;

    @Override
    public List<Role> findAll() {
        return roleMapper.findAll();
    }

    @Override
    public Map<String, List<Role>> findRoleByAdminId(Long adminId) {
        List<Role> roleList = roleMapper.findAll();
        List<Long> roleIds = adminRoleMapper.findIdsByAdminId(adminId);
        ArrayList<Role> assignRoleList = new ArrayList<>();
        ArrayList<Role> noAssignRoleList = new ArrayList<>();
        for (Role role : roleList) {
            if (roleIds.contains(role.getId())){
                assignRoleList.add(role);
            }else {
                noAssignRoleList.add(role);
            }
        }
        Map<String, List<Role>> map = new HashMap<>();
        map.put("assignRoleList",assignRoleList);
        map.put("noAssignRoleList",noAssignRoleList);
        return map;
    }

    @Override
    public BaseMapper<Role> getEntity() {
        return roleMapper;
    }
}
