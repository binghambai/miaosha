package com.mall.trade.controller;

import com.mall.provider.TestProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trade")
public class TestTradeController {
    @Autowired
    TestProvider testProvider;

    @GetMapping("/test1")
    public String test() {
        return testProvider.getOther("bai");
    }
}
