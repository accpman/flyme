package com.flyme.core.mybatis.base;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.flyme.common.base.EntityMap;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SuperMapper<T> extends BaseMapper<T> {
    List<?> pageList(Page page, @Param("ew") Wrapper<T> wrapper);
}
