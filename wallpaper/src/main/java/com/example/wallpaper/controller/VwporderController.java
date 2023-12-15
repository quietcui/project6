package com.example.wallpaper.controller;


import com.example.wallpaper.common.Result;
import com.example.wallpaper.entity.User;
import com.example.wallpaper.entity.Vwporder;
import com.example.wallpaper.service.VwallpaperService;
import com.example.wallpaper.service.VwporderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wallpaper
 * @since 2023-12-10
 */
@RestController
@RequestMapping("/vwporder")
public class VwporderController {

    @Autowired
    private VwporderService vwporderService;

    @PostMapping("/download")
    public Result save(@RequestBody Vwporder vwporder){

        if(vwporder.getBuyerId()==null||vwporder.getVwpId()==null){
            return Result.fail("信息不全");
        }


        return null;
    }

}
