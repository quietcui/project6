package com.example.wallpaper.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.wallpaper.common.Result;
import com.example.wallpaper.entity.*;
import com.example.wallpaper.service.VwallpaperService;
import com.example.wallpaper.service.VwpdownloadService;
import com.example.wallpaper.service.VwporderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wallpaper
 * @since 2023-12-17
 */
@RestController
@RequestMapping("/vwpdownload")
public class VwpdownloadController {

    @Autowired
    private VwpdownloadService vwpdownloadService;

    @Autowired
    private VwporderService vwporderService;

    @Autowired
    private VwallpaperService vwallpaperService;

    @PostMapping("/download")
    public Result download(@RequestBody Vwpdownload vwpdownload) {

        if (vwpdownload.getUserId() == null ||
                vwpdownload.getVwpId() == null ||
                vwpdownload.getUserId().equals("null") ||
                vwpdownload.getVwpId().equals("null")    ) {
            return Result.fail("信息不全");
        }

        if(vwallpaperService.getById(vwpdownload.getVwpId()).getPrice()!=0){

            LambdaQueryWrapper<Vwporder> lambdaQueryWrapper=new LambdaQueryWrapper();
            lambdaQueryWrapper  .eq(Vwporder::getBuyerId,vwpdownload.getUserId())
                    .eq(Vwporder::getVwpId,vwpdownload.getVwpId());
            List<Vwporder> vwporders=vwporderService.list(lambdaQueryWrapper);

            if(vwporders.size()==0){
                return Result.fail("你还没购买过该壁纸");
            }

        }


        LambdaQueryWrapper<Vwpdownload> lambdaQueryWrapper=new LambdaQueryWrapper();
        lambdaQueryWrapper  .eq(Vwpdownload::getUserId,vwpdownload.getUserId())
                .eq(Vwpdownload::getVwpId,vwpdownload.getVwpId());
        List<Vwpdownload> vwpdownloads=vwpdownloadService.list(lambdaQueryWrapper);


        if(vwpdownloads.size()==0){
            vwpdownloadService.save(vwpdownload);
        }

        return Result.suc(vwpdownload);
    }


    //返回所有我已下载过的壁纸
    @PostMapping("/getDownloadedImages")
    public Result getDownloadedImages(@RequestBody User user){

        LambdaQueryWrapper<Vwpdownload> lambdaQueryWrapper=new LambdaQueryWrapper();

        lambdaQueryWrapper.eq(Vwpdownload::getUserId,user.getUserId());

        List<Vwpdownload> vwpdownloads=vwpdownloadService.list(lambdaQueryWrapper);
        List<Vwallpaper> vwallpapers = new ArrayList<>();

        String TempVwpId;
        Vwallpaper Tempvwallpaper;

        for(int i=0;i<vwpdownloads.size();i++){
            TempVwpId=vwpdownloads.get(i).getVwpId();
            Tempvwallpaper=vwallpaperService.getById(TempVwpId);
            vwallpapers.add(Tempvwallpaper);
        }


        return Result.suc(vwallpapers);
    }


}
