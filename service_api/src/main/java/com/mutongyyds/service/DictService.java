package com.mutongyyds.service;

import com.mutongyyds.entity.Dict;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-11-29 21:06
 */
public interface DictService {
    List<Map<String,Object>> findZnodes(long id);

    List<Dict> findListByCode(String code);

    List<Dict> findListByParentId(long id);

    Dict getById(Long id);
}
