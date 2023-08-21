import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.praktikum.page_object.DesignerPage;
import org.praktikum.page_object.Heder;
import org.praktikum.page_object.PasswordRecoveryPage;
import org.praktikum.page_object.RegistrationPage;

public class AutorizationTest extends BaseTest {

    @Before
    public void createСonditionsTest() {
        driver.get("https://stellarburgers.nomoreparties.site/register");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration(name, email, password);
    }

    @Test
    @DisplayName("Переход к авторизации и авторизация через кнопку в хедаре")
    public void authorizationUserInHederTest() {
        driver.get("https://stellarburgers.nomoreparties.site/");
        Heder heder = new Heder(driver);
        DesignerPage designerPage = new DesignerPage(driver);
        heder.clickPersonalAccountByAnUnauthorizedUser()
                .authorization(email, password);
        Assert.assertEquals("Оформить заказ", designerPage.getButtonCreatedOrder().getText());
    }

    @Test
    @DisplayName("Переход к авторизации и авторизация через кнопку на странице конструктора")
    public void authorizationFromTheConstructorPageTest() {
        driver.get("https://stellarburgers.nomoreparties.site/");
        DesignerPage designerPage = new DesignerPage(driver);
        designerPage.clickAccountEnterButton()
                .authorization(email, password);
        Assert.assertEquals("Оформить заказ", designerPage.getButtonCreatedOrder().getText());
    }

    @Test
    @DisplayName("Переход к авторизации и авторизация по ссылке на страници регистрации")
    public void authorizationFromTheRegistrationPage(){
        driver.get("https://stellarburgers.nomoreparties.site/register");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        DesignerPage designerPage = new DesignerPage(driver);
        registrationPage.enterLinkClick()
                .authorization(email, password);
        Assert.assertEquals("Оформить заказ", designerPage.getButtonCreatedOrder().getText());
    }

    @Test
    @DisplayName("Переход к авторизации и авторизация по ссылке на страници востоновления пароля")
    public void authorizationFromThePasswordRecoveryPage(){
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(driver);
        DesignerPage designerPage = new DesignerPage(driver);
        passwordRecoveryPage.enterLinkClick()
                .authorization(email, password);
        Assert.assertEquals("Оформить заказ", designerPage.getButtonCreatedOrder().getText());
    }

}
