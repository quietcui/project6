package com.example.wallpaper.mapper;

import com.example.wallpaper.entity.Vwporder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wallpaper
 * @since 2023-12-10
 */
@Mapper
public interface VwporderMapper extends BaseMapper<Vwporder> {

}
