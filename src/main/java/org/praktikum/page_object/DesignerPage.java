package org.praktikum.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DesignerPage {
    private final WebDriver driver;
    private final By tabRolls = By.xpath(".//div[@id='root']//section[1]/div[1]/div[1]");
    private final By tabSauces = By.xpath(".//div[@id='root']//section[1]/div[1]/div[2]");
    private final By tabFilling = By.xpath(".//div[@id='root']//section[1]/div[1]/div[3]");
    private final By accountEnterButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By buttonCreatedOrder = By.xpath(".//button[text()='Оформить заказ']");

    private final By rollsName = By.xpath(".//p[text()='Флюоресцентная булка R2-D3']");
    private final By saucesName = By.xpath(".//p[text()='Соус традиционный галактический']");
    private final By fillingName = By.xpath(".//p[text()='Биокотлета из марсианской Магнолии']");

    public DesignerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickTabRolls() {
        driver.findElement(tabRolls).click();
    }

    public void clickTabSauces() {
        driver.findElement(tabSauces).click();
    }

    public void clickTabFilling() {
        driver.findElement(tabFilling).click();
    }

    public AuthorizationPage clickAccountEnterButton() {
        driver.findElement(accountEnterButton).click();
        return new AuthorizationPage(driver);
    }

    public WebElement getButtonCreatedOrder() {
        return driver.findElement(buttonCreatedOrder);
    }

    public String getRollsName(){
        return driver.findElement(rollsName).getText();
    }

    public String getSaucesName(){
        return driver.findElement(saucesName).getText();
    }

    public String getFillingName(){
        return driver.findElement(fillingName).getText();
    }
}
