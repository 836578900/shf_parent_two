package com.mutongyyds.mapper;

import com.mutongyyds.entity.Dict;

import java.util.List;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-11-29 21:35
 */
public interface DictMapper {
    List<Dict> findListByParentId(long id);

    Integer countParentId(long parentId);
    Dict findListByCode(String code);

    Dict getById(long id);
}
