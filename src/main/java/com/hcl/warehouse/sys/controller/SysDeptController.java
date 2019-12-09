package com.hcl.warehouse.sys.controller;


import cn.hutool.core.collection.CollUtil;
import com.hcl.warehouse.sys.common.DateGridView;
import com.hcl.warehouse.sys.common.TreeNode;
import com.hcl.warehouse.sys.entity.SysDept;
import com.hcl.warehouse.sys.service.ISysDeptService;
import com.hcl.warehouse.sys.vo.DeptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
    public DateGridView loadDeptManagerLeftTreeJson(DeptVo deptVo){
        List<SysDept> list = this.deptService.list();
        List<TreeNode> treeNodes =  new ArrayList<>();
        if (CollUtil.isNotEmpty(list)){
            list.forEach(t -> treeNodes.add(new TreeNode(t.getId(), t.getPid(), t.getTitle(), t.getOpen() == 1)));
            return new DateGridView(treeNodes);
        }
        return new DateGridView();
    }
    @Autowired
    private ISysDeptService deptService;
}

