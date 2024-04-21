# Проект по тестированию тестового сайта [интернет магазина Skillbox](https://intershop4.skillbox.ru/)
<p align="center">
<img title="TOnline-store-Skillbox" src="media/images/Online-store-Skillbox-screenshot.JPG">
</p>

## :scroll: Содержание

- [Используемый стек](#computer-используемый-стек)
- [Покрытый функционал](#male_detective-покрытый-функционал)
- [Запуск автотестов](#arrow_forward-запуск-автотестов)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Пример Allure-отчёта](#-пример-allure-отчёта)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testOps)
- [Интеграция с Jira](#-интеграция-с-jira)
- [Уведомления в Telegram с использованием бота](#-уведомления-в-telegram-с-использованием-бота)
- [Видео запуска тестов в Selenoid](#-видео-запуска-тестов-в-selenoid)

## :computer: Используемый стек

<p align="center">
<img width="6%" title="IntelliJ IDEA" src="media/logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="media/logo/Java.svg">
<img width="6%" title="Selenide" src="media/logo/Selenide.svg">
<img width="6%" title="Selenoid" src="media/logo/Selenoid.svg">
<img width="6%" title="Allure Report" src="media/logo/Allure_Report.svg">
<img width="5%" title="Allure TestOps" src="media/logo/AllureTestOps.svg">
<img width="6%" title="Gradle" src="media/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="media/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="media/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="media/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="media/logo/Telegram.svg">
<img width="5%" title="Jira" src="media/logo/Jira.svg">
</p>

- [x] Автотесты написаны на языке `Java`;
- [x] В качестве системы контроля версий используется `Git`;
- [x] Для тестирования использованы фреймворки `JUnit 5` и `Selenide`;
- [x] Инструментом для сборки Java-проекта является `Gradle`;
- [x] Управление удаленным браузером осуществляется с помощью `Selenoid`;
- [x] Для непрерывного выполнения тестовых сценариев используется `Jenkins`;
- [x] По результатам прогона автотестов, с помощью `Allure Report` генерируется отчет, оповещение с результатами тестов и ссылкой на отчет направляется в `Telegram-бот`;
- [x] Для управления тестированием, отслеживания результатов и анализа данных используется `Allure TestOps`;
- [x] Для управления проектом выполнена интеграция `Jira`.  

## :male_detective: Покрытый функционал

- [x] МОЙ АККАУНТ. Страница регистрации новых пользователей;
- [x] МОЙ АККАУНТ. Страница авторизации;
- [x] ГЛАВНАЯ. Поиск необходимых товаров;
- [x] КАТАЛОГ. Добавление товаров в корзину;
- [x] КОРЗИНА. Уменьшение количества товара в корзине;
- [x] КОРЗИНА. Применение неверного купона на скидку;
- [x] ОФОРМЛЕНИЕ ЗАКАЗА. Оформление заказ.

