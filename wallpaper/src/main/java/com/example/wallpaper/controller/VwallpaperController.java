package com.example.wallpaper.controller;


import com.example.wallpaper.common.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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
@RequestMapping("/vwallpaper")
public class VwallpaperController {

    //本地壁纸文件夹地址
    @Value("${images.path}")
    private String basePath;


    @PostMapping("/upload")
    public Result upload(MultipartFile file){

        System.out.println("你好啊");
        System.out.println(file);

        //原始文件名
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

        //使用UUID重新生成一个文件名,防止文件名重复造成文件覆盖
        String fileName = UUID.randomUUID().toString() + suffix;

        //创建一个目录
        File dir = new File(basePath);
        //判断当前目录是否存在
        if(!dir.exists()){
            //如果目录不存在就直接创建
            dir.mkdirs();
        }
        try {
            //将临时文件转存到执行位置
            file.transferTo(new File(basePath+fileName));
        }catch (IOException e){
            System.out.println("出错了");
            e.printStackTrace();
        }

        return Result.suc(fileName);
    }


//    @PostMapping("/upload")
//    public Result upload(@RequestParam("file") MultipartFile file, @RequestParam("info") String info){
//
//        System.out.println("你好啊");
//        System.out.println(file);
//        System.out.println(info); //打印出前端发送的信息
//
//        //原始文件名
//        String originalFilename = file.getOriginalFilename();
//        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
//
//        //使用UUID重新生成一个文件名,防止文件名重复造成文件覆盖
//        String fileName = UUID.randomUUID().toString() + suffix;
//
//        //创建一个目录
//        File dir = new File(basePath);
//        //判断当前目录是否存在
//        if(!dir.exists()){
//            //如果目录不存在就直接创建
//            dir.mkdirs();
//        }
//        try {
//            //将临时文件转存到执行位置
//            file.transferTo(new File(basePath+fileName));
//        }catch (IOException e){
//            System.out.println("出错了");
//            e.printStackTrace();
//        }
//
//        return Result.suc(fileName);
//    }


}
