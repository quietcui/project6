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
@ApiModel(value="Vwallpaper对象", description="")
public class Vwallpaper implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "vwp_id",type = IdType.NONE)
    @ApiModelProperty(value = "壁纸标识")
    private String vwpId;

    @ApiModelProperty(value = "壁纸名称")
    private String name;

    @ApiModelProperty(value = "创作者id")
    private String createId;

    @ApiModelProperty(value = "价格")
    private Integer price;

    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "路径")
    private String path;


}
