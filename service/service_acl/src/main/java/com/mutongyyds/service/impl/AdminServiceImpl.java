package com.mutongyyds.service.impl;

import com.mutongyyds.entity.Admin;
import com.mutongyyds.mapper.AdminMapper;
import com.mutongyyds.mapper.BaseMapper;
import com.mutongyyds.service.AdminService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-11-27 13:21
 */
@DubboService
public class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public BaseMapper<Admin> getEntity() {
        return adminMapper;
    }
}
