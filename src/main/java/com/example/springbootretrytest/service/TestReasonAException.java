package com.example.springbootretrytest.service;

public class TestReasonAException extends RuntimeException {
    public TestReasonAException() {
        super("reason A");
    }
}
