import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.praktikum.page_object.AuthorizationPage;
import org.praktikum.page_object.Header;
import org.praktikum.page_object.RegistrationPage;

public class logOutTest extends BaseTest {
    @Test
    @DisplayName("Выход из аккаунта")
    public void logOutOfAccount() {
        driver.get(baseUrl + "/register");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        Header header = new Header(driver);
        registrationPage.registration(name, email, password)
                .authorization(email, password);
        AuthorizationPage authorizationPage = header.clickPersonalAccountAuthorizedUser().exitButtonClick();
        Assert.assertEquals("Вход", authorizationPage.getTitle());

    }
}
