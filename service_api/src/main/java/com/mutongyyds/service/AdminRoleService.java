package com.mutongyyds.service;

import com.mutongyyds.entity.AdminRole;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-12-04 22:08
 */
public interface AdminRoleService extends BaseService<AdminRole> {
    void insertByAdminId(Long adminId,Long[] roleIds);
}
