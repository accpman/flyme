package com.flyme.core.mybatis.event;

import org.springframework.context.ApplicationEvent;

public class AfterQueryEvent extends ApplicationEvent {
    public AfterQueryEvent(Object source) {
        super(source);
    }
}
