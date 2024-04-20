package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    private final SelenideElement userName = $("#reg_username"),
            email = $("#reg_email"),
            regPassword = $("#reg_password"),
            formRowButton = $(".woocommerce-FormRow.form-row"),
            entryContent = $(".entry-content"),
            postTitle =$ (".post-title"),
            contentPage = $(".content-page"),
            logout = $(".login-woocommerce");
    public RegistrationPage openPage() {
        open("/register/");
        return this;
    }
    public RegistrationPage setUserName(String value){
        userName.setValue(value);
        return this;
    }
    public RegistrationPage setEmail(String value){
        email.setValue(value);
        return this;
    }
    public RegistrationPage setPassword(String value){
        regPassword.setValue(value);
        return this;
    }
    public RegistrationPage formRowButton() {
        formRowButton.click();
        return this;
    }
    public RegistrationPage entryContent () {
        entryContent.shouldBe(visible);
        return this;
    }
    public RegistrationPage postTitle(String text){
        postTitle.shouldHave();
        return this;
    }
    public RegistrationPage contentPage(String text){
        contentPage.shouldHave();
        return this;
    }
    public RegistrationPage logout() {
        logout.click();
        return this;
    }
}
