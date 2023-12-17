package com.example.wallpaper.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.wallpaper.common.Result;
import com.example.wallpaper.entity.User;
import com.example.wallpaper.entity.Vwallpaper;
import com.example.wallpaper.service.VwallpaperService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

    @Autowired
    private VwallpaperService vwallpaperService;


    @PostMapping(value = "/upload",consumes = "multipart/form-data")
    public Result upload(@RequestPart MultipartFile file, @ModelAttribute Vwallpaper vwallpaper){

        System.out.println(file);

        System.out.println(vwallpaper);


        if( vwallpaper==null){
            return Result.fail("壁纸为空");
        }

//        String str=vwallpaper.getName();
//
//        System.out.println(vwallpaper.getName());
//        if(Objects.equals(vwallpaper.getName(), "null")){
//            System.out.println("null");
//        }

        if( vwallpaper.getType()==null ||
            vwallpaper.getName()==null ||
            vwallpaper.getPrice()==null ||
            vwallpaper.getCreateId()==null ){


            System.out.println("壁纸信息不全");
            return Result.fail("壁纸信息不全");
        }


        //------------将file重命名并保存在本地文件----------------
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
        //------------将file重命名并保存在本地文件----------------



        //------------生成唯一vwp_id----------------

        // 生成一个36位的随机字符串
        String uuid = UUID.randomUUID().toString();
        // 截取其中的20位，从第6位开始
        String randomString = uuid.substring(6, 20);

        boolean isDuplicate = true;
        while (isDuplicate) {
            Vwallpaper TempVwallpaper = vwallpaperService.getById(randomString);
            if (TempVwallpaper == null) {
                isDuplicate = false;
            } else {
                isDuplicate = true;

                uuid = UUID.randomUUID().toString();
                randomString = uuid.substring(6, 26);
            }
        }

        //------------生成唯一vwp_id----------------


        vwallpaper.setPath(basePath+fileName);
        vwallpaper.setVwpId(randomString);

        vwallpaperService.save(vwallpaper);


        return Result.suc(vwallpaper);
    }


    @GetMapping("/ShowPicture")
    public void ShowPicture(String filepath, HttpServletResponse response){

        try {
            //输入流,通过输入流读取文件内容
            FileInputStream fileInputStream = new FileInputStream(new File(filepath));
            //输出流,通过输出流将文件返回给浏览器,在浏览器中展示图片
            ServletOutputStream outputStream = response.getOutputStream();
            response.setContentType("image/jpeg");

            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = fileInputStream.read(bytes)) != -1){
                outputStream.write(bytes,0,len);
                outputStream.flush();
            }
            //关闭资源
            outputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @PostMapping("/getImagesByTypeAndName")
    public Result getImagesByTypeAndName(@RequestBody Vwallpaper vwallpaper) {

        LambdaQueryWrapper<Vwallpaper> lambdaQueryWrapper=new LambdaQueryWrapper();

        lambdaQueryWrapper.like(Vwallpaper::getType,vwallpaper.getType())
                .like(Vwallpaper::getName,vwallpaper.getName());

        return Result.suc(vwallpaperService.list(lambdaQueryWrapper));
    }

    @PostMapping("/getImagesByCreateId")
    public Result getImagesByCreateId(@RequestBody Vwallpaper vwallpaper) {

        LambdaQueryWrapper<Vwallpaper> lambdaQueryWrapper=new LambdaQueryWrapper();

        lambdaQueryWrapper.eq(Vwallpaper::getCreateId,vwallpaper.getCreateId());

        return Result.suc(vwallpaperService.list(lambdaQueryWrapper));
    }


    @PostMapping("/getImagesByVwpid")
    public Result getImageInfo(@RequestBody Vwallpaper vwallpaper) {

        LambdaQueryWrapper<Vwallpaper> lambdaQueryWrapper=new LambdaQueryWrapper();

        lambdaQueryWrapper.eq(Vwallpaper::getVwpId,vwallpaper.getVwpId());

        return Result.suc(vwallpaperService.list(lambdaQueryWrapper));
    }


}
