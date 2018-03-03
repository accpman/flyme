package com.flyme.core.mybatis.event;

import org.springframework.context.ApplicationEvent;

public class BeforQueryEvent extends ApplicationEvent {
    public BeforQueryEvent(Object source) {
        super(source);
    }
}
