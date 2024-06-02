package com.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    public static final String URL = "https://stellarburgers.nomoreparties.site/login";

    //Поле Email
    @FindBy(how = How.XPATH,using = ".//input[@type='text']")
    private SelenideElement emailField;
    //Поле Пароль
    @FindBy(how = How.XPATH,using = ".//input[@type='password']")
    private SelenideElement passwordField;
    //Кнопка Войти
    @FindBy(how = How.XPATH,using = ".//button[text()='Войти']")
    private SelenideElement registerButton;

    @Step("Ввод почты")
    public LoginPage setEmail(String email) {
        emailField.sendKeys(email);
        return page(LoginPage.class);
    }

    @Step("Ввод пароля")
    public LoginPage setPassword(String password) {
        passwordField.sendKeys(password);
        return page(LoginPage.class);
    }

    @Step("Клик по кнопке Войти")
    public void clickLogin() {
        registerButton.click();
    }

    @Step("Логин пользователя")
    public MainPage loginUser(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLogin();
        return page(MainPage.class);
    }

}
