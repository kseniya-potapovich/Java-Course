package com.tms;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Cap {
    public String text;
    private Inner inner;

    @Override
    public String toString() {
        return "Cap{" +
                "text='" + text + '\'' +
                ", inner=" + inner +
                '}';
    }

    //3. с помощью setter
    @Autowired
    public void setInner(Inner inner) {
        this.inner = inner;
    }

    public String getText() {
        return text;
    }

    public Inner getInner() {
        return inner;
    }
}
