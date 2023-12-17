package com.example.wallpaper.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author wallpaper
 * @since 2023-12-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Vwporder对象", description="")
public class Vwporder implements Serializable {

    private static final long serialVersionUID = 1L;



    @ApiModelProperty(value = "壁纸标识")
    private String vwpId;

    @TableId(value = "order_id",type = IdType.NONE)
    @ApiModelProperty(value = "订单单号")
    private String orderId;

    @ApiModelProperty(value = "买家账号")
    private String buyerId;


}
