package com.example.beanscopesdemo.scopes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
@Scope("application")
public class ApplicationBean {
    private final String id = UUID.randomUUID().toString();
    public String getId() {
        return id;
    }
}