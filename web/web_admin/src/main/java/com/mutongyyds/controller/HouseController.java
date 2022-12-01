package com.mutongyyds.controller;

import com.github.pagehelper.PageInfo;
import com.mutongyyds.entity.*;
import com.mutongyyds.service.*;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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
 * @create 2022-11-29 23:02
 */
@Controller
@RequestMapping("/house")
public class HouseController extends BaseController{
    @DubboReference
    private HouseService houseService;
    @DubboReference
    private CommunityService communityService;
    @DubboReference
    private DictService dictService;
    @DubboReference
    private HouseImageService houseImageService;
    @DubboReference
    private HouseBrokerService houseBrokerService;
    @DubboReference
    private HouseUserService houseUserService;


    @RequestMapping
    public String index(HttpServletRequest request, Map map){
        Map<String, Object> filters = getFilters(request);
        PageInfo<House> page = houseService.findPage(filters);
        getSource(map);
        map.put("filters",filters);
        map.put("page",page);
        return "house/index";
    }

    @RequestMapping(value = "/create")
    public String create(Map map){
        getSource(map);
        return "house/create";
    }

    @RequestMapping(value = "/save")
    public String save(House house){
        houseService.insert(house);
        return "common/success";
    }

    @RequestMapping(value = "/edit/{houseId}")
    public String edit(@PathVariable long houseId,Map map){
        House house = houseService.getById(houseId);
        map.put("house",house);
        getSource(map);
        return "house/edit";
    }

    @RequestMapping(value = "/update")
    public String update(House house){
        houseService.update(house);
        return "common/success";
    }

    @RequestMapping(value = "/delete/{houseId}")
    public String delete(@PathVariable long houseId){
        houseService.delete(houseId);
        return "redirect:/house";
    }

    @RequestMapping(value = "/publish/{houseId}/{status}")
    public String publish(@PathVariable long houseId,@PathVariable Integer status){
        houseService.publish(houseId,status);
        return "redirect:/house";
    }

    @RequestMapping(value = "/show/{houseId}")
    public String show(@PathVariable long houseId,Map map){
        //房屋信息
        House house = houseService.getById(houseId);
        //小区信息
        Community community = communityService.getById(house.getCommunityId());
        //房源图片
        List<HouseImage> houseImage1List = houseImageService.findListByHouseIdAndType(houseId, 1);
        //房产图片
        List<HouseImage> houseImage2List = houseImageService.findListByHouseIdAndType(houseId, 2);
        //经纪人信息
        List<HouseBroker> houseBrokerList = houseBrokerService.findListByHouseId(houseId);
        //房东信息
        List<HouseUser> houseUserList = houseUserService.findListByHouseId(houseId);

        map.put("house",house);
        map.put("community",community);
        map.put("houseImage1List",houseImage1List);
        map.put("houseImage2List",houseImage2List);
        map.put("houseBrokerList",houseBrokerList);
        map.put("houseUserList",houseUserList);

        return "house/show";
    }




    /**
     * 获取高级查询所需要的数据
     * @param map
     */
    protected void getSource(Map map){
        List<Community> communityList = communityService.findAll();
        List<Dict> houseTypeList = dictService.findListByCode("houseType");
        List<Dict> floorList = dictService.findListByCode("floor");
        List<Dict> buildStructureList = dictService.findListByCode("buildStructure");
        List<Dict> decorationList = dictService.findListByCode("decoration");
        List<Dict> directionList = dictService.findListByCode("direction");
        List<Dict> houseUseList = dictService.findListByCode("houseUse");
        map.put("communityList",communityList);
        map.put("houseTypeList",houseTypeList);
        map.put("floorList",floorList);
        map.put("buildStructureList",buildStructureList);
        map.put("decorationList",decorationList);
        map.put("directionList",directionList);
        map.put("houseUseList",houseUseList);
    }

}
