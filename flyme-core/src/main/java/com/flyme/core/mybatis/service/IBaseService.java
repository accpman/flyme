package com.flyme.core.mybatis.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.flyme.common.base.EntityMap;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface IBaseService<T> extends IService<T> {
    Page<?> pageList(Page<?> page, Wrapper<T> wrapper);

}
