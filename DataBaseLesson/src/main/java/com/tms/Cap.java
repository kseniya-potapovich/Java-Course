package com.tms;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("singleton")
@Component
public class Cap {
    public String text;
    public InterfaceInner inner;

    @Autowired
    public Cap(@Qualifier("innerSecond") InterfaceInner inner) {
        this.inner = inner;
    }

    @PostConstruct
    public void initMethod() {
        System.out.println("Hello Cap bean!");
    }

    @PreDestroy
    public void destroyMethod() {
        System.out.println("Bye bye Cap bean!");
    }


}
