package com.demo;

import com.demo.action.ComplexAction;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        context.registerShutdownHook();

        ComplexAction action = context.getBean(ComplexAction.class);
        action.takeAction();
    }
}
