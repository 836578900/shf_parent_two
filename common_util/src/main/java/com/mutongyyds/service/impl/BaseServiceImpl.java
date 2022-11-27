package com.mutongyyds.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mutongyyds.mapper.BaseMapper;
import com.mutongyyds.service.BaseService;
import com.mutongyyds.util.CastUtil;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-11-27 12:54
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {
    public abstract BaseMapper<T> getEntity();

    @Override
    public PageInfo<T> findPage(Map<String, Object> filters) {
        int pageNum = CastUtil.castInt(filters.get("pageNum"), 1);
        int pageSize = CastUtil.castInt(filters.get("pageSize"), 4);
        PageHelper.startPage(pageNum,pageSize);
        List<T> page = getEntity().findPage(filters);
        PageInfo<T> pageInfo = new PageInfo<>(page,3);
        return pageInfo;
    }

    @Override
    public void insert(T t) {
        getEntity().insert(t);
    }

    @Override
    public T getById(Serializable id) {
        return getEntity().getById(id);
    }

    @Override
    public void update(T t) {
        getEntity().update(t);
    }

    @Override
    public void delete(Serializable id) {
        getEntity().delete(id);
    }
}
