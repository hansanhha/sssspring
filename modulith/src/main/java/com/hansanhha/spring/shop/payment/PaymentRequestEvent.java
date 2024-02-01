package com.hansanhha.spring.shop.payment;

import com.hansanhha.spring.shop.payment.entity.Payment.PaymentIdentifier;

public record PaymentRequestEvent(PaymentIdentifier paymentId) {
}
