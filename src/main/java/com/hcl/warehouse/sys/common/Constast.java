package com.hcl.warehouse.sys.common;

/**
 * @Author :liangHuang.
 * @Date :2019/12/5 11:33
 * @Description : 状态码相关静态常量
 */
public class Constast {
    /**
     * 状态码
     */
    public static final Integer OK = 200;
    /**
     * 错误状态码
     */
    public static final Integer ERROR = -1;
    /**
     * 菜单权限类型
     */
    public static final String TYPE_MENU  = "menu";
    /**
     * 权限
     */
    public static final String TYPE_PERMISSION  = "permission";
    /**
     * 可用状态 可用
     */
    public static final Object AVAILABLE_TRUE  = "1";
    /**
     * 可用状态 不可用
     */
    public static final Object AVAILABLE_FALSE  = "0";
    /**
     * 用户类型 超级用户
     */
    public static final Integer USER_TYPE_SUPER = 0 ;
    /**
     * 用户类型 普通用户
     */
    public static final Integer USER_TYPE_NORMAL = 1;
    /**
     * 展开类型 展开
     */
    public static final Integer OPEN_TRUE = 1;
    /**
     * 展开类型 关闭
     */
    public static final Integer OPEN_FALSE = 0;
}
