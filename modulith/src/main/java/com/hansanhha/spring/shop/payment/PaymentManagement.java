package com.hansanhha.spring.shop.payment;

import com.hansanhha.spring.shop.order.events.OrderRequestEvent;
import com.hansanhha.spring.shop.payment.entity.Payment;
import com.hansanhha.spring.shop.payment.events.PaymentCompletedEvent;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PaymentManagement {

    private final ApplicationEventPublisher events;
    private final PaymentGateway paymentGateway;

    @ApplicationModuleListener
    public void startPayment(OrderRequestEvent event) {
        log.info("Received order request for {}.", event.orderId());

        Payment payment = Payment.create(event.orderId().toString(), 1000);

        paymentGateway.ready(payment);
        paymentGateway.approve(payment);

        log.info("succeed order request for {}.", event.orderId());

        events.publishEvent(new PaymentCompletedEvent(payment.getPaymentIdentifier(), event.orderId()));
    }
}
