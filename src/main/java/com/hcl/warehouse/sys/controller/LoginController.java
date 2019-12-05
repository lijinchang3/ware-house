package com.hcl.warehouse.sys.controller;

import com.hcl.warehouse.sys.common.ResultObj;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author :liangHuang.
 * @Date :2019/12/5 11:19
 * @Description :登录前端控制器
 */
@RestController
@RequestMapping("login")
public class LoginController {

    public ResultObj login(String loginname, String pwd){
        return null;
    }

}
