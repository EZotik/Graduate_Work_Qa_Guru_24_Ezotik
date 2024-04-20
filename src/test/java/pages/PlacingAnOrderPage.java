package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.ResultComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class PlacingAnOrderPage {
    private final SelenideElement placingAnOrder = $("#menu-item-31"),

            firstName =  $("#billing_first_name"),
            lastName =  $("#billing_last_name"),
            address = $("#billing_address_1"),
            city = $("#billing_city"),
            state = $("#billing_state"),
            postcode = $("#billing_postcode"),
            phoneNumber = $("#billing_phone"),
            placeOrder = $("#place_order"),
            contentInner = $(".content-inner.clearfix h2"),
            orderOverview = $(".woocommerce-order-overview.woocommerce-thankyou-order-details.order_details");
    ResultComponent resultComponent = new ResultComponent();

    public PlacingAnOrderPage placingAnOrder() {
        placingAnOrder.click();
        return this;
    }
    public PlacingAnOrderPage setFirstName(String value){
        firstName.setValue(value);
        return this;
    }
    public PlacingAnOrderPage setLastName(String value){
        lastName.setValue(value);
        return this;
    }
    public PlacingAnOrderPage setAddress(String value){
        address.setValue(value);
        return this;
    }
    public PlacingAnOrderPage setCity(String value){
        city.setValue(value);
        return this;
    }
    public PlacingAnOrderPage setState(String value){
        state.setValue(value);
        return this;
    }
    public PlacingAnOrderPage setPostcode(String value){
        postcode.setValue(value);
        return this;
    }
    public PlacingAnOrderPage setPhoneNumber(String value){
        phoneNumber.setValue(value);
        return this;
    }
    public PlacingAnOrderPage placeOrder() {
        placeOrder.click();
        return this;
    }
    public PlacingAnOrderPage contentInner(String text){
        contentInner.shouldHave();
        return this;
    }
    public PlacingAnOrderPage orderOverview () {
        orderOverview.shouldBe(visible);
        return this;
    }

    public PlacingAnOrderPage checkResult(String key, String value){
        resultComponent.checkResult(key, value);
        return this;
    }
}
