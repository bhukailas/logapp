package com.kailas.logapp;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@RefreshScope
@Configuration
@ConfigurationProperties(prefix = "app")
public class AppConfig {
    
    private String message;
    private Feature feature = new Feature();

    @Getter
    @Setter
    public static class Feature {
        private boolean enabled;
    }
}