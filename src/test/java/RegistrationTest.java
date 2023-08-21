import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.praktikum.page_object.AuthorizationPage;
import org.praktikum.page_object.RegistrationPage;

import java.time.Duration;

public class RegistrationTest extends BaseTest {

    @Before
    public void getUrl() {
        driver.get("https://stellarburgers.nomoreparties.site/register");
    }

    @Test
    @DisplayName("Регистрация пользователя с валидными данными")
    public void registrationTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        AuthorizationPage title = registrationPage.registration(name, email, password);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.urlContains("login"));
        Assert.assertEquals("Вход", title.getTitle());
    }

    @Test
    @DisplayName("Ошибка при регистрации пользователя с невалидным паролем")
    public void registrationWithInvalidPassword() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration(name, email, "12345");
        Assert.assertEquals("Некорректный пароль", registrationPage.getErrorePassword());
    }
}
