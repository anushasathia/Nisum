package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InjectionTestApp {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        System.out.println("\n--- Constructor Injection Output ---");
        TextEditor te1 = (TextEditor) context.getBean("textEditorConstructor");
        te1.spellCheck();

        System.out.println("\n--- Setter Injection Output ---");
        TextEditor te2 = (TextEditor) context.getBean("textEditorSetter");
        te2.spellCheck();
    }
}
