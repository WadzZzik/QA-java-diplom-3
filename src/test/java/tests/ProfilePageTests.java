package tests;

import com.UserOperations;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.pages.LoginPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.page;

public class ProfilePageTests extends BasicTest {

    public Map userData;
    UserOperations userOperations = new UserOperations();
    String login;
    String password;


    @Before
    public void setUp() {
        userData = userOperations.register();
        this.login = userData.get("email").toString();
        this.password = userData.get("password").toString();
        browserSetUp();
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на лого")
    public void logoClickTest() {
        String expectedUrl = "https://stellarburgers.nomoreparties.site/";
        LoginPage loginPage = page(LoginPage.class);
        Selenide.open(loginPage.URL);
        loginPage
                .loginUser(login, password)
                .clickProfileButton()
                .clickLogo();
        Assert.assertEquals("Не произошел переход на главную страницу", WebDriverRunner.driver().url(), expectedUrl);
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на Конструктор")
    public void constructorClickTest() {
        String expectedUrl = "https://stellarburgers.nomoreparties.site/";
        LoginPage loginPage = page(LoginPage.class);
        Selenide.open(loginPage.URL);
        loginPage
                .loginUser(login, password)
                .clickProfileButton()
                .clickConstructorButton();
        Assert.assertEquals("Не произошел переход на главную страницу", WebDriverRunner.driver().url(), expectedUrl);
    }

    @After
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}
