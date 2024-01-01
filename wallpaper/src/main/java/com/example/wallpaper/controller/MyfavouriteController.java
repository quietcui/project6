package com.example.wallpaper.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.wallpaper.common.Result;
import com.example.wallpaper.entity.Mycollect;
import com.example.wallpaper.entity.Myfavourite;
import com.example.wallpaper.entity.Vwallpaper;
import com.example.wallpaper.service.MycollectService;
import com.example.wallpaper.service.MyfavouriteService;
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
@RequestMapping("/myfavourite")
public class MyfavouriteController {

    @Autowired
    private VwallpaperService vwallpaperService;

    @Autowired
    private MyfavouriteService myfavouriteService;


    @PostMapping("/doFavourite")
    public Result download(@RequestBody Myfavourite myfavourite) {

        if (myfavourite.getUserId() == null ||
                myfavourite.getVwpId() == null ||
                myfavourite.getUserId().equals("null") ||
                myfavourite.getVwpId().equals("null") ||
                myfavourite.getUserId().equals("") ||
                myfavourite.getVwpId().equals("")   ) {
            return Result.fail("信息不全");
        }



        LambdaQueryWrapper<Myfavourite> lambdaQueryWrapper=new LambdaQueryWrapper();
        lambdaQueryWrapper  .eq(Myfavourite::getUserId,myfavourite.getUserId())
                .eq(Myfavourite::getVwpId,myfavourite.getVwpId());
        List<Myfavourite> myfavourites=myfavouriteService.list(lambdaQueryWrapper);


        if(myfavourites.size()==0){
            myfavouriteService.save(myfavourite);
        }else{
            return Result.fail("你已经点赞过该壁纸");
        }

        return Result.suc(myfavourite);
    }

    @PostMapping("/favourite")
    public Result Collect(@RequestBody Myfavourite myfavourite) {

        LambdaQueryWrapper<Myfavourite> lambdaQueryWrapper=new LambdaQueryWrapper();

        lambdaQueryWrapper.eq(Myfavourite::getUserId,myfavourite.getUserId());

        List<Myfavourite> myfavourites=myfavouriteService.list(lambdaQueryWrapper);
        List<Vwallpaper> vwallpapers = new ArrayList<>();

        String TempVwpId;
        Vwallpaper Tempvwallpaper;

        for(int i=0;i<myfavourites.size();i++){
            TempVwpId=myfavourites.get(i).getVwpId();
            Tempvwallpaper=vwallpaperService.getById(TempVwpId);
            vwallpapers.add(Tempvwallpaper);
        }


        return Result.suc(vwallpapers);
    }
}
