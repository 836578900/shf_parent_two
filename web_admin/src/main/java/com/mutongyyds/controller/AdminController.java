package com.mutongyyds.controller;

import com.github.pagehelper.PageInfo;
import com.mutongyyds.entity.Admin;
import com.mutongyyds.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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
    @Autowired
    private AdminService adminService;

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
}
