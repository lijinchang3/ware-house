package com.hcl.warehouse.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hcl.warehouse.sys.common.*;
import com.hcl.warehouse.sys.entity.SysPermission;
import com.hcl.warehouse.sys.entity.SysUser;
import com.hcl.warehouse.sys.service.ISysPermissionService;
import com.hcl.warehouse.sys.vo.PermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author :liangHuang.
 * @Date :2019/12/5 14:35
 * @Description :菜单相关控制器
 */
@RestController
@RequestMapping("menu/")
public class MenuController {

    /**
     * 左边菜单控制
     * @param permissionVo
     * @return
     */
    @RequestMapping(value = "loadIndexLeftMenuJson")
    public DataGridView loadIndexLeftMenuJson(PermissionVo permissionVo){
        //查询所有菜单
        QueryWrapper<SysPermission> permissionQueryWrapper = new QueryWrapper<>();
        permissionQueryWrapper.eq("type", Constast.TYPE_MENU);
        permissionQueryWrapper.eq("available", Constast.AVAILABLE_TRUE);
        SysUser user = (SysUser)WebUtils.getSession().getAttribute("user");
        List<SysPermission> permissionList = null;
        //超级用户
        if (user.getType().equals(Constast.USER_TYPE_SUPER)){
            permissionList = permissionService.list(permissionQueryWrapper);
        }else {
            //普通用户根据用户ID+角色+权限查询
            // TODO: 2019/12/5 角色权限设计完毕后需要修改 
            permissionList = permissionService.list(permissionQueryWrapper);
        }
        List<TreeNode> treeNodes=new ArrayList<>();
        for (SysPermission p : permissionList) {
            Integer id = p.getId();
            Integer pid = p.getPid();
            String title = p.getTitle();
            String icon = p.getIcon();
            String href = p.getHref();
            Boolean spread = p.getOpen().equals(Constast.OPEN_TRUE) ? true : false;
            treeNodes.add(new TreeNode(id, pid, title, icon, href, spread));
        }
        //构造层级关系
        List<TreeNode> list2 = TreeNodeBuilder.build(treeNodes, 1);
        return new DataGridView(list2);
    }

    @Autowired
    private ISysPermissionService permissionService;
}
