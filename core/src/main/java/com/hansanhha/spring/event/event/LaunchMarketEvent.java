package com.hansanhha.spring.event.event;

import com.hansanhha.spring.event.entity.TransactionStatus;
import org.springframework.context.ApplicationEvent;

public class LaunchMarketEvent extends ApplicationEvent {

    public LaunchMarketEvent() {
        super(TransactionStatus.ACTIVE);
    }

    @Override
    public String toString() {
        return "ApplicationEvent: LaunchMarketEvent";
    }
}
