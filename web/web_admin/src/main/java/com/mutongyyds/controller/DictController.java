package com.mutongyyds.controller;

import com.mutongyyds.entity.Dict;
import com.mutongyyds.result.Result;
import com.mutongyyds.service.DictService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-11-29 21:02
 */
@Controller
@RequestMapping("/dict")
public class DictController {
    @DubboReference
    private DictService dictService;


    @RequestMapping
    public String index(){

        return "dict/index";
    }

    @RequestMapping(value = "/findZnodes")
    @ResponseBody
    public Result findZnodes(@RequestParam(value = "id",defaultValue = "0") long id){
        List<Map<String, Object>> znodes = dictService.findZnodes(id);
        return Result.ok(znodes);
    }

    @RequestMapping(value = "/findListByParentId/{areaId}")
    @ResponseBody
    public Result findListByParentId(@PathVariable long areaId){
        List<Dict> list = dictService.findListByParentId(areaId);
        return Result.ok(list);
    }
}
