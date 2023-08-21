import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.praktikum.page_object.DesignerPage;

public class TabТavigationTest extends BaseTest {
    @Test
    @DisplayName("Проверка нажатия на таб булки")
    public void tabRollsТavigationTest(){
        driver.get("https://stellarburgers.nomoreparties.site");
        DesignerPage designerPage = new DesignerPage(driver);
        designerPage.clickTabFilling();
        designerPage.clickTabRolls();
        Assert.assertEquals("Флюоресцентная булка R2-D3", designerPage.getRollsName());
    }

    @Test
    @DisplayName("Проверка нажатия на таб соусы")
    public void tabSaucesТavigationTest(){
        driver.get("https://stellarburgers.nomoreparties.site");
        DesignerPage designerPage = new DesignerPage(driver);
        designerPage.clickTabSauces();
        Assert.assertEquals("Соус традиционный галактический", designerPage.getSaucesName());
    }

    @Test
    @DisplayName("Проверка нажатия на таб начинки")
    public void tabFillingТavigationTest(){
        driver.get("https://stellarburgers.nomoreparties.site");
        DesignerPage designerPage = new DesignerPage(driver);
        designerPage.clickTabFilling();
        Assert.assertEquals("Биокотлета из марсианской Магнолии", designerPage.getFillingName());
    }
}
