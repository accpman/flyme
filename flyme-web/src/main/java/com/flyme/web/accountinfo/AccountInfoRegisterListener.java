package com.flyme.web.accountinfo;

import com.flyme.core.mybatis.event.AfterQueryEvent;
import com.flyme.core.mybatis.event.BeforQueryEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AccountInfoRegisterListener {
    /**
     * 注册监听实现方法
     */
    @EventListener
    public void beforQueryEvent(BeforQueryEvent beforQueryEvent) {
        System.out.println("BeforQueryEvent监听事件"+beforQueryEvent.getSource());
    }
    /**
     * 注册监听实现方法
     */
    @EventListener
    public void afterQueryEvent(AfterQueryEvent afterQueryEvent) {
        System.out.println("AfterQueryEvent监听事件"+afterQueryEvent.getSource());
    }
}
