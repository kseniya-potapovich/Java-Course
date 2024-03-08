package com.tms;

import com.tms.repository.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.io.Closeable;

@ComponentScan // спринг будет вычитывать все классы через рефлексию начиная с того пакета где лежит этот класс(Main)
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        UserRepository repository = (UserRepository) context.getBean("userRepository");
        System.out.println(repository);
    }
}
