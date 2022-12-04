package com.mutongyyds.service.impl;

import com.mutongyyds.entity.AdminRole;
import com.mutongyyds.mapper.AdminRoleMapper;
import com.mutongyyds.mapper.BaseMapper;
import com.mutongyyds.service.AdminRoleService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-12-04 22:09
 */
@DubboService
public class AdminRoleServiceImpl extends BaseServiceImpl<AdminRole> implements AdminRoleService {
    @Autowired
    private AdminRoleMapper adminRoleMapper;

    @Override
    public BaseMapper<AdminRole> getEntity() {
        return adminRoleMapper;
    }

    @Override
    @Transactional
    public void insertByAdminId(Long adminId, Long[] roleIds) {
        adminRoleMapper.deleteByAdminId(adminId);
        for (Long roleId : roleIds) {
            if (roleId == null) {
                continue;
            }
            AdminRole adminRole = new AdminRole();
            adminRole.setAdminId(adminId);
            adminRole.setRoleId(roleId);
            adminRoleMapper.insert(adminRole);
        }
    }
}
