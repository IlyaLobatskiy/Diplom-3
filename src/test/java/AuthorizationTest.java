import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.praktikum.page_object.DesignerPage;
import org.praktikum.page_object.Header;
import org.praktikum.page_object.PasswordRecoveryPage;
import org.praktikum.page_object.RegistrationPage;

public class AuthorizationTest extends BaseTest {

    @Before
    public void createConditionsTest() {
        driver.get(baseUrl + "/register");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration(name, email, password);
    }

    @Test
    @DisplayName("Переход к авторизации и авторизация через кнопку в хедаре")
    public void authorizationUserInHeaderTest() {
        driver.get(baseUrl);
        Header header = new Header(driver);
        DesignerPage designerPage = new DesignerPage(driver);
        header.clickPersonalAccountByAnUnauthorizedUser()
                .authorization(email, password);
        Assert.assertEquals("Оформить заказ", designerPage.getButtonCreatedOrder().getText());
    }

    @Test
    @DisplayName("Переход к авторизации и авторизация через кнопку на странице конструктора")
    public void authorizationFromTheConstructorPageTest() {
        driver.get(baseUrl);
        DesignerPage designerPage = new DesignerPage(driver);
        designerPage.clickAccountEnterButton()
                .authorization(email, password);
        Assert.assertEquals("Оформить заказ", designerPage.getButtonCreatedOrder().getText());
    }

    @Test
    @DisplayName("Переход к авторизации и авторизация по ссылке на страници регистрации")
    public void authorizationFromTheRegistrationPage() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        DesignerPage designerPage = new DesignerPage(driver);
        registrationPage.enterLinkClick()
                .authorization(email, password);
        Assert.assertEquals("Оформить заказ", designerPage.getButtonCreatedOrder().getText());
    }

    @Test
    @DisplayName("Переход к авторизации и авторизация по ссылке на страници востоновления пароля")
    public void authorizationFromThePasswordRecoveryPage() {
        driver.get(baseUrl + "/forgot-password");
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(driver);
        DesignerPage designerPage = new DesignerPage(driver);
        passwordRecoveryPage.enterLinkClick()
                .authorization(email, password);
        Assert.assertEquals("Оформить заказ", designerPage.getButtonCreatedOrder().getText());
    }

}
