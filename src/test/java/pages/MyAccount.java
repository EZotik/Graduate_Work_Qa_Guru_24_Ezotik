package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MyAccount {
    private final SelenideElement userName = $("#username"),
            password = $("#password"),
            login = $("[name='login']"),
            entryContent = $(".entry-content"),
            postTitle =$(".post-title"),
            loginName =$("strong:first-child");

    public MyAccount openPage() {
        open("/my-account/");
        return this;
    }
    public MyAccount setUserName(String value){
        userName.setValue(value);
        return this;
    }
    public MyAccount setPassword(String value){
        password.setValue(value);
        return this;
    }
    public MyAccount login() {
        login.click();
        return this;
    }
      public MyAccount entryContent () {
        entryContent.shouldBe(visible);
        return this;
    }
    public MyAccount postTitle(String text){
        postTitle.shouldHave();
        return this;
    }
    public MyAccount loginName(String text){
        loginName.shouldHave();
        return this;
    }

}
