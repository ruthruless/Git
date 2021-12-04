package com.dawm.taotao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dawm.taotao.entity.User;
import com.dawm.taotao.mapper.UserMapper;
import com.dawm.taotao.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
