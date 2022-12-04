package com.mutongyyds.controller;

import com.github.pagehelper.PageInfo;
import com.mutongyyds.entity.Admin;
import com.mutongyyds.entity.Role;
import com.mutongyyds.result.Result;
import com.mutongyyds.service.AdminRoleService;
import com.mutongyyds.service.AdminService;
import com.mutongyyds.service.RoleService;
import com.mutongyyds.util.QiniuUtil;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-11-27 13:18
 */
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {
    @DubboReference
    private AdminService adminService;
    @DubboReference
    private RoleService roleService;
    @DubboReference
    AdminRoleService adminRoleService;

    @RequestMapping
    public String findPage(Map map, HttpServletRequest request){
        Map<String, Object> filters = getFilters(request);
        PageInfo<Admin> page = adminService.findPage(filters);
        map.put("filters",filters);
        map.put("page",page);
        return "admin/index";
    }

    @RequestMapping(value = "/create")
    public String create(){

        return "admin/create";
    }

    @RequestMapping(value = "/save")
    public String save(Admin admin){
        adminService.insert(admin);
        return "common/success";
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit(@PathVariable Integer id,Map map){
        Admin admin = adminService.getById(id);
        map.put("admin",admin);
        return "admin/edit";
    }

    @RequestMapping(value = "/update")
    public String update(Admin admin){
        adminService.update(admin);
        return "common/success";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable Integer id){
        adminService.delete(id);
        return "redirect:/admin";
    }

    @RequestMapping("/uploadShow/{adminId}")
    public String uploadShow(ModelMap model, @PathVariable Long adminId) {
        model.addAttribute("adminId", adminId);
        return "admin/upload";
    }

    @RequestMapping(value = "/upload")
    public String uploadShow(long adminId, @RequestParam("file")MultipartFile file) throws IOException {
        Admin admin = adminService.getById(adminId);
        String fileName = UUID.randomUUID().toString();
        QiniuUtil.upload2Qiniu(file.getBytes(),fileName);
        admin.setHeadUrl("http://rm7y3wp76.hn-bkt.clouddn.com/"+ fileName);
        adminService.update(admin);
        return "common/success";
    }

    @RequestMapping(value = "/assignShow/{adminId}")
    public String assignShow(@PathVariable Long adminId,Map map){
        Map<String, List<Role>> map1 = roleService.findRoleByAdminId(adminId);
        map.putAll(map1);
        map.put("adminId",adminId);
        return "admin/assignShow";
    }

    @RequestMapping(value = "/assignRole")
    public String assignRole(Long adminId,Long[] roleIds){
        adminRoleService.insertByAdminId(adminId,roleIds);
        return "common/success";
    }
}
