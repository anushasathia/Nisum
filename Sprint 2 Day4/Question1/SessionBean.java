package com.example.beanscopesdemo.scopes;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionBean {
    private final String id = UUID.randomUUID().toString();
    public String getId() {
        return id;
    }
}