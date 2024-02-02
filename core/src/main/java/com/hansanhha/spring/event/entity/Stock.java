package com.hansanhha.spring.event.entity;

import com.hansanhha.spring.event.event.CloseMarketEvent;
import com.hansanhha.spring.event.event.LaunchMarketEvent;
import org.springframework.context.event.EventListener;

public abstract class Stock {

    protected int price;

    protected TransactionStatus status;

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
        setTransactionStatus((TransactionStatus) event.getSource());
        log("active");
    }

    @EventListener
    void inactive(CloseMarketEvent event) {
        setTransactionStatus((TransactionStatus) event.getSource());
        log("stop");
    }

    void setTransactionStatus(TransactionStatus status) {
        this.status = status;
    }

    TransactionStatus getTransactionStatus() {
        return status;
    }

    abstract void log(String append);
}
