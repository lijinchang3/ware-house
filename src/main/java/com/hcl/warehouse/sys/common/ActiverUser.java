package com.hcl.warehouse.sys.common;

import com.hcl.warehouse.sys.entity.SysUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author :liangHuang.
 * @Date :2019/12/4 16:53
 * @Description :
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActiverUser {

    private SysUser user;

    private List<String> roles;

    private List<String> permissions;

}
