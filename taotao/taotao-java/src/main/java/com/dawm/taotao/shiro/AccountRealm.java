package com.dawm.taotao.shiro;

import cn.hutool.core.bean.BeanUtil;
import com.dawm.taotao.entity.User;
import com.dawm.taotao.service.UserService;
import com.dawm.taotao.util.JwtUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountRealm extends AuthorizingRealm {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    UserService userService;

    @Override
    public boolean supports(AuthenticationToken token){
//        return super.supports(token);
        return token instanceof com.dawm.taotao.shiro.JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        com.dawm.taotao.shiro.JwtToken jwtToken = (com.dawm.taotao.shiro.JwtToken) token;

        String userId = jwtUtil.getClaimByToken((String) jwtToken.getPrincipal()).getSubject();

        User user = userService.getById(Long.valueOf(userId));

        if (user == null){
            throw new UnknownAccountException("账户不存在");
        }

//        if (user.getStatus()== -1){
//            throw new LockedAccountException("账户已被锁定");
//        }

        AccountProfile profile = new AccountProfile();

        BeanUtil.copyProperties(user,profile);

        System.out.println("------");

        return new SimpleAuthenticationInfo(profile,jwtToken.getCredentials(),getName());
    }
}
