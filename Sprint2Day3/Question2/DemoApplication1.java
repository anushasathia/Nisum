package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DemoApplication1{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		System.out.println("--- Constructor Injection ---");
		TextEditor te1 = (TextEditor) context.getBean("textEditorConstructor");
		te1.spellCheck();

		System.out.println("--- Setter Injection ---");
		TextEditor te2 = (TextEditor) context.getBean("textEditorSetter");
		te2.spellCheck();
	}
}