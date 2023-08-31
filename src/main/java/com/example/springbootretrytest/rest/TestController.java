package com.example.springbootretrytest.rest;

import com.example.springbootretrytest.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping(value = {"/test1"})
    public Map<String, String> getTest1(@RequestParam("param") String param) {
        return testService.test1(param);
    }

    @GetMapping(value = {"/test2"})
    public Map<String, String> getTest2(@RequestParam("param") String param) {
        return testService.test2(param);
    }

}