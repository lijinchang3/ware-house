package com.hcl.warehouse.sys.common;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author :liangHuang.
 * @Date :2019/12/5 12:09
 * @Description : web相关工具类
 */
public class WebUtils {

    /**
     * 得到request
     */
    public static HttpServletRequest getRequest(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        return request;
    }

    /**
     * 得到session
     * @return
     */
    public static HttpSession getSession(){
        return getRequest().getSession();
    }
}
