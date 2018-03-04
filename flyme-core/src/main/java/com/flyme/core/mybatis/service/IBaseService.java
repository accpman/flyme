package com.flyme.core.mybatis.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

/**
 * @author 张亚斐
 */
public interface IBaseService<T> extends IService<T> {
    Page<?> pageList(Page<?> page, Wrapper<T> wrapper);

}
