package com.hansanhha.spring.shop.order;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;

@ApplicationModuleTest
@RequiredArgsConstructor
class OrderIntegrationTests {

    private final OrderManagement orders;

    /*
        @ApplicationModuleTest
        - 스프링 부트의 Slice 테스트처럼 모듈 단위의 통합 테스트 수행
        - @SpringBootTest처럼 @SpringBootApplication을 찾음
        - 이후 해당 테스트 클래스가 위치한 곳을 기준으로 모듈을 찾아서 초기화
        - org.springframework.modulith.test DEBUG 로그를 통해 모듈 bootstrap 과정 확인 가능
     */
    @Test
    void contextLoads() {
    }

    @Test
    void publishOrderCompletion(Scenario scenario) throws Exception {
        var reference = new Order();

        scenario.stimulate(() -> orders.complete(reference))
                .andWaitForEventOfType(OrderCompletedEvent.class)
                .matchingMappedValue(OrderCompletedEvent::orderId, reference.getId())
                .toArrive();
    }
}
