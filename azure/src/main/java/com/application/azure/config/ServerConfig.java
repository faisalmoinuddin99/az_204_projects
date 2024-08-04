package com.application.azure.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "server")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ServerConfig {

    private int port ;
}
