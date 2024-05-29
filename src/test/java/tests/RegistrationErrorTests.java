package tests;

import com.UserOperations;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.pages.RegistrationPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.page;

public class RegistrationErrorTests extends BasicTest {

    String expectedUrl = "https://stellarburgers.nomoreparties.site/register";
    public Map userData;
    UserOperations userOperations = new UserOperations();
    String name;
    String email;
    String password;

    @Before
    public void setUp() {
        userData = userOperations.generateInvalidUserInfo();
        this.name = userData.get("name").toString();
        this.email = userData.get("email").toString();
        this.password = userData.get("password").toString();
        browserSetUp();
    }

    @Test
    @DisplayName("Ошибка при регистрации пользователя с паролем из пяти символов")
    public void invalidDataRegistrationTest() {
        RegistrationPage registrationPage = page(RegistrationPage.class);
        Selenide.open(registrationPage.URL);
        registrationPage
                .setName(name)
                .setEmail(email)
                .setPassword(password)
                .clickRegister();
        String currentUrl = WebDriverRunner.driver().url();
        Assert.assertEquals("Произошел переход на страницу авторизации", expectedUrl, currentUrl);
    }

    @After
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }

}
