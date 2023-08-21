import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.praktikum.page_object.DesignerPage;
import org.praktikum.page_object.Heder;
import org.praktikum.page_object.PersonalAccountPage;
import org.praktikum.page_object.RegistrationPage;

public class NavigationTest extends BaseTest{

    @Test
    @DisplayName("Переход в личный кабинет")
    public void transferToYourPersonalAccountTest(){
        driver.get("https://stellarburgers.nomoreparties.site/register");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        Heder heder = new Heder(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        registrationPage.registration(name, email, password)
                .authorization(email, password);
        heder.clickPersonalAccountAuthorizedUser();
        Assert.assertEquals("Профиль", personalAccountPage.getProfileLinkText());
    }

    @Test
    @DisplayName("Переход в конструктор по кнопке")
    public void transferToDesignerFromLinkTest(){
        driver.get("https://stellarburgers.nomoreparties.site/register");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        Heder heder = new Heder(driver);
        DesignerPage designerPage = new DesignerPage(driver);
        registrationPage.registration(name, email, password)
                .authorization(email, password);
        heder.clickPersonalAccountAuthorizedUser();
        heder.clickDesigner();
        Assert.assertEquals("Оформить заказ", designerPage.getButtonCreatedOrder().getText());
    }

    @Test
    @DisplayName("Переход в конструктор по лого")
    public void transferToDesignerFromLogoTest(){
        driver.get("https://stellarburgers.nomoreparties.site/register");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        Heder heder = new Heder(driver);
        DesignerPage designerPage = new DesignerPage(driver);
        registrationPage.registration(name, email, password)
                .authorization(email, password);
        heder.clickPersonalAccountAuthorizedUser();
        heder.clickLogo();
        Assert.assertEquals("Оформить заказ", designerPage.getButtonCreatedOrder().getText());
    }
}
