package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.pages.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.page;

public class RedirectToLoginTests extends BasicTest {

    String expectedUrl = "https://stellarburgers.nomoreparties.site/login";


    @Before
    public void setUp() {
        browserSetUp();
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void loginFromMainPageTest() {
        MainPage mainPage = page(MainPage.class);
        Selenide.open(mainPage.URL);
        mainPage.clickLoginButton();
        Assert.assertEquals("Не произошел переход на страницу авторизации", WebDriverRunner.driver().url(), expectedUrl);
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void redirectUnauthorizedUserToLoginTest() {
        MainPage mainPage = page(MainPage.class);
        Selenide.open(mainPage.URL);
        mainPage.clickProfileButton();
        Assert.assertEquals("Не произошел переход на страницу авторизации", WebDriverRunner.driver().url(), expectedUrl);
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginFromRegistrationPageTest() {
        RegistrationPage registrationPage = page(RegistrationPage.class);
        Selenide.open(registrationPage.URL);
        registrationPage.clickLoginLink();
        Assert.assertEquals("Не произошел переход на страницу авторизации", WebDriverRunner.driver().url(), expectedUrl);
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginFromPasswordRecoveryPageTest() {
        PasswordRecoveryPage passwordRecoveryPage = page(PasswordRecoveryPage.class);
        Selenide.open(passwordRecoveryPage.URL);
        passwordRecoveryPage.clickLoginLink();
        Assert.assertEquals("Не произошел переход на страницу авторизации", WebDriverRunner.driver().url(), expectedUrl);
    }
    @After
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }

}
