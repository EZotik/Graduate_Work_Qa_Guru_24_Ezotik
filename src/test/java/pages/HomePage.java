package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private final SelenideElement searchField =  $(".search-field"),
            searchResults = $(".entry-title.ak-container"),
            searchTitle = $("a[href='http://intershop4.skillbox.ru/product/iphone_13/'] h3");
    public HomePage searchField(String value){
        searchField.setValue(value).pressEnter();
        return this;
    }
    public HomePage searchResults(String text){
        searchResults.shouldHave();
        return this;
    }
    public HomePage searchTitle(String text){
        searchTitle.shouldHave();
        return this;
    }

}
