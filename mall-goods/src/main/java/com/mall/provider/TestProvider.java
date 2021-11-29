package com.mall.provider;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("feignTest1")
public interface TestProvider {
    @GetMapping("/api/name")
    public String getOther(@RequestParam(value = "name") String name);
}
