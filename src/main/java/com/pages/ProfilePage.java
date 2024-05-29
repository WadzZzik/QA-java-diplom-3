package com.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.sleep;

public class ProfilePage {

    //Кнопка Конструктор
    @FindBy(how = How.XPATH,using = ".//p[text()='Конструктор']")
    private SelenideElement constructorButton;
    //Лого
    @FindBy(how = How.CLASS_NAME,using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logo;
    //Кнопка Выход
    @FindBy(how = How.XPATH,using = ".//button[text()='Выход']")
    private SelenideElement logoutButton;

    @Step("Клик по кнопке Конструктор")
    public MainPage clickConstructorButton() {
        constructorButton.click();
        return Selenide.page(MainPage.class);
    }
    @Step("Клик по лого")
    public MainPage clickLogo() {
        logo.click();
        return Selenide.page(MainPage.class);
    }
    @Step("Клик по кнопке Выход")
    public LoginPage clickLogoutButton() {
        logoutButton.click();
        sleep(500);
        return Selenide.page(LoginPage.class);
    }

}
