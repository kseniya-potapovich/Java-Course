package com.tms;

import lombok.Data;

@Data
public class Cap {
    private String text;

    public Cap(String text) {
        this.text = text;
    }
}
