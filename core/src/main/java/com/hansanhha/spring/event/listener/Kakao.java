package com.hansanhha.spring.event.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Kakao extends Stock{

    @Override
    void log(String append) {
        log.info("Kakao: {}", append);
    }
}
