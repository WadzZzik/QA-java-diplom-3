package tests;

import com.UserOperations;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import com.pages.RegistrationPage;
import com.codeborne.selenide.Selenide;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.page;

public class RegistrationTests extends BasicTest {

    String expectedUrl = "https://stellarburgers.nomoreparties.site/login";
    public Map userData;
    UserOperations userOperations = new UserOperations();
    String name;
    String email;
    String password;

    @Before
    public void setUp() {
        userData = userOperations.generateUserInfo();
        this.name = userData.get("name").toString();
        this.email = userData.get("email").toString();
        this.password = userData.get("password").toString();
        browserSetUp();
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void validDataRegistrationTest() {
        RegistrationPage registrationPage = page(RegistrationPage.class);
        Selenide.open(registrationPage.URL);
        registrationPage
                .setName(name)
                .setEmail(email)
                .setPassword(password)
                .clickRegister();
        String currentUrl = WebDriverRunner.driver().url();
        Assert.assertEquals("Не произошел переход на страницу авторизации", expectedUrl, currentUrl);
    }

    @After
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }

}
