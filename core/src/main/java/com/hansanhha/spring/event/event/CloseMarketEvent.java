package com.hansanhha.spring.event.event;

import com.hansanhha.spring.event.entity.TransactionStatus;
import org.springframework.context.ApplicationEvent;

public class CloseMarketEvent extends ApplicationEvent {

    public CloseMarketEvent() {
        super(TransactionStatus.STOPPED);
    }

    @Override
    public String toString() {
        return "ApplicationEvent: CloseMarketEvent";
    }
}
