package com.example.wallpaper.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.wallpaper.common.Result;
import com.example.wallpaper.entity.Mycollect;
import com.example.wallpaper.entity.Vwallpaper;
import com.example.wallpaper.entity.Vwpdownload;
import com.example.wallpaper.entity.Vwporder;
import com.example.wallpaper.service.MycollectService;
import com.example.wallpaper.service.VwallpaperService;
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
 * @since 2023-12-31
 */
@RestController
@RequestMapping("/mycollect")
public class MycollectController {

    @Autowired
    private VwallpaperService vwallpaperService;

    @Autowired
    private MycollectService mycollectService;


    @PostMapping("/doCollect")
    public Result doCollect(@RequestBody Mycollect mycollect) {

        if (mycollect.getUserId() == null ||
                mycollect.getVwpId() == null ||
                mycollect.getUserId().equals("null") ||
                mycollect.getVwpId().equals("null")  ||
                mycollect.getUserId().equals("") ||
                mycollect.getVwpId().equals("") ) {
            return Result.fail("信息不全");
        }


        LambdaQueryWrapper<Mycollect> lambdaQueryWrapper=new LambdaQueryWrapper();
        lambdaQueryWrapper  .eq(Mycollect::getUserId,mycollect.getUserId())
                .eq(Mycollect::getVwpId,mycollect.getVwpId());
        List<Mycollect> mycollects=mycollectService.list(lambdaQueryWrapper);


        if(mycollects.size()==0){
            mycollectService.save(mycollect);
            return Result.suc("成功收藏");
        }else{
            mycollectService.remove(lambdaQueryWrapper);
            return Result.suc("取消收藏");
        }


    }


    @PostMapping("/queryCollect")
    public Result queryCollect(@RequestBody Mycollect mycollect) {

        if (mycollect.getUserId() == null ||
                mycollect.getVwpId() == null ||
                mycollect.getUserId().equals("null") ||
                mycollect.getVwpId().equals("null")  ||
                mycollect.getUserId().equals("") ||
                mycollect.getVwpId().equals("") ) {
            return Result.fail("信息不全");
        }


        LambdaQueryWrapper<Mycollect> lambdaQueryWrapper=new LambdaQueryWrapper();
        lambdaQueryWrapper  .eq(Mycollect::getUserId,mycollect.getUserId())
                .eq(Mycollect::getVwpId,mycollect.getVwpId());
        List<Mycollect> mycollects=mycollectService.list(lambdaQueryWrapper);


        if(mycollects.size()==0){
            return Result.suc("尚未收藏");
        }else{
            return Result.suc("已经收藏");
        }
    }


    @PostMapping("/collect")
    public Result Collect(@RequestBody Mycollect mycollect) {

        LambdaQueryWrapper<Mycollect> lambdaQueryWrapper=new LambdaQueryWrapper();

        lambdaQueryWrapper.eq(Mycollect::getUserId,mycollect.getUserId());

        List<Mycollect> mycollects=mycollectService.list(lambdaQueryWrapper);
        List<Vwallpaper> vwallpapers = new ArrayList<>();

        String TempVwpId;
        Vwallpaper Tempvwallpaper;

        for(int i=0;i<mycollects.size();i++){
            TempVwpId=mycollects.get(i).getVwpId();
            Tempvwallpaper=vwallpaperService.getById(TempVwpId);
            vwallpapers.add(Tempvwallpaper);
        }


        return Result.suc(vwallpapers);
    }
}