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

public class AuthorizationTests extends BasicTest {

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
    @DisplayName("Успешный вход в аккаунт")
    public void profileTest() {
        String expectedUrl = "https://stellarburgers.nomoreparties.site/login";
        LoginPage loginPage = page(LoginPage.class);
        Selenide.open(loginPage.URL);
        loginPage.loginUser(login, password);
        Assert.assertEquals("Не произошел переход на страницу авторизации", expectedUrl, WebDriverRunner.driver().url());
    }

    @Test
    @DisplayName("Выход по кнопке «Выйти» в личном кабинете")
    public void logoutTest() {
        String expectedUrl = "https://stellarburgers.nomoreparties.site/login";
        LoginPage loginPage = page(LoginPage.class);
        Selenide.open(loginPage.URL);
        loginPage
                .loginUser(userData.get("email").toString(), userData.get("password").toString())
                .clickProfileButton()
                .clickLogoutButton();
        Assert.assertEquals("Не произошел переход на главную страницу", expectedUrl, WebDriverRunner.driver().url());
    }

    @After
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}
