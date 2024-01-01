package com.example.wallpaper.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2023-12-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Myfavourite对象", description="")
public class Myfavourite implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId // 指定一个主键
    @ApiModelProperty(value = "壁纸标识")
    private String vwpId;

    @TableField
    @ApiModelProperty(value = "创作者id")
    private String userId;


}
