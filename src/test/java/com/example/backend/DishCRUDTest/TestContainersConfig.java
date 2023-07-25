package com.example.backend.DishCRUDTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.PostgreSQLContainer;

public class TestContainersConfig {
    private static final Logger log = LoggerFactory.getLogger(TestContainersConfig.class);

    public static class CustomPostgreSQLContainer extends PostgreSQLContainer<CustomPostgreSQLContainer> {
        private static CustomPostgreSQLContainer container;
        private static final String IMAGE_VERSION = "postgres:15.2-alpine";

        private CustomPostgreSQLContainer() {
            super(IMAGE_VERSION);
        }

        public static CustomPostgreSQLContainer getInstance() {
            if (container == null) {
                container = new CustomPostgreSQLContainer();
            }
            return container;
        }

        @Override
        public void start() {
            super.start();
            String url = container.getJdbcUrl() + "&stringtype=unspecified";
            System.setProperty("spring.datasource.url", url);
            System.setProperty("spring.datasource.username", container.getUsername());
            System.setProperty("spring.datasource.password", container.getPassword());

            log.info("Postgres in docker started: url={}", url);
        }

        @Override
        public void stop() {
        }
    }
}
