package com.mutongyyds.controller;

import com.github.pagehelper.PageInfo;
import com.mutongyyds.entity.Community;
import com.mutongyyds.entity.Dict;
import com.mutongyyds.service.CommunityService;
import com.mutongyyds.service.DictService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-11-29 22:07
 */
@Controller
@RequestMapping("/community")
public class CommunityController extends BaseController{
    @DubboReference
    private CommunityService communityService;
    @DubboReference
    private DictService dictService;

    @RequestMapping
    public String index(HttpServletRequest request, Map map){
        Map<String, Object> filters = getFilters(request);
        PageInfo<Community> page = communityService.findPage(filters);
        map.put("filters",filters);
        map.put("page",page);

        List<Dict> areaList = dictService.findListByCode("beijing");
        map.put("areaList",areaList);
        return "community/index";
    }

    @RequestMapping(value = "/create")
    public String create(Map map){
        List<Dict> areaList = dictService.findListByCode("beijing");
        map.put("areaList",areaList);
        return "community/create";
    }

    @RequestMapping(value = "/save")
    public String save(Community community){
        communityService.insert(community);
        return "common/success";
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit(@PathVariable Integer id,Map map){
        List<Dict> areaList = dictService.findListByCode("beijing");
        map.put("areaList",areaList);
        Community community = communityService.getById(id);
        map.put("community",community);
        return "community/edit";
    }

    @RequestMapping(value = "/update")
    public String update(Community community){
        communityService.update(community);
        return "common/success";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable Integer id){
        communityService.delete(id);
        return "redirect:/community";
    }
}
