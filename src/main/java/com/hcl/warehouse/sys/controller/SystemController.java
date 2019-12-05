package com.hcl.warehouse.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author :liangHuang.
 * @Date :2019/12/4 17:45
 * @Description :系统控制层
 */
@Controller
@RequestMapping("sys/")
public class SystemController {
    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping(value = "toLogin")
    public String toLogin(){
        return "system/index/login";
    }

    /**
     * 跳转到首页
     * @return
     */
    @RequestMapping(value = "index")
    public String index(){
        return "system/index/index";
    }

    /**
     * 跳转到控制台
     * @return
     */
    @RequestMapping(value = "toDeskManager")
    public String toDeskManager(){
        return "system/index/deskManager";
    }

}
