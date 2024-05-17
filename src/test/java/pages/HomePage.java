package pages;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private final SelenideElement searchField = $(".search-field"),
            searchResults = $(".entry-title.ak-container"),
            searchTitle = $(".collection_desc.clearfix");

    public HomePage searchField(String value) {
        searchField.setValue(value).pressEnter();
        return this;
    }

    public HomePage searchResults(String searchQuery) {
        searchResults.shouldHave(text(searchQuery));
        return this;
    }
}
