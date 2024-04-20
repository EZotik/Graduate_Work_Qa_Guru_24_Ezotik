package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CatalogPage {
    private final SelenideElement catalog = $("#menu-item-46"),
            watchProduct = $("a[href='http://intershop4.skillbox.ru/product-category/catalog/electronics/watch/']"),
            addToCart = $("a[href='?add-to-cart=15']"),
            basket = $("#menu-item-29"),
            productName = $(".product-name[data-title='Товар']"),
            quantityOfGoods =$("input[type='number']"),
            coupon = $("#coupon_code"),
            couponButton = $(".button[value='Применить купон']"),
            textError= $("ul.woocommerce-error li");

    public CatalogPage catalog() {
        catalog.click();
        return this;
    }
    public CatalogPage watchProduct() {
        watchProduct.click();
        return this;
    }
    public CatalogPage addToCart() {
        addToCart.click();
        return this;
    }
    public CatalogPage basket() {
        basket.click();
        return this;
    }
    public CatalogPage increaseInQuantity(String value){
        quantityOfGoods.setValue(value);
        return this;
    }
    public CatalogPage productName(String text){
        productName.shouldHave();
        return this;
    }
    public CatalogPage quantityOfGoods(String value){
        quantityOfGoods.shouldHave();
        return this;
    }
    public CatalogPage openPage() {
        open("/cart/");
        return this;
    }
    public CatalogPage setCoupon(String value){
        coupon.setValue(value);
        return this;
    }

    public CatalogPage couponButton() {
        couponButton.click();
        return this;
    }
    public CatalogPage textError(String value){
        textError.shouldHave();
        return this;
    }
}
