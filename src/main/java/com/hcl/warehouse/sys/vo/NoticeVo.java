package com.hcl.warehouse.sys.vo;

import cn.hutool.core.date.DatePattern;
import com.hcl.warehouse.sys.entity.SysNotice;
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
public class NoticeVo extends SysNotice {
    /**
     * 当前页
     */
    private Integer page = 1;
    /**
     * 条数
     */
    private Integer limit = 10;
    /**
     * 批量删除的主键id数组
     */
    private Integer[] ids;
    /**
     * 开始时间
     */
    @DateTimeFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
    private Date startTime;
    /**
     * 结束时间
     */
    @DateTimeFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
    private Date endTime;

}
