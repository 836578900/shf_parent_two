package com.mutongyyds.controller;

import com.mutongyyds.entity.UserInfo;
import com.mutongyyds.result.Result;
import com.mutongyyds.result.ResultCodeEnum;
import com.mutongyyds.service.UserInfoService;
import com.mutongyyds.util.MD5;
import com.mutongyyds.vo.RegisterVo;
import com.mysql.cj.protocol.ResultsetRow;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-12-02 22:28
 */
@Controller
@RequestMapping("/userInfo")
@ResponseBody
public class UserInfoController {
    @DubboReference
    private UserInfoService userInfoService;


    @RequestMapping(value = "/sendCode/{phone}")
    public Result sendCode(@PathVariable String phone, HttpSession session){
        String code = "6666";
        session.setAttribute("code",code);
        return Result.ok(code);
    }

    @RequestMapping(value = "/register")
    public Result register(HttpSession session, @RequestBody RegisterVo registerVo){
        String code = registerVo.getCode();
        String nickName = registerVo.getNickName();
        String password = registerVo.getPassword();
        String phone = registerVo.getPhone();
        //判断数据是否非空
        if (StringUtils.isEmpty(code)||StringUtils.isEmpty(nickName)||StringUtils.isEmpty(password)||StringUtils.isEmpty(phone)){
            return Result.build(null, ResultCodeEnum.PARAM_ERROR);
        }
        //判断验证码是否正确
        String trueCode = (String) session.getAttribute("code");
        if (!trueCode.equals(code)){
            return Result.build(null, ResultCodeEnum.CODE_ERROR);
        }
        //判断手机号是否已经注册
        UserInfo userInfo = userInfoService.findUserInfoByPhone(phone);
        if (userInfo!=null){
            return Result.build(null, ResultCodeEnum.PHONE_REGISTER_ERROR);
        }
        //将数据写入到数据库
        userInfo = new UserInfo();
        userInfo.setNickName(nickName);
        userInfo.setPassword(MD5.encrypt(password));
        userInfo.setPhone(phone);
        userInfoService.insert(userInfo);
        return Result.ok();
    }
}
