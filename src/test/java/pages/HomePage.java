package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private final SelenideElement searchField =  $(".search-field"),
            searchResults = $(".entry-title.ak-container"),
            searchTitle = $(".collection_desc.clearfix");
    public HomePage searchField(String value){
        searchField.setValue(value).pressEnter();
        return this;
    }
    public HomePage searchResults(String text){
        searchResults.shouldHave();
        return this;
    }
    public HomePage searchTitle(CollectionCondition collectionCondition){
        searchTitle.shouldBe();
        return this;
    }

}
