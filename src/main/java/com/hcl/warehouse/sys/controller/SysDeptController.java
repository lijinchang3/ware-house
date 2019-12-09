package com.hcl.warehouse.sys.controller;


import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hcl.warehouse.sys.common.DataGridView;
import com.hcl.warehouse.sys.common.ResultObj;
import com.hcl.warehouse.sys.common.TreeNode;
import com.hcl.warehouse.sys.entity.SysDept;
import com.hcl.warehouse.sys.service.ISysDeptService;
import com.hcl.warehouse.sys.vo.DeptVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liangHuang
 * @since 2019-12-09
 */
@RestController
@RequestMapping("/dept/")
public class SysDeptController {
    /**
     * 加载部门管理左边树的json
     * @return
     */
    @RequestMapping(value = "loadDeptManagerLeftTreeJson")
    public DataGridView loadDeptManagerLeftTreeJson(DeptVo deptVo){
        List<SysDept> list = this.deptService.list();
        List<TreeNode> treeNodes =  new ArrayList<>();
        if (CollUtil.isNotEmpty(list)){
            list.forEach(t -> treeNodes.add(new TreeNode(t.getId(), t.getPid(), t.getTitle(), t.getOpen()==1)));
            return new DataGridView(treeNodes);
        }
        return new DataGridView();
    }
    /**
     * 查询
     */
    @RequestMapping("loadAllDept")
    public DataGridView loadAllDept(DeptVo deptVo) {
        IPage<SysDept> page=new Page<>(deptVo.getPage(), deptVo.getLimit());
        QueryWrapper<SysDept> queryWrapper=new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(deptVo.getTitle()), "title", deptVo.getTitle());
        queryWrapper.like(StringUtils.isNotBlank(deptVo.getAddress()), "address", deptVo.getAddress());
        queryWrapper.like(StringUtils.isNotBlank(deptVo.getRemark()), "remark", deptVo.getRemark());
        queryWrapper.eq(deptVo.getId()!=null, "id", deptVo.getId()).or().eq(deptVo.getId()!=null,"pid", deptVo.getId());
        queryWrapper.orderByAsc("ordernum");
        this.deptService.page(page, queryWrapper);
        return new DataGridView(page.getTotal(), page.getRecords());
    }
    /**
     * 加载最大的排序码
     * @return
     */
    @RequestMapping("loadDeptMaxOrderNum")
    public Map<String,Object> loadDeptMaxOrderNum(){
        Map<String, Object> map=new HashMap<String, Object>();
        QueryWrapper<SysDept> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByDesc("ordernum");
        IPage<SysDept> page=new Page<>(1, 1);
        List<SysDept> list = this.deptService.page(page, queryWrapper).getRecords();
        if(list.size()>0) {
            map.put("value", list.get(0).getOrdernum()+1);
        }else {
            map.put("value", 1);
        }
        return map;
    }

    /**
     * 添加
     * @param deptVo
     * @return
     */
    @RequestMapping("addDept")
    public ResultObj addDept(DeptVo deptVo) {
        try {
            deptVo.setCreatetime(new Date());
            this.deptService.save(deptVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }


    /**
     * 修改
     * @param deptVo
     * @return
     */
    @RequestMapping("updateDept")
    public ResultObj updateDept(DeptVo deptVo) {
        try {
            this.deptService.updateById(deptVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }


    /**
     * 查询当前的ID的部门有没有子部门
     */
    @RequestMapping("checkDeptHasChildrenNode")
    public Map<String,Object> checkDeptHasChildrenNode(DeptVo deptVo){
        Map<String, Object> map=new HashMap<String, Object>();

        QueryWrapper<SysDept> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("pid", deptVo.getId());
        List<SysDept> list = this.deptService.list(queryWrapper);
        if(list.size()>0) {
            map.put("value", true);
        }else {
            map.put("value", false);
        }
        return map;
    }

    /**
     * 删除
     * @param deptVo
     * @return
     */
    @RequestMapping("deleteDept")
    public ResultObj deleteDept(DeptVo deptVo) {
        try {
            this.deptService.removeById(deptVo.getId());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    @Autowired
    private ISysDeptService deptService;
}

