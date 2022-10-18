package com.demoqa;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TaskTests {

    @BeforeAll
    static void assertStart() {
        Selenide.open("https://demoqa.com/automation-practice-form");
        Configuration.browserSize = "1920х1080";
    }

    @Test
    void enterPole() {
        $("[id=firstName]").setValue("Egor");
        $("[id=lastName]").setValue("Furga");
        $("[id=userEmail]").setValue("gajirada@mail.ru");
        $("[id=userNumber]").setValue("7924998033");
        $(By.xpath("//label[normalize-space()='Female']")).click();
        $("[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__month-select]").selectOption("May");
        $("[class=react-datepicker__year-select]").selectOption("2000");
        $(By.xpath("//div[@aria-label='Choose Monday, May 1st, 2000']")).click();
        $("[id=submit]").scrollIntoView(true);
        $(By.xpath("//label[normalize-space()='Sports']")).click();
        $("input#uploadPicture").uploadFile(new File("src/test/resources/file.png"));
        $("[id=currentAddress]").setValue("Moscow");
        $(byId("submit")).click(ClickOptions.usingJavaScript());
        $(".table-responsive").shouldHave(text("Egor Furga"), text("gajirada@mail.ru"),
                text("7924998033"), text("Female"), text("1 may,2000"), text("Sports"), text("Moscow"));
    }

}