package com.example;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.micronaut.test.support.TestPropertyProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;
import org.junit.jupiter.api.TestInstance;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@MicronautTest(transactional = true)
class TransactionalTest implements TestPropertyProvider {

    @Inject
    EmbeddedApplication<?> application;

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

    @Override
    public Map<String, String> getProperties() {
        var jdbcUrl = DbContainer.postgreSQLContainer.getJdbcUrl();
        var host = DbContainer.postgreSQLContainer.getHost();
        var port = DbContainer.postgreSQLContainer.getMappedPort(PostgreSQLContainer.POSTGRESQL_PORT);
        return Map.of(
                "datasources.default-jdbc.url", jdbcUrl,
                "datasources.default-jdbc.username", "test",
                "datasources.default-jdbc.password", "test",
                "r2dbc.datasources.default-r2dbc.url", "r2dbc:postgresql://"+host+":"+port+"/test",
                "r2dbc.datasources.default-r2dbc.username", "test",
                "r2dbc.datasources.default-r2dbc.password", "test"
        );
    }

}
