package com.example.beanscopesdemo.controller;

import com.example.beanscopesdemo.scopes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/scope")
public class ScopeController {

    @Autowired
    private SingletonBean singletonBean;

    @Autowired
    private PrototypeBean prototypeBean;

    @Autowired
    private RequestBean requestBean;

    @Autowired
    private SessionBean sessionBean;

    @Autowired
    private ApplicationBean applicationBean;

    @GetMapping("/singleton")
    public String getSingletonScope() {
        return "Singleton: " + singletonBean.getId();
    }

    @GetMapping("/prototype")
    public String getPrototypeScope() {
        return "Prototype: " + prototypeBean.getId();
    }

    @GetMapping("/request")
    public String getRequestScope() {
        return "Request: " + requestBean.getId();
    }

    @GetMapping("/session")
    public String getSessionScope(HttpSession session) {
        return "Session: " + sessionBean.getId();
    }

    @GetMapping("/application")
    public String getApplicationScope() {
        return "Application: " + applicationBean.getId();
    }
}
