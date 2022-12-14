package com.mutongyyds.controller;

import com.github.pagehelper.PageInfo;
import com.mutongyyds.entity.Role;
import com.mutongyyds.service.RoleService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-11-25 16:48
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController{
    @DubboReference
    private RoleService roleService;

    @RequestMapping
    public String findPage(Map map,HttpServletRequest request) {
        Map<String, Object> filters = getFilters(request);
        PageInfo<Role> page = roleService.findPage(filters);
        map.put("filters", filters);
        map.put("page", page);
        return "role/index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create() {

        return "role/create";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Role role) {
        roleService.insert(role);
        return "common/success";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Map map, @PathVariable Integer id) {
        Role role = roleService.getById(id);
        map.put("role", role);
        return "role/edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(Role role) {
        roleService.update(role);
        return "common/success";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Integer id) {
        roleService.delete(id);
        return "redirect:/role";
    }



}
