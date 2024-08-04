package com.application.azure;

import com.application.azure.config.DataSourceConfig;
import com.application.azure.config.JpaConfig;
import com.application.azure.config.MyProperties;
import com.application.azure.config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        MyProperties.class,
        DataSourceConfig.class,
        JpaConfig.class,
        ServerConfig.class
})
public class AzureApplication {

    public static void main(String[] args) {
        SpringApplication.run(AzureApplication.class, args);
    }

}
