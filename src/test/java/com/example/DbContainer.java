package com.example;

import org.testcontainers.containers.PostgreSQLContainer;

public class DbContainer {

    static PostgreSQLContainer postgreSQLContainer;

    static {
        var container = new PostgreSQLContainer("postgres:13.7")
                .withDatabaseName("test");
        container.start();
        postgreSQLContainer = container;
    }


}
