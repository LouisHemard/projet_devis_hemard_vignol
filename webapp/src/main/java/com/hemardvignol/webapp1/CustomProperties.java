package com.hemardvignol.webapp1;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix="com.hemardvignol.webapp1")
public class CustomProperties {

    private String apiUrl;

}