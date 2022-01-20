package com.bbc.test.basepage;

import org.openqa.selenium.WebDriver;

import com.bbc.test.infrastructure.driver.Setup;
import com.bbc.test.infrastructure.driver.Wait;

public class BasePage {

    protected WebDriver driver;
    protected Wait wait;

    public BasePage() {
        this.driver = Setup.driver;
        this.wait = new Wait(this.driver);
    }
}
