package com.boot.springboot.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class UserControllerTest {

    @Test
    @Tag("candibober")
    public void myTest(){

    }

    @Test
    @DisplayName("это второй метод")
    @RepeatedTest(5)
    public void mySecondTest(){

    }

    @Test
    @Tag("candibober")
    public void myThirdTest(){

    }
}
