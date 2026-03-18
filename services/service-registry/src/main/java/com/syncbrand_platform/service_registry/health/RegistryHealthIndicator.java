package com.syncbrand_platform.service_registry.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class RegistryHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {

        // Custom checks can be added here
        boolean registryRunning = true;

        if (registryRunning) {
            return Health.up()
                    .withDetail("serviceRegistry", "Running")
                    .build();
        }

        return Health.down()
                .withDetail("serviceRegistry", "Unavailable")
                .build();
    }
}