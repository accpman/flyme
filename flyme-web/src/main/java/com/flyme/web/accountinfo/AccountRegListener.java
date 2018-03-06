package com.flyme.web.accountinfo;

import com.flyme.common.base.ApiJson;
import com.flyme.core.mybatis.event.BeforQueryEvent;
import com.flyme.rbac.accountinfo.entity.AccountInfo;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author :flyme
 * @date : 2018/3/3 23:23
 * @description :用户注册监听
 */
@Component
public class AccountRegListener implements SmartApplicationListener {


    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        return aClass == BeforQueryEvent.class;
    }

    @Override
    public boolean supportsSourceType(Class<?> aClass) {
        return aClass == AccountInfo.class;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        BeforQueryEvent queryEvent = (BeforQueryEvent) applicationEvent;
        AccountInfo accountInfo = (AccountInfo) queryEvent.getSource();
        ApiJson json = queryEvent.getApiJson();
        System.out.println("注册前通知"+ json.getInfo());
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
