package com.mutongyyds.service.impl;

import com.mutongyyds.entity.Dict;
import com.mutongyyds.mapper.DictMapper;
import com.mutongyyds.service.DictService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
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
 * @create 2022-11-29 21:35
 */
@DubboService
public class DictServiceImpl implements DictService {
    @Autowired
    private DictMapper dictMapper;

    @Override
    public List<Map<String, Object>> findZnodes(long id) {
        List<Dict> dictList = dictMapper.findListByParentId(id);
        List<Map<String,Object>> list = new ArrayList<>();
        for (Dict dict : dictList) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("id",dict.getId());
            map.put("name",dict.getName());
            map.put("isParent",dictMapper.countParentId(dict.getId())>0);
            list.add(map);
        }
        return list;
    }

    @Override
    public List<Dict> findListByCode(String code) {
        Dict dict = dictMapper.findListByCode(code);
        List<Dict> list = dictMapper.findListByParentId(dict.getId());
        return list;
    }

    @Override
    public List<Dict> findListByParentId(long id) {
        return dictMapper.findListByParentId(id);
    }

    @Override
    public Dict getById(Long id) {
        return dictMapper.getById(id);
    }
}
