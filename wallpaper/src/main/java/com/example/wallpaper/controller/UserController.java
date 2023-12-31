package com.example.wallpaper.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.wallpaper.common.Result;
import com.example.wallpaper.entity.User;
import com.example.wallpaper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wallpaper
 * @since 2023-12-10
 */
@RestController
@RequestMapping("/user")
public class UserController {



    @Autowired
    private UserService userService;


    //返回用户列表
    @GetMapping("/list")
    public List<User> list(){
        return userService.list();
    }

    //新增
    @PostMapping("/save")
    public boolean save(@RequestBody User user){
        return userService.save(user);
    }

    //修改
    @PostMapping("/mod")
    public boolean mod(@RequestBody User user){
        return  userService.updateById(user);
    }

    //新增或修改
    @PostMapping("/saveOrMod")
    public boolean saveorMod(@RequestBody User user){
        return  userService.saveOrUpdate(user);
    }

    //删除
    @GetMapping("/delete")
    public boolean delete(Integer id){
        return userService.removeById(id);
    }

    //查询


    @PostMapping("/login")
    public Result login(@RequestBody User user){

        System.out.println(user);

        List<User> list= userService.lambdaQuery()
                .eq(User::getUserId,user.getUserId()).
                eq(User::getPassword,user.getPassword()).list();
        if(list.size()!=1){
            return Result.fail();
        }else {
            User loginUser = list.get(0);
            return Result.suc(loginUser,null);
        }
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user){

        List<User> list= userService.lambdaQuery()
                .eq(User::getUserId,user.getUserId())
                .list();


        if (user.getName()==null|user.getUserId()==null|user.getPassword()==null) {
            return Result.fail("信息不齐全");
        } else if(list.size()!=0){
            return Result.fail("抱歉你的账号已经注册过了");
        }else{

            //用户注册,写入数据库
            user.setBalance(0);
            userService.save(user);

            return Result.suc(user,null);
        }
    }

    @PostMapping("/TopUp")
    public Result TopUp(@RequestBody User user){
        if(user.getBalance()<=userService.getById(user.getUserId()).getBalance()){
            return Result.fail("充值金额错误");
        }

        User TempUser=userService.getById(user);
        TempUser.setBalance(user.getBalance());

        userService.updateById(TempUser);
        return Result.suc(TempUser);
    }

}
