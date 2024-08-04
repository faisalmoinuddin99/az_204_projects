package com.application.azure.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;



@ConfigurationProperties(prefix = "config")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MyProperties {

    private String message;

}
