package com.hcl.warehouse.sys.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hcl.warehouse.sys.common.DateGridView;
import com.hcl.warehouse.sys.entity.SysNotice;
import com.hcl.warehouse.sys.service.ISysNoticeService;
import com.hcl.warehouse.sys.vo.NoticeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liangHuang
 * @since 2019-12-06
 */
@Controller
@RequestMapping("/sysNotice/")
public class SysNoticeController {

    /**
     * 查询公告
     * @param noticeVo
     * @return
     */
    @RequestMapping(value = "loadAllNotice")
    public DateGridView loadAllNotice(NoticeVo noticeVo){
        IPage<SysNotice> page = new Page<>(noticeVo.getPage(), noticeVo.getLimit());
        QueryWrapper<SysNotice> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StrUtil.isNotBlank(noticeVo.getTitle()), "title", noticeVo.getTitle());
        queryWrapper.like(StrUtil.isNotBlank(noticeVo.getOpername()), "opername", noticeVo.getOpername());
        queryWrapper.ge(noticeVo.getStartTime() != null, "createtime", noticeVo.getStartTime());
        queryWrapper.le(noticeVo.getEndTime() != null, "createtime", noticeVo.getEndTime());
        queryWrapper.orderByDesc("createtime");
        this.noticeService.page(page, queryWrapper);
        return new DateGridView(page.getTotal(), page.getRecords());
    }

    @Autowired
    private ISysNoticeService noticeService;

}

