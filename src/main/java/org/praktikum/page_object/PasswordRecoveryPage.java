package org.praktikum.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage {
    private final WebDriver driver;

    private final By emailField = By.xpath(".//form/fieldset/div/div/input");
    private final By recoveryButton = By.xpath("//button[text()='Восстановить']");
    private final By enterLink = By.xpath(".//a[text()='Войти']");

    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
    }

    public AuthorizationPage enterLinkClick(){
        driver.findElement(enterLink).click();
        return new AuthorizationPage(driver);
    }
}
