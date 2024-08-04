package com.application.azure;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "spring.cloud.azure.appconfiguration.enabled=false")
class AzureApplicationTests {

    @Test
    void contextLoads() {
    }

}
