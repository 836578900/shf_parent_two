package com.mutongyyds.controller;

import com.github.pagehelper.PageInfo;
import com.mutongyyds.entity.Community;
import com.mutongyyds.entity.House;
import com.mutongyyds.entity.HouseBroker;
import com.mutongyyds.entity.HouseImage;
import com.mutongyyds.result.Result;
import com.mutongyyds.service.CommunityService;
import com.mutongyyds.service.HouseBrokerService;
import com.mutongyyds.service.HouseImageService;
import com.mutongyyds.service.HouseService;
import com.mutongyyds.vo.HouseQueryVo;
import com.mutongyyds.vo.HouseVo;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.BlockingDeque;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-12-02 21:47
 */
@Controller
@RequestMapping("/house")
@ResponseBody
public class HouseController {
    @DubboReference
    private HouseService houseService;
    @DubboReference
    private CommunityService communityService;
    @DubboReference
    private HouseBrokerService houseBrokerService;
    @DubboReference
    private HouseImageService houseImageService;

    @RequestMapping(value = "/list/{pageNum}/{pageSize}")
    public Result findHousePage(
            @PathVariable Integer pageNum,
            @PathVariable Integer pageSize,
            @RequestBody HouseQueryVo houseQueryVo){
        PageInfo<HouseVo> page = houseService.findListPage(pageNum, pageSize, houseQueryVo);
        return Result.ok(page);
    }

    @RequestMapping(value = "/info/{houseId}")
    public Result info(@PathVariable long houseId){
        House house = houseService.getById(houseId);
        Community community = communityService.getById(house.getCommunityId());
        List<HouseBroker> houseBrokerList = houseBrokerService.findListByHouseId(houseId);
        List<HouseImage> houseImage1List = houseImageService.findListByHouseIdAndType(houseId, 1);
        Boolean isFollow = false;

        HashMap map = new HashMap();
        map.put("house",house);
        map.put("community",community);
        map.put("houseBrokerList",houseBrokerList);
        map.put("houseImage1List",houseImage1List);
        map.put("isFollow",isFollow);

        return Result.ok(map);
    }


}
