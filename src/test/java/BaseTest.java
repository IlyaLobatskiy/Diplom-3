import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.praktikum.api.AuthorizationUser;
import org.praktikum.api.DeleteUser;

public abstract class BaseTest {
    protected final String name = "Test";
    protected final String email = "TestTestov@test.ru";
    protected final String password = "Qwerty";
    protected WebDriver driver;
    AuthorizationUser authorizationUser = new AuthorizationUser();
    DeleteUser deleteUser = new DeleteUser();

    @Before
    public void setUpDriver() {

        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:/Users/Huawei/AppData/Roaming/Microsoft/Windows/Start Menu/Programs/Yandex.exe");
        options.addArguments("--window-size=1920,1080", "--no-default-browser-check", "--deny-permission-prompts",
                "--disable-save-password-bubble");
        driver = new ChromeDriver(options);
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