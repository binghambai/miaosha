package com.binghambai.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.binghambai.customer.*")
@EnableDiscoveryClient
@EnableFeignClients
public class MallCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallCustomerApplication.class, args);
    }

}
