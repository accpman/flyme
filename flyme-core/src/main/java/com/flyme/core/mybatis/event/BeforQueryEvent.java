package com.flyme.core.mybatis.event;

import com.flyme.common.base.ApiJson;
import org.springframework.context.ApplicationEvent;

/**
 * @author flyme
 */
public class BeforQueryEvent extends ApplicationEvent {
    private ApiJson apiJson;

    public BeforQueryEvent(Object source, ApiJson apiJson) {
        super(source);
        this.apiJson = apiJson;
    }

    public BeforQueryEvent(Object source) {
        super(source);
    }

    public ApiJson getApiJson() {
        return apiJson;
    }
}
