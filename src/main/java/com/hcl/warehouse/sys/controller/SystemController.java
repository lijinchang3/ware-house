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

    /**
     * 跳转到日志管理
     * @return
     */
    @RequestMapping(value = "toLoginfoManager")
    public String toLoginfoManager(){
        return "system/loginfo/loginfoManager";
    }

    /**
     * 跳转到公告管理
     * @return
     */
    @RequestMapping(value = "toNoticeManager")
    public String toNoticeManager(){
        return "system/notice/noticeManager";
    }

    /**
     * 跳转到部门管理页面
     * @return
     */
    @RequestMapping(value = "toDeptManager")
    public String toDeptManager(){
        return "system/dept/deptManager";
    }

    /**
     * 跳转到部门左侧嵌入页面
     * @return
     */
    @RequestMapping(value = "toDeptLeft")
    public String toDeptLeft(){
        return "system/dept/deptLeft";
    }

    /**
     * 跳转到部门右侧侧嵌入页面
     * @return
     */
    @RequestMapping(value = "toDeptRight")
    public String toDeptRight(){
        return "system/dept/deptRight";
    }
}
