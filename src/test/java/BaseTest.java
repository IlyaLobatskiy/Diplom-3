import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.praktikum.BaseUrl;
import org.praktikum.api.AuthorizationUser;
import org.praktikum.api.DeleteUser;

public abstract class BaseTest extends BaseUrl {
    protected final String name = "Test";
    protected final String email = "TestTestov@test.ru";
    protected final String password = "Qwerty";
    protected WebDriver driver;
    AuthorizationUser authorizationUser = new AuthorizationUser();
    DeleteUser deleteUser = new DeleteUser();

    public static WebDriver getWebDriver(String browserName){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080", "--no-default-browser-check", "--deny-permission-prompts",
                "--disable-save-password-bubble");
        switch (browserName){
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/java/Resources/bin/chromedriver.exe");
                return new ChromeDriver(options);
            case "Yandex":
                System.setProperty("webdriver.chrome.driver", "src/test/java/Resources/bin/yandexdriver.exe");
                return new ChromeDriver(options);
            default:
                throw new RuntimeException("Неизвестный браузер");
        }
    }

    @Before
    public void setUpDriver() {

        driver = getWebDriver("Yandex");
    }

    @After
    public void closeBrows() {
        try {
            authorizationUser.authorizationValidliUserData();
            deleteUser.deleteUser(authorizationUser.accessToken);
        } catch (Exception e) {
            System.out.println("Passed: Пользователь не создан");
        }
        driver.quit();
    }
}