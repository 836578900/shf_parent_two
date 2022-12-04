package com.mutongyyds.mapper;

import com.mutongyyds.entity.AdminRole;

import java.io.Serializable;
import java.util.List;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-12-04 21:55
 */
public interface AdminRoleMapper extends BaseMapper<AdminRole> {
    List<Long> findIdsByAdminId(Long adminId);

    void deleteByAdminId(Long id);
}
