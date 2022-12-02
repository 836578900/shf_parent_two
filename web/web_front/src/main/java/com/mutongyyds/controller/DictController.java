package com.mutongyyds.controller;

import com.mutongyyds.entity.Dict;
import com.mutongyyds.result.Result;
import com.mutongyyds.service.DictService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-12-02 21:42
 */
@Controller
@RequestMapping("/dict")
@ResponseBody
public class DictController {
    @DubboReference
    private DictService dictService;

    @RequestMapping(value = "/findListByDictCode/{code}")
    public Result findListByDictCode(@PathVariable String code){
        List<Dict> dictList = dictService.findListByCode(code);
        return Result.ok(dictList);
    }

    /**
     * 房源区域和板块的二级联动
     * @param id
     * @return
     */
    @RequestMapping(value = "/findListByParentId/{id}")
    public Result findListByParentId(@PathVariable Integer id){
        List<Dict> dictList = dictService.findListByParentId(id);
        return Result.ok(dictList);
    }
}
