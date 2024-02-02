package com.hansanhha.spring.event.pulisher;

import com.hansanhha.spring.event.event.CircuitBreakerEvent;
import com.hansanhha.spring.event.event.CircuitBreakerEvent.CircuitBreakerEventTime;
import com.hansanhha.spring.event.event.CloseMarketEvent;
import com.hansanhha.spring.event.event.LaunchMarketEvent;
import com.hansanhha.spring.event.event.SuspendMarketEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
    public void circuitBreaker() {
        applicationEventPublisher.publishEvent(new SuspendMarketEvent());

        LocalDateTime now = LocalDateTime.now();
        applicationEventPublisher.publishEvent(
                new CircuitBreakerEvent(new CircuitBreakerEventTime(now, now.plusMinutes(10))));
    }

    @Override
    public void setApplicationEventPublisher(@NonNull ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
