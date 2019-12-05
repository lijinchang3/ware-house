package com.hcl.warehouse.sys.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hcl.warehouse.sys.common.DateGridView;
import com.hcl.warehouse.sys.entity.SysLoginfo;
import com.hcl.warehouse.sys.service.ISysLoginfoService;
import com.hcl.warehouse.sys.vo.LoginfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liangHuang
 * @since 2019-12-05
 */
@RestController
@RequestMapping("/loginfo/")
public class SysLoginfoController {

    /**
     * 查询所有的loginfo
     * @param loginfoVo
     * @return
     */
    @RequestMapping(value = "loadAllLoginfo")
    public DateGridView loadAllLoginfo(LoginfoVo loginfoVo){
        IPage<SysLoginfo> page = new Page<>(loginfoVo.getPage(), loginfoVo.getLimit());
        QueryWrapper<SysLoginfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StrUtil.isNotBlank(loginfoVo.getLoginname()), "loginname", loginfoVo.getLoginname());
        queryWrapper.like(StrUtil.isNotBlank(loginfoVo.getLoginip()), "loginip", loginfoVo.getLoginip());
        queryWrapper.ge(loginfoVo.getStartTime() != null, "logintime", loginfoVo.getStartTime());
        queryWrapper.le(loginfoVo.getStartTime() != null, "logintime", loginfoVo.getStartTime());
        this.loginfoService.page(page, queryWrapper);
        return new DateGridView(page.getTotal(), page.getRecords());
    }

    @Autowired
    private ISysLoginfoService loginfoService;

}

