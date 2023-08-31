package com.example.springbootretrytest.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestService {

    // enable to prevent testServiceRetryListener from being invoked
    // @Retryable(listeners = {"defaultRetryListener"})
    @Retryable
    public Map<String, String> test1(String param) {
        log.info("start test1");
        switch (param) {
            case "A" -> {
                log.info("test1 will fail with reason A");
                throw new TestReasonAException();
            }
            case "B" -> {
                log.info("test1 will fail with reason B");
                throw new TestReasonBException();
            }
            default -> log.info("finish test1: " + param);
        }
        return Map.of("param", param + "1");
    }

    @Retryable(retryFor = TestReasonAException.class, listeners = {"testServiceRetryListener"})
    public Map<String, String> test2(String param) {
        log.info("start test2");
        switch (param) {
            case "A" -> {
                log.info("test2 will fail with reason A");
                throw new TestReasonAException();
            }
            case "B" -> {
                log.info("test2 will fail with reason B");
                throw new TestReasonBException();
            }
            default -> log.info("finish test2: " + param);
        }
        return Map.of("param", param + "2");
    }
}
