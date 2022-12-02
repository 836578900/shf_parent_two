package com.mutongyyds.controller;

import com.mutongyyds.entity.HouseImage;
import com.mutongyyds.result.Result;
import com.mutongyyds.service.HouseImageService;
import com.mutongyyds.util.QiniuUtil;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-12-02 16:41
 */
@Controller
@RequestMapping("/houseImage")
public class HouseImageController {
    @DubboReference
    private HouseImageService houseImageService;


    @RequestMapping(value = "/uploadShow/{houseId}/{type}")
    public String uploadShow(@PathVariable long houseId, @PathVariable Integer type, Map map){
        map.put("houseId",houseId);
        map.put("type",type);
        return "house/upload";
    }

    @RequestMapping(value = "/upload/{houseId}/{type}")
    @ResponseBody
    public Result upload(
            @PathVariable long houseId,
            @PathVariable Integer type,
            @RequestParam("file")MultipartFile[] files) throws IOException {
        for (MultipartFile file : files) {
            String fileName= UUID.randomUUID().toString();
            QiniuUtil.upload2Qiniu(file.getBytes(),fileName);

            HouseImage houseImage = new HouseImage();
            houseImage.setHouseId(houseId);
            houseImage.setType(type);
            houseImage.setImageName(fileName);
            houseImage.setImageUrl("http://rm7y3wp76.hn-bkt.clouddn.com/"+fileName);
            houseImageService.insert(houseImage);
        }
        return Result.ok();
    }

    @RequestMapping(value = "/delete/{houseId}/{id}")
    public String delete(@PathVariable long houseId,@PathVariable Integer id){
        houseImageService.delete(id);
        return "redirect:/house/show/"+houseId;
    }
}
