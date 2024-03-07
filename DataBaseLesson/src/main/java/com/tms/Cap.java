package com.tms;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Cap {
    public String text;

    //1. первый способ - это через поле (autowired)
    @Autowired
    public Inner inner;
}
