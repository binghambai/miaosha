package com.binghambai.mallgoods.provider;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "${app.goods.name}", contextId = "TestProvider")
public interface TestProvider {
    @GetMapping("/goods/${application.goods.version}/name")
    public String getOther(@RequestParam(value = "name") String name);
}
