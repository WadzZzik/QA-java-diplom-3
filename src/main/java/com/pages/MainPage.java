package com.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    public static final String URL = "https://stellarburgers.nomoreparties.site/";

    //Кнопка Личный кабинет
    @FindBy(how = How.XPATH,using = ".//p[text()='Личный Кабинет']")
    private SelenideElement profileButton;
    //Кнопка Войти в аккаунт
    @FindBy(how = How.XPATH,using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement loginButton;
    //Вкладки "Булки", Соусы", "Начинки"
    @FindBy(how = How.CLASS_NAME,using = "tab_tab__1SPyG")
    private ElementsCollection tabs;

    @Step("Клик по кнопке Личный кабинет")
    public ProfilePage clickProfileButton() {
        profileButton.click();
        return page(ProfilePage.class);
    }
    @Step("Клик по кнопке Войти в аккаунт")
    public LoginPage clickLoginButton() {
        loginButton.click();
        return Selenide.page(LoginPage.class);
    }
    @Step("Клик по вкладке Булки")
    public boolean switchToBuns() {
        tabs.get(2).click();
        tabs.get(0).click();
        return tabs.get(0).getAttribute("class").contains("tab_tab_type_current__2BEPc");
    }
    @Step("Клик по вкладке Соусы")
    public boolean switchToSauces() {
        tabs.get(1).click();
        return tabs.get(1).getAttribute("class").contains("tab_tab_type_current__2BEPc");
    }
    @Step("Клик по вкладке Начинки")
    public boolean switchToFillings() {
        tabs.get(2).click();
        return tabs.get(2).getAttribute("class").contains("tab_tab_type_current__2BEPc");
    }

}
