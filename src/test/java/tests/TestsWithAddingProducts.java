package tests;

import config.CredentialConfig;
import io.qameta.allure.Feature;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.*;
import pages.*;
import utils.RandomUtils;

import static io.qameta.allure.Allure.step;

@Tag("simple_test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestsWithAddingProducts extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    MyAccount myAccount = new MyAccount();
    HomePage homePage = new HomePage();
    CatalogPage catalogPage = new CatalogPage();
    PlacingAnOrderPage placingAnOrderPage = new PlacingAnOrderPage();
    RandomUtils random = new RandomUtils();
    CredentialConfig credentialConfig = ConfigFactory.create(CredentialConfig.class);
    String fieldNames = "Товар";
    String productName = "Apple Watch 6";
    String cartSubtotal = "Subtotal:";
    String paymentMethod = "Payment method:";
    String total = "Total:";

    @BeforeEach
    public void loginToAccount() {
        step("Открываем страницу с входом в личный кабинет", () -> {
            myAccount.openPage();
        });
        step("Вводим логин", () -> {
            myAccount.setUserName(credentialConfig.loginUserName());
        });
        step("Вводим пароль", () -> {
            myAccount.setPassword(credentialConfig.loginPassword());
        });
        step("Кликаем на кнопку войти", () -> {
            myAccount.login();
        });
    }

    @Test
    @Order(3)
    @Feature("Корзина товаров")
    @DisplayName("Добавление товара в корзину")
    void addingItemToCartTest() {
        step("Открываем страницу с каталогом товаров", () -> {
            catalogPage.catalog();
        });
        step("Кликаем по вкладке \"Часы\"", () -> {
            catalogPage.watchProduct();
        });
        step("Добавляем товар в корзину", () -> {
            catalogPage.addToCart();
        });
        step("Переходим в корзину товаров", () -> {
            catalogPage.basket();
        });
        step("Добавляем нужное количество товаров", () -> {
            catalogPage.increaseInQuantity("2");
        });
        step("Проверяем наименование добавленного товара в корзину", () -> {
            catalogPage.productName("Apple Watch 6");
        });
        step("Проверяем количество добавленного товара в корзину", () -> {
            catalogPage.quantityOfGoods("2");
        });
    }

    @Test
    @Order(4)
    @Feature("Корзина товаров")
    @DisplayName("Уменьшение количества товара в корзине")
    void ReducingQuantityGoodsCartTest() {
        step("Переходим в корзину товаров", () -> {
            catalogPage.openPage();
        });
        step("Уменьшаем количество товаров на одну позицию", () -> {
            catalogPage.increaseInQuantity("1");
        });
        step("Проверяем наименование добавленного товара в корзину", () -> {
            catalogPage.productName("Apple Watch 6");
        });
        step("Проверяем оставшееся количество товара в корзине после удаления позиции", () -> {
            catalogPage.quantityOfGoods("1");
        });
    }

    @Test
    @Order(5)
    @Feature("Корзина товаров")
    @DisplayName("Применение купона")
    void applyingCouponTest() {
        step("Переходим в корзину товаров", () -> {
            catalogPage.openPage();
        });
        step("Вводим произвольный код купона в поле для ввода", () -> {
            catalogPage.setCoupon("Test123");
        });
        step("Нажимаем применить код купона", () -> {
            catalogPage.couponButton();
        });
        step("Проверяем наименование товара в корзину", () -> {
            catalogPage.productName("Apple Watch 6");
        });
        step("Проверяем количество товара в корзине", () -> {
            catalogPage.quantityOfGoods("1");
        });
        step("Проверяем текст ошибки после ввода произвольного купона", () -> {
            catalogPage.textError("Coupon \"test123\" does not exist!");
        });
    }

    @Test
    @Order(6)
    @Feature("Главная страница")
    @DisplayName("Поиск товара из строки поиска")
    void searchFromSearchBarTest() {
        step("В поле для поиска вводим наименование товара", () -> {
            homePage.searchField("Телефон");
        });
        step("Проверяем, что открылась страница с результатами введенного поиска", () -> {
            homePage.searchResults("Результаты поиска: “Телефон”");
        });
        step("На странице присутствует требуемый товар", () -> {
            homePage.searchTitle("Телефон iPhone 13");
        });
    }

    @Test
    @Order(7)
    @Feature("Оформление заказа")
    @DisplayName("Оформление заказа")
    void placingOrderTest() {
        step("Переходим на страницу оформление заказа", () -> {
            placingAnOrderPage.placingAnOrder();
        });
        step("Указываем имя", () -> {
            placingAnOrderPage.setFirstName(random.firstName);
        });
        step("Указываем фамилию", () -> {
            placingAnOrderPage.setLastName(random.lastName);
        });
        step("Указываем адрес", () -> {
            placingAnOrderPage.setAddress(random.address);
        });
        step("Указываем город", () -> {
            placingAnOrderPage.setCity(random.city);
        });
        step("Указываем область", () -> {
            placingAnOrderPage.setState(random.state);
        });
        step("Указываем индекс", () -> {
            placingAnOrderPage.setPostcode(random.postcode);
        });
        step("Указываем номер телефона", () -> {
            placingAnOrderPage.setPhoneNumber(random.phoneNumber);
        });
        step("Нажимаем на кнопку \"Оформить заказ\"", () -> {
            placingAnOrderPage.placeOrder();
        });
        step("Проверяем статус заказа", () -> {
            placingAnOrderPage.contentInner("Заказ получен");
        });
        step("Проверяем, что присутствует окно с заказом", () -> {
            placingAnOrderPage.orderOverview();
        });
        step("Проверяем поля в итоговой таблице", () -> {
            placingAnOrderPage.checkResult(fieldNames, "Сумма")
                    .checkResult(productName, "Apple Watch 6 × 1")
                    .checkResult(cartSubtotal, "35990,00₽")
                    .checkResult(paymentMethod, "Прямой банковский перевод")
                    .checkResult(total, "35990,00₽");
        });
    }

}
