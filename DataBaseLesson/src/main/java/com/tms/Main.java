package com.tms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        /** by Java */
        /** 1. Create Spring Container(ApplicationContext) */
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Cap capBean = (Cap) context.getBean("cap");
        System.out.println(capBean);
    }
}
