package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MyAccount {
    private final SelenideElement userName = $("#username"),
            password = $("#password"),
            login = $("[name='login']"),
            entryContent = $(".entry-content"),
            postTitle = $(".post-title"),
            loginName = $("strong:first-child");

    public MyAccount openPage() {
        open("/my-account/");
        return this;
    }

    public MyAccount setUserName(String value) {
        userName.setValue(value);
        return this;
    }

    public MyAccount setPassword(String value) {
        password.setValue(value);
        return this;
    }

    public MyAccount clickLoginBtton() {
        login.click();
        return this;
    }

    public MyAccount checkingEntryContent() {
        entryContent.shouldBe(visible);
        return this;
    }

    public MyAccount checkingPostTitle() {
        postTitle.shouldHave(text("Мой аккаунт"));
        return this;
    }

    public MyAccount checkingLoginName(String value) {
        loginName.shouldHave(text(value));
        return this;
    }

}
