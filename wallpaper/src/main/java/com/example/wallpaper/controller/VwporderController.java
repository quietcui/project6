package com.example.wallpaper.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.wallpaper.common.Result;
import com.example.wallpaper.entity.User;
import com.example.wallpaper.entity.Vwallpaper;
import com.example.wallpaper.entity.Vwporder;
import com.example.wallpaper.mapper.UserMapper;
import com.example.wallpaper.service.UserService;
import com.example.wallpaper.service.VwallpaperService;
import com.example.wallpaper.service.VwporderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
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
@RequestMapping("/vwporder")
public class VwporderController {


    //---------------temp-----------------------
    @Autowired
    private UserService userService;

    @Autowired
    private VwallpaperService vwallpaperService;
    //---------------temp-----------------------



    @Autowired
    private VwporderService vwporderService;

    @PostMapping("/purchaseImage")
    public Result purchaseImage(@RequestBody Vwporder vwporder){

        if( vwporder.getBuyerId()==null ||
            vwporder.getVwpId()==null ||
            vwporder.getBuyerId().equals("null") ||
            vwporder.getVwpId().equals("null")){

            return Result.fail("信息不全");
        }

        //--------------------------生成唯一orderId----------------------------

        // 生成一个36位的随机字符串
        String uuid = UUID.randomUUID().toString();
        // 截取其中的20位，从第6位开始
        String randomString = uuid.substring(6, 20);

        boolean isDuplicate = true;
        while (isDuplicate) {
            Vwporder TempVwporder = vwporderService.getById(randomString);
            if (TempVwporder == null) {
                isDuplicate = false;
            } else {
                isDuplicate = true;

                uuid = UUID.randomUUID().toString();
                randomString = uuid.substring(6, 26);
            }
        }
        //--------------------------生成唯一orderId----------------------------




        //------------temp-----------------------
        User TempBuyer=userService.getById(vwporder.getBuyerId());

        Vwallpaper TempVwallpaper=vwallpaperService.getById(vwporder.getVwpId());
        User TempCreater=userService.getById(TempVwallpaper.getCreateId());


        int TempBuyerBalance=TempBuyer.getBalance();
        int TempVwpPrice=TempVwallpaper.getPrice();
        int TempCreaterBalance=TempCreater.getBalance();


        if(TempVwpPrice==0){
            return Result.fail("不需要购买!");
        }
        if(TempBuyerBalance<TempVwpPrice){
            return Result.fail("余额不足");
        }
        if(TempBuyer.getUserId().equals(TempCreater.getUserId())){
            return Result.fail("不能购买自己上传的壁纸");
        }


        LambdaQueryWrapper<Vwporder> lambdaQueryWrapper=new LambdaQueryWrapper();
        lambdaQueryWrapper  .eq(Vwporder::getBuyerId,vwporder.getBuyerId())
                .eq(Vwporder::getVwpId,vwporder.getVwpId());
        List<Vwporder> vwporders=vwporderService.list(lambdaQueryWrapper);
        if(vwporders.size()>=1){
            return Result.fail("你已购买过该壁纸");
        }

        TempBuyer.setBalance(TempBuyerBalance-TempVwpPrice);
        userService.updateById(TempBuyer);
        TempCreater.setBalance(TempCreaterBalance+TempVwpPrice);
        userService.updateById(TempCreater);

        vwporder.setOrderId(randomString);
        vwporderService.save(vwporder);

        //------------temp-----------------------


        HashMap<String, Object> response = new HashMap<>();

        response.put("data", vwporder);
        response.put("balance", TempBuyerBalance-TempVwpPrice);


        return Result.suc(response);
    }



    //返回所有我已购买的壁纸信息列表
    @PostMapping("/getPurchasedImages")
    public Result getPurchasedImages(@RequestBody User user) {

        LambdaQueryWrapper<Vwporder> lambdaQueryWrapper=new LambdaQueryWrapper();

        lambdaQueryWrapper.eq(Vwporder::getBuyerId,user.getUserId());

        List<Vwporder> vwporders=vwporderService.list(lambdaQueryWrapper);
        List<Vwallpaper> vwallpapers = new ArrayList<>();

        String TempVwpId;
        Vwallpaper Tempvwallpaper;

        for(int i=0;i<vwporders.size();i++){
            TempVwpId=vwporders.get(i).getVwpId();
            Tempvwallpaper=vwallpaperService.getById(TempVwpId);
            vwallpapers.add(Tempvwallpaper);
        }


        return Result.suc(vwallpapers);
    }

}
