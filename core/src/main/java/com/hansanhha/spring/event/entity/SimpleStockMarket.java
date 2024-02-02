package com.hansanhha.spring.event.entity;

import com.hansanhha.spring.event.event.CloseMarketEvent;
import com.hansanhha.spring.event.event.LaunchMarketEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class SimpleStockMarket implements StockMarket {

    private ApplicationEventPublisher applicationEventPublisher;
    private static MarketStatus status = MarketStatus.CLOSED;

    @Override
    public void launchMarket() {
        applicationEventPublisher.publishEvent(new LaunchMarketEvent());
        status = MarketStatus.OPENED;
    }

    @Override
    public void closeMarket() {
        applicationEventPublisher.publishEvent(new CloseMarketEvent());
        status = MarketStatus.CLOSED;
    }

    @Override
    public void setApplicationEventPublisher(@NonNull ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
