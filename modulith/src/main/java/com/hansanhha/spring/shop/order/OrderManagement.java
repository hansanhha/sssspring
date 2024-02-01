package com.hansanhha.spring.shop.order;

import com.hansanhha.spring.shop.order.internal.OrderInternal;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderManagement {

    private final @NonNull ApplicationEventPublisher events;
    private final @NonNull OrderInternal orderInternal;

    @Transactional
    public void complete(Order order) {
        events.publishEvent(new OrderCompletedEvent(order.getId()));
    }
}
