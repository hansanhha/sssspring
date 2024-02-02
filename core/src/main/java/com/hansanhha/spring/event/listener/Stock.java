package com.hansanhha.spring.event.listener;

import com.hansanhha.spring.event.event.SuspendMarketEvent;
import com.hansanhha.spring.event.event.CloseMarketEvent;
import com.hansanhha.spring.event.event.LaunchMarketEvent;
import lombok.Getter;
import org.springframework.context.event.EventListener;

public abstract class Stock {

    @Getter protected int price;

    @Getter protected TransactionStatus status;

    void increase(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("price should be positive");
        }
        this.price += price;
    }

    void decrease(int price) {
        if (price < 0 || this.price - price < 0) {
            throw new IllegalArgumentException("price should be positive");
        }
        this.price -= price;
    }

    @EventListener
    void active(LaunchMarketEvent event) {
        setTransactionStatus(TransactionStatus.ACTIVE);
        log("active");
    }

    @EventListener
    void inactive(CloseMarketEvent event) {
        setTransactionStatus(TransactionStatus.INACTIVE);
        log("stop");
    }

    @EventListener
    void suspend(SuspendMarketEvent event) {
        setTransactionStatus(TransactionStatus.SUSPEND);
        log("suspend");
    }

    void setTransactionStatus(TransactionStatus status) {
        this.status = status;
    }

    TransactionStatus getTransactionStatus() {
        return status;
    }

    abstract void log(String append);

    private enum TransactionStatus {
        ACTIVE, INACTIVE, SUSPEND
    }

    private enum MarketStatus {
        OPEN, CLOSED
    }
}
