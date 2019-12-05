package com.hcl.warehouse.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author :liangHuang.
 * @Date :2019/12/4 17:45
 * @Description :系统控制层
 */
@Controller
@RequestMapping("sys")
public class SystemController {
    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping(value = "/toLogin")
    public String toLogin(){
        return "system/index/login";
    }
}
