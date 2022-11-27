package com.mutongyyds.mapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-11-27 12:49
 */
public interface BaseMapper<T> {
    List<T> findPage(Map<String,Object> filters);

    void insert(T t);

    T getById(Serializable id);

    void update(T t);

    void delete(Serializable id);
}
