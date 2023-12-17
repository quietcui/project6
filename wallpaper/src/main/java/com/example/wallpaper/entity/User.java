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
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id",type = IdType.NONE)
    @ApiModelProperty(value = "账号")
    private String userId;

    @ApiModelProperty(value = "名字")
    private String name;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "余额")
    private Integer balance;


}
