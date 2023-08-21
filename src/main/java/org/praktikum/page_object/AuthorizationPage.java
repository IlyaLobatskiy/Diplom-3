package org.praktikum.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.praktikum.page_object.DesignerPage;
import org.praktikum.page_object.RegistrationPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AuthorizationPage {
    private final WebDriver driver;
    private final By emailField = By.xpath(".//div[@id='root']//form/fieldset[1]//input");
    private final By passwordField = By.xpath(".//div[@id='root']//form/fieldset[2]//input");
    private final By buttonEnter = By.xpath(".//button[text()='Войти']");
    private final By registrationLink = By.xpath(".//a[text()='Зарегистрироваться']");
    private final By recoverPasswordLink = By.xpath(".//a[text()='Восстановить пароль']");
    private final By eye = By.xpath(".//*[@id='root']//fieldset[2]//path");
    private final By title = By.xpath("//*[@id='root']/div/main/div/h2");

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void emailFielderInput(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void passwordFieldInput(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void buttonEnterClick() {
        driver.findElement(buttonEnter).click();

    }

    public DesignerPage authorization(String email, String password) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(buttonEnter));
        emailFielderInput(email);
        passwordFieldInput(password);
        buttonEnterClick();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return new DesignerPage(driver);
    }

    public RegistrationPage registrationLinkClick() {
        driver.findElement(registrationLink).click();
        return new RegistrationPage(driver);
    }

    public void recoverPasswordLinkClick() {
        driver.findElement(recoverPasswordLink).click();
    }

    public void eyeClick() {
        driver.findElement(eye).click();
    }


    public String getTitle() {
        return driver.findElement(title).getText();
    }
}
