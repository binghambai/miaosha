package com.binghambai.mallgoods.controller;

import com.binghambai.mallgoods.provider.TestProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController implements TestProvider {


    @GetMapping("/name")
    public String getOther(@RequestParam(value = "name") String name) {
        return "hello" + name;
    }
}
