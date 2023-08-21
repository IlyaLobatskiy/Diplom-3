package org.praktikum.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.praktikum.page_object.PersonalAccountPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Heder {
    private final WebDriver driver;
    private final By designerLink = By.xpath(".//*[@id='root']/div/header/nav/ul/li[1]/a");
    private final By orderFeedLink = By.xpath(".//*[@id='root']/div/header/nav/ul/li[2]/a");
    private final By logoLink = By.xpath(".//*[@id='root']/div/header/nav/div/a");
    private final By personalAccountLink = By.xpath(".//p[text() = 'Личный Кабинет']");

    public Heder(WebDriver driver) {
        this.driver = driver;
    }

    public DesignerPage clickDesigner() {
        driver.findElement(designerLink).click();
        return new DesignerPage(driver);
    }

    public void clickOrderFeed() {
        driver.findElement(orderFeedLink).click();
    }

    public DesignerPage clickLogo() {
        driver.findElement(logoLink).click();
        return new DesignerPage(driver);
    }

    public AuthorizationPage clickPersonalAccountByAnUnauthorizedUser() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(personalAccountLink));
        driver.findElement(personalAccountLink).click();
        return new AuthorizationPage(driver);
    }

    public PersonalAccountPage clickPersonalAccountAuthorizedUser() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(personalAccountLink));
        driver.findElement(personalAccountLink).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return new PersonalAccountPage(driver);
    }

}