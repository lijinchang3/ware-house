package com.hcl.warehouse.sys.controller;

import com.hcl.warehouse.sys.common.ActiverUser;
import com.hcl.warehouse.sys.common.ResultObj;
import com.hcl.warehouse.sys.common.WebUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author :liangHuang.
 * @Date :2019/12/5 11:19
 * @Description :登录前端控制器
 */
@RestController
@RequestMapping("login/")
public class LoginController {

    /**
     * 进行登录验证
     * @param loginname
     * @param pwd
     * @return
     */
    @RequestMapping(value = "login")
    public ResultObj login(String loginname, String pwd){
        try {
            //获取Subject对象
            Subject subject = SecurityUtils.getSubject();
            //执行认证
            subject.login(new UsernamePasswordToken(loginname, pwd));
            ActiverUser activerUser = (ActiverUser) subject.getPrincipal();
            //session设值
            WebUtils.getSession().setAttribute("user", activerUser.getUser());
            return ResultObj.LOGIN_SUCCESS;
        } catch (AuthenticationException e) {
            return ResultObj.LOGIN_ERROR_PASS;
        }
    }

}
