package com.tms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Cap {
    public String text;

    @Qualifier("innerSecond")
    @Autowired
    public InterfaceInner inner;
}
