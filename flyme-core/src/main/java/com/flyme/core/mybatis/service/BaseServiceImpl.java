package com.flyme.core.mybatis.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.flyme.core.mybatis.base.SuperMapper;

import java.util.List;

public class BaseServiceImpl<M extends SuperMapper<T>, T> extends ServiceImpl<M, T> implements IBaseService<T> {
    @Override
    public Page<?> pageList(Page<?> page, Wrapper<T> wrapper) {
        List mapList = this.baseMapper.pageList(page, wrapper);
        page.setRecords(mapList);
        return page;
    }
}
