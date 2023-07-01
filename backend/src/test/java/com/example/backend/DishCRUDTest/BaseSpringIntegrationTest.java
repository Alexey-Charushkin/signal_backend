package com.example.backend.DishCRUDTest;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.sql.DataSource;

@SpringBootTest
@Transactional
@EnableConfigurationProperties
@Testcontainers
public class BaseSpringIntegrationTest extends BaseSpringTest{
    @Container
    private static final TestContainersConfig.CustomPostgreSQLContainer postgresql = TestContainersConfig
            .CustomPostgreSQLContainer.getInstance();
}
