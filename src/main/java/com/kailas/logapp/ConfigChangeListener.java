package com.kailas.logapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class ConfigChangeListener implements ApplicationListener<EnvironmentChangeEvent> {

    @Autowired
    private Environment environment;

    private static final Logger log = LoggerFactory.getLogger(ConfigChangeListener.class);

    @Override
    public void onApplicationEvent(EnvironmentChangeEvent event) {
        log.error(" CONFIGMAP UPDATED — Changed keys: {}", event.getKeys());
        event.getKeys().forEach(key -> {
            String newValue = environment.getProperty(key);
            log.error("CONFIG CHANGED → {} = {}", key, newValue);
        });
    }
}
