package com.flyme.core.mybatis.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.flyme.core.mybatis.base.SuperMapper;
import com.flyme.core.mybatis.event.AfterQueryEvent;
import com.flyme.core.mybatis.event.BeforQueryEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class BaseServiceImpl<M extends SuperMapper<T>, T> extends ServiceImpl<M, T> implements IBaseService<T> {
    @Autowired
    ApplicationContext applicationContext;
    @Override
    public Page<?> pageList(Page<?> page, Wrapper<T> wrapper) {
        applicationContext.publishEvent(new BeforQueryEvent(this));
        List mapList = this.baseMapper.pageList(page, wrapper);
        page.setRecords(mapList);
        applicationContext.publishEvent(new AfterQueryEvent(this));

        return page;
    }
}
