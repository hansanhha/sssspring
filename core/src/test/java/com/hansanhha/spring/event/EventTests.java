package com.hansanhha.spring.event;

import com.hansanhha.spring.event.entity.SimpleStockMarket;
import com.hansanhha.spring.event.entity.Stock;
import com.hansanhha.spring.event.entity.StockMarket;
import com.hansanhha.spring.event.event.CloseMarketEvent;
import com.hansanhha.spring.event.event.LaunchMarketEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEvent;
import org.springframework.test.context.event.ApplicationEvents;
import org.springframework.test.context.event.RecordApplicationEvents;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@RecordApplicationEvents
public class EventTests {

    @Autowired
    private StockMarket stockMarket;

    @Autowired
    private ApplicationEvents events;

    @Test
    void StockMarketShouldLaunchMarketEvent() throws Exception {
        stockMarket.launchMarket();

        assertThat(events
                .stream(LaunchMarketEvent.class)
                .count())
                .isEqualTo(1);
    }

    @Test
    void StockMarketShouldCloseMarketEvent() throws Exception {
        stockMarket.closeMarket();

        assertThat(events
                .stream(CloseMarketEvent.class)
                .count())
                .isEqualTo(1);
    }
}
