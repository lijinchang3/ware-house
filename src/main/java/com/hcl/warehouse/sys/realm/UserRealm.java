package com.hcl.warehouse.sys.realm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hcl.warehouse.sys.common.ActiverUser;
import com.hcl.warehouse.sys.entity.SysUser;
import com.hcl.warehouse.sys.service.ISysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author :liangHuang.
 * @Date :2019/12/4 16:56
 * @Description :
 */
public class UserRealm extends AuthorizingRealm {
    /**
     * 授权方法
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证方法
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //根据用户名查询数据库得到用户
        SysUser sysUser = userService.getOne(new QueryWrapper<SysUser>().eq("loginname", authenticationToken.getPrincipal().toString()));
        if (sysUser != null){
            //user封装权限相关
            ActiverUser activerUser = new ActiverUser();
            activerUser.setUser(sysUser);
            ByteSource bytes = ByteSource.Util.bytes(sysUser.getSalt());
            //返回认证信息
            return new SimpleAuthenticationInfo(activerUser, sysUser.getPwd(), bytes, this.getName());
        }
        return null;
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Autowired
    private ISysUserService userService;

}
