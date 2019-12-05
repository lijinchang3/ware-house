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
    /**
     * 登陆成功提示消息
     */
    public static final ResultObj LOGIN_SUCCESS = new ResultObj(Constast.OK, "登录成功");
    /**
     * 登录失败提示消息
     */
    public static final ResultObj LOGIN_ERROR_PASS = new ResultObj(Constast.ERROR, "登录失败,用户名或密码不正确");
    /**
     * 验证码未通过提示消息
     */
    public static final ResultObj LOGIN_ERROR_CODE = new ResultObj(Constast.ERROR, "登录失败,验证码不正确");
    /**
     * 删除操作成功提示消息
     */
    public static final ResultObj DELETE_SUCCESS = new ResultObj(Constast.OK, "删除成功");
    /**
     * 删除操作失败提示消息
     */
    public static final ResultObj DELETE_ERROR = new ResultObj(Constast.ERROR, "删除失败");
    /**
     * 修改操作成功提示消息
     */
    public static final ResultObj UPDATE_SUCCESS = new ResultObj(Constast.OK, "修改成功");
    /**
     * 修改操作失败提示消息
     */
    public static final ResultObj UPDATE_ERROR = new ResultObj(Constast.ERROR, "修改失败");
    /**
     * 添加操作成功提示消息
     */
    public static final ResultObj ADD_SUCCESS = new ResultObj(Constast.OK, "添加成功");
    /**
     * 添加操作失败提示消息
     */
    public static final ResultObj ADD_ERROR = new ResultObj(Constast.ERROR, "添加失败");
    /**
     * 重置操作成功提示消息
     */
    public static final ResultObj RESET_SUCCESS = new ResultObj(Constast.OK, "重置成功");
    /**
     * 重置操作失败提示消息
     */
    public static final ResultObj RESET_ERROR = new ResultObj(Constast.ERROR, "重置失败");
    /**
     * 分配权限或角色操作成功提示消息
     */
    public static final ResultObj DISPATCH_SUCCESS = new ResultObj(Constast.OK, "分配成功");
    /**
     * 分配权限或角色操作失败提示消息
     */
    public static final ResultObj DISPATCH_ERROR = new ResultObj(Constast.ERROR, "分配失败");
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 信息
     */
    private String msg;

}
