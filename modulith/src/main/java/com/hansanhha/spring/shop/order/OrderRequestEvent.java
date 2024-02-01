package com.hansanhha.spring.shop.order;

import com.hansanhha.spring.shop.order.Order.OrderIdentifier;

public record OrderRequestEvent(OrderIdentifier orderId) {
}
