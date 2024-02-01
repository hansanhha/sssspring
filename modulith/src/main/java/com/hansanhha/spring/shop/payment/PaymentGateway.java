package com.hansanhha.spring.shop.payment;

import com.hansanhha.spring.shop.payment.entity.Payment;
import com.hansanhha.spring.shop.payment.service.PaymentService;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class PaymentGateway {

    private final @NonNull PaymentService paymentService;

    public void ready(Payment payment) {
        paymentService.request(payment);
    }

    public void approve(Payment payment) {
        paymentService.pay(payment);
    }
}
