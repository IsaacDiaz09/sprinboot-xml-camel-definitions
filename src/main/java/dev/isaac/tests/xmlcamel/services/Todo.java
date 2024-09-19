package dev.isaac.tests.xmlcamel.services;

import lombok.Data;

import java.time.Instant;

@Data
public class Todo {
    private String id;

    private String taskName;

    private Instant createdAt = Instant.now();
}
