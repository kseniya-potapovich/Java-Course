package com.tms;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Cap {
    public String text;
    public Inner inner;

    //2. с помощью конструктора (the best)
    @Autowired
    public Cap(Inner inner) {
        this.inner = inner;
    }
}
