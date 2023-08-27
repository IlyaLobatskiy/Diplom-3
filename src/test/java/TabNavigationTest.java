import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.praktikum.page_object.DesignerPage;

public class TabNavigationTest extends BaseTest {
    @Before
    public void getUrl() {
        driver.get(baseUrl);
    }

    @Test
    @DisplayName("Проверка нажатия на таб булки")
    public void tabRollsNavigationTest() {
        DesignerPage designerPage = new DesignerPage(driver);
        designerPage.clickTabFilling();
        designerPage.clickTabRolls();
        Assert.assertEquals("Флюоресцентная булка R2-D3", designerPage.getRollsName());
    }

    @Test
    @DisplayName("Проверка нажатия на таб соусы")
    public void tabSaucesNavigationTest() {
        DesignerPage designerPage = new DesignerPage(driver);
        designerPage.clickTabSauces();
        Assert.assertEquals("Соус традиционный галактический", designerPage.getSaucesName());
    }

    @Test
    @DisplayName("Проверка нажатия на таб начинки")
    public void tabFillingNavigationTest() {
        DesignerPage designerPage = new DesignerPage(driver);
        designerPage.clickTabFilling();
        Assert.assertEquals("Биокотлета из марсианской Магнолии", designerPage.getFillingName());
    }

}
