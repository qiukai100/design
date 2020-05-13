package com.example.design.patterns.proxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 增强方式
 */
@Slf4j
@Service
public class EnhanceWay {

    public void before() {
        log.info("EnhanceWay before.");
    }

    public void after() {
        log.info("EnhanceWay after.");
    }

    public void afterEx() {
        log.info("EnhanceWay afterEx.");
    }
}
