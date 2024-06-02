package tests;

import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class ConstructorTests extends BasicTest{

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup(); // Инициализация WebDriver Manager для ChromeDriver
        browserSetUp();
    }

    @Test
    @DisplayName("Переход к разделу Булки")
    public void openBunListTest() {
        MainPage mainPage = page(MainPage.class);
        open(mainPage.URL);
        Assert.assertTrue("Раздел Булки не открылся", mainPage.switchToBuns());
    }
    @Test
    @DisplayName("Переход к разделу Соусы")
    public void openSauceListTest() {
        MainPage mainPage = page(MainPage.class);
        open(mainPage.URL);
        Assert.assertTrue("Раздел Соусы не открылся", mainPage.switchToSauces());
    }
    @Test
    @DisplayName("Переход к разделу Начинки")
    public void openFillingListTest() {
        MainPage mainPage = page(MainPage.class);
        open(mainPage.URL);
        Assert.assertTrue("Раздел Начинки не открылся", mainPage.switchToFillings());
    }
    @After
    public void TearDown() {
        WebDriverRunner.closeWebDriver();
    }

}
