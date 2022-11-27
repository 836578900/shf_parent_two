package com.mutongyyds.service;

import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.Map;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-11-27 12:52
 */
public interface BaseService<T> {

    PageInfo<T> findPage(Map<String,Object> filters);

    void insert(T t);

    T getById(Serializable id);

    void update(T t);

    void delete(Serializable id);
}
