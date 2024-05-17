package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CatalogPage {
    private final SelenideElement catalog = $("#menu-item-46"),
            watchProduct = $("a[href='http://intershop4.skillbox.ru/product-category/catalog/electronics/watch/']"),
            addToCart = $("a[href='?add-to-cart=15']"),
            basket = $("#menu-item-29"),
            productName = $(".product-name[data-title='Товар']"),
            quantityOfGoods = $("input[type='number']"),
            coupon = $("#coupon_code"),
            couponButton = $(".button[value='Применить купон']"),
            textError = $("ul.woocommerce-error li");

    public CatalogPage clickCatalogPage() {
        catalog.click();
        return this;
    }

    public CatalogPage clickWatchProduct() {
        watchProduct.click();
        return this;
    }

    public CatalogPage addToCart(int quantity) {
        for (int i = 0; i < quantity; i++) {
            addToCart.click();
        }
        return this;
    }

    public CatalogPage clickBasketPage() {
        basket.click();
        return this;
    }

    public CatalogPage increaseInQuantity(String value) {
        quantityOfGoods.setValue(value);
        return this;
    }

    public CatalogPage decreaseInQuantity(String value) {
        quantityOfGoods.setValue(value);
        return this;
    }

    public CatalogPage checkingNameProductInTheCard() {
        productName.shouldHave(text("Apple Watch 6"));
        return this;
    }

    public CatalogPage checkingQuantityProductInTheCard(String quantityValue) {
        quantityOfGoods.shouldHave(value(quantityValue));
        return this;
    }

    public CatalogPage openPage() {
        open("/cart/");
        return this;
    }

    public CatalogPage setCoupon(String value) {
        coupon.setValue(value);
        return this;
    }

    public CatalogPage clickCouponButton() {
        couponButton.click();
        return this;
    }

    public CatalogPage checkingTextError() {
        textError.shouldHave(text("Coupon \"test123\" does not exist!"));
        return this;
    }
}
