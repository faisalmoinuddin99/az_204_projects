package com.application.azure.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@ConfigurationProperties(prefix = "spring.datasource")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DataSourceConfig {
    private String url;
    private String username;
    private String password;
}
