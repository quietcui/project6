package com.example.wallpaper.service.impl;

import com.example.wallpaper.entity.User;
import com.example.wallpaper.mapper.UserMapper;
import com.example.wallpaper.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wallpaper
 * @since 2023-12-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
