package com.mutongyyds.interceptor;

import com.mutongyyds.result.Result;
import com.mutongyyds.result.ResultCodeEnum;
import com.mutongyyds.util.WebUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * title:
 * Description:
 *
 * @version 1.0
 * @Author Tong
 * @create 2022-12-04 19:50
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object userInfo = session.getAttribute("userInfo");
        if (userInfo == null) {
            WebUtil.writeJSON(response, Result.build(null, ResultCodeEnum.LOGIN_AUTH));
            return false;
        }
        return true;
    }
}
