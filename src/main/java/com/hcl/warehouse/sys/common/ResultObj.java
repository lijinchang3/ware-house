package com.hcl.warehouse.sys.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author :liangHuang.
 * @Date :2019/12/5 11:22
 * @Description : 返回常量控制
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultObj {

    public static final ResultObj LOGIN_SUCCESS = new ResultObj(Constast.OK, "登录成功");

    public static final ResultObj LOGIN_ERROR_PASS = new ResultObj(Constast.ERROR, "登录失败,用户名或密码不正确");

    public static final ResultObj LOGIN_ERROR_CODE = new ResultObj(Constast.ERROR, "登录失败,验证码不正确");
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 信息
     */
    private String msg;

}
