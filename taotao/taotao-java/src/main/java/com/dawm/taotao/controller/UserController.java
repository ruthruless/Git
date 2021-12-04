package com.dawm.taotao.controller;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dawm.taotao.common.dto.LoginDto;
import com.dawm.taotao.common.lang.Result;
import com.dawm.taotao.entity.User;
import com.dawm.taotao.service.UserService;
import com.dawm.taotao.util.JwtUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    JwtUtil jwtUtils;

    @PostMapping("/login")
    public Result login( @RequestBody LoginDto loginDto, HttpServletResponse response){
        /**
         * new QueryWrapper<User>()查询对象
         * eq类似于where
         */
        System.out.println(loginDto);
        User user = userService.getOne(new QueryWrapper<User>().eq("username",loginDto.getUsername()));

        Assert.notNull(user,"用户不存在");

        if(!user.getPassword().equals(SecureUtil.md5(loginDto.getPassword()))){
            return Result.fail("密码不正确");
        }
        String jwt =jwtUtils.generateToken(user.getId());

        response.setHeader("Authorization",jwt);
        response.setHeader("Access-control-Expose-Headers","Authorization");

        return Result.succ(MapUtil.builder()
                .put("id", user.getId())
                .put("username", user.getUsername())
//                .put("avatar", user.getAvatar())
//                .put("email", user.getEmail())
                .map()
        );
    }

    @RequiresAuthentication
    @GetMapping("/logout")
    public Result logout() {
        SecurityUtils.getSubject().logout();
        return Result.succ(null);
    }
}
