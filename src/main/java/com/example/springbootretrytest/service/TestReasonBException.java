package com.example.springbootretrytest.service;

public class TestReasonBException extends RuntimeException {
    public TestReasonBException() {
        super("reason B");
    }
}
