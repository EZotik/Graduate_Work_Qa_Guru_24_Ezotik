package tests;

import config.CredentialConfig;
import io.qameta.allure.Feature;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.*;
import utils.RandomUserDataGenerator;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static io.qameta.allure.Allure.step;

@Tag("simple_test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Тесты на работу с корзиной товаров")
public class TestsWithAddingProducts extends TestBase {
    MyAccount myAccount = new MyAccount();
    HomePage homePage = new HomePage();
    CatalogPage catalogPage = new CatalogPage();
    PlacingAnOrderPage placingAnOrderPage = new PlacingAnOrderPage();
    RandomUserDataGenerator random = new RandomUserDataGenerator();
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
            myAccount.clickLoginBtton();
        });
    }

    @Test
    @Order(1)
    @Feature("Корзина товаров")
    @DisplayName("Добавление товара в корзину")
    void addingItemToCartTest() {
        step("Открываем страницу с каталогом товаров", () -> {
            catalogPage.clickCatalogPage();
        });
        step("Кликаем по вкладке \"Часы\"", () -> {
            catalogPage.clickWatchProduct();
        });
        step("Добавляем товар в корзину", () -> {
            catalogPage.addToCart(1);
        });
        step("Переходим в корзину товаров", () -> {
            catalogPage.clickBasketPage();
        });
        step("Добавляем нужное количество товаров", () -> {
            catalogPage.increaseInQuantity("2");
        });
        step("Проверяем соответствие наименования товара в корзине", () -> {
            catalogPage.checkingNameProductInTheCard();
        });
        step("Проверяем количество добавленного товара в корзину", () -> {
            catalogPage.checkingQuantityProductInTheCard("2");
        });
    }

    @Test
    @Order(2)
    @Feature("Корзина товаров")
    @DisplayName("Уменьшение количества товара в корзине")
    void ReducingQuantityGoodsCartTest() {
        step("Переходим в корзину товаров", () -> {
            catalogPage.openPage();
        });
        step("Уменьшаем количество товаров на одну позицию", () -> {
            catalogPage.decreaseInQuantity("1");
        });
        step("Проверяем оставшееся количество товара в корзине после уменьшения позиции", () -> {
            catalogPage.checkingQuantityProductInTheCard("1");
        });
    }

    @Test
    @Order(3)
    @Feature("Корзина товаров")
    @DisplayName("Применение неверного купона")
    void applyingCouponTest() {
        step("Переходим в корзину товаров", () -> {
            catalogPage.openPage();
        });
        step("Вводим произвольный код купона в поле для ввода", () -> {
            catalogPage.setCoupon("Test123");
        });
        step("Нажимаем применить код купона", () -> {
            catalogPage.clickCouponButton();
        });
        step("Проверяем соответствие наименования товара в корзине", () -> {
            catalogPage.checkingNameProductInTheCard();
        });
        step("Проверяем количество товара в корзине", () -> {
            catalogPage.checkingQuantityProductInTheCard("1");
        });
        step("Проверяем текст ошибки после ввода произвольного купона", () -> {
            catalogPage.checkingTextError();
        });
    }

    @ValueSource(strings = {"Телефон", "Часы"})
    @ParameterizedTest(name = "Для поискового запроса с {0} должен отдаваться не пустой список карточек")
    @Order(4)
    @Feature("Главная страница")
    @DisplayName("Поиск товара из строки поиска.")
    void searchFromSearchBarTest(String searchQuery) {
        step("В поле для поиска вводим наименование товара", () -> {
            homePage.searchField(searchQuery);
        });
        step("Проверяем, что открылась страница с результатами введенного поиска", () -> {
            homePage.searchResults(searchQuery);
        });
    }

    @Test
    @Order(5)
    @Feature("Оформление заказа")
    @DisplayName("Оформление заказа")
    void placingOrderTest() {
        step("Переходим на страницу оформление заказа", () -> {
            placingAnOrderPage.clickPlacingAnOrder();
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
            placingAnOrderPage.clickPlaceOrder();
        });
        step("Проверяем статус заказа", () -> {
            placingAnOrderPage.contentInner("Заказ получен");
        });
        step("Проверяем, что присутствует окно с заказом", () -> {
            placingAnOrderPage.orderOverview();
        });
        step("Проверяем поля в итоговой таблице", () -> {
            placingAnOrderPage.checkResult(fieldNames, "Сумма").checkResult(productName, "Apple Watch 6 × 1").checkResult(cartSubtotal, "35990,00₽").checkResult(paymentMethod, "Прямой банковский перевод").checkResult(total, "35990,00₽");
        });
    }

}
