package com.hansanhha.spring.event.entity;

import org.springframework.context.ApplicationEventPublisherAware;

public interface StockMarket extends ApplicationEventPublisherAware {

    void launchMarket();

    void closeMarket();
}
