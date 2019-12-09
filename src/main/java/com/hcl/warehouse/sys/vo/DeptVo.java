package com.hcl.warehouse.sys.vo;

import cn.hutool.core.date.DatePattern;
import com.hcl.warehouse.sys.entity.SysDept;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author :liangHuang.
 * @Date :2019/12/5 16:50
 * @Description :登陆相关vo
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DeptVo extends SysDept {
    /**
     * 当前页
     */
    private Integer page = 1;
    /**
     * 条数
     */
    private Integer limit = 10;

}
