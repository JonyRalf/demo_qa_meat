package com.test_Junit;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;

public class SimpleTest {
    @BeforeAll
    static void clear () {
        System.out.println("### BeforeAll");
    }
    @BeforeEach
    void assertStart () {
        System.out.println("### BeforeEach");
        Selenide.open("https://demoqa.com/");
    }
    @AfterEach
    void assertEnd (){
        System.out.println("### BeforEach");
        WebDriverRunner.closeWindow();
    }
    @BeforeAll
    static void clearOut () {
        System.out.println("### BeforeAll_out");
    }
    @Test
    void assertTest1 () {
        System.out.println("### Test_1");
    }
    @Test
    void assertTest2 () {
        System.out.println("### Test_2");
    }
    @Test
    void assertTest3 () {
        System.out.println("### Test_3");
    }

    @Test
    void assertTest4 () {
        System.out.println("### Test_4");
    }


}
