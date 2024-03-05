package com.tms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        /** 1. Create Spring Container(ApplicationContext) */
        ApplicationContext context = new ClassPathXmlApplicationContext("settings.xml"); // если настраиваем через xml
        Cap capBean = (Cap) context.getBean("cap");
        Cap capBean2 = (Cap) context.getBean("cap");
        System.out.println(capBean);
        System.out.println(capBean2);
        System.out.println(capBean.hashCode());
        System.out.println(capBean2.hashCode());
        capBean2.setText("Hello!!!!");
        System.out.println(capBean);
        System.out.println(capBean2);
        System.out.println(capBean.hashCode());
        System.out.println(capBean2.hashCode());

    }
}
