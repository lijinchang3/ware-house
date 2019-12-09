package com.hcl.warehouse.sys.controller;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hcl.warehouse.sys.common.DateGridView;
import com.hcl.warehouse.sys.common.ResultObj;
import com.hcl.warehouse.sys.common.WebUtils;
import com.hcl.warehouse.sys.entity.SysNotice;
import com.hcl.warehouse.sys.entity.SysUser;
import com.hcl.warehouse.sys.service.ISysNoticeService;
import com.hcl.warehouse.sys.vo.NoticeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liangHuang
 * @since 2019-12-06
 */
@RestController
@RequestMapping("/notice/")
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

    /**
     * 添加公告
     * @param noticeVo
     * @return
     */
    @RequestMapping(value = "addNotice")
    public ResultObj addNotice(NoticeVo noticeVo){
        try {
            noticeVo.setCreatetime(new Date());
            SysUser user = (SysUser)WebUtils.getSession().getAttribute("user");
            noticeVo.setOpername(user.getName());
            this.noticeService.saveOrUpdate(noticeVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 修改公告
     * @return
     */
    @RequestMapping(value = "updateNotice")
    public ResultObj updateNotice(NoticeVo noticeVo){
        try {
            this.noticeService.updateById(noticeVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 删除公告
     * @return
     */
    @RequestMapping(value = "deleteNotice")
    public ResultObj deleteNotice(Integer id){
        try {
            this.noticeService.removeById(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 批量删除公告
     * @return
     */
    @RequestMapping(value = "batchDeleteNotice")
    public ResultObj batchDeleteNotice(NoticeVo noticeVo){
        try {
            this.noticeService.removeByIds(CollUtil.toList(noticeVo.getIds()));
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            return ResultObj.DELETE_ERROR;
        }
    }

    @Autowired
    private ISysNoticeService noticeService;

}

