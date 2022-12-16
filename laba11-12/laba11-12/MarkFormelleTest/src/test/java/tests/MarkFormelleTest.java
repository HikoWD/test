package tests;

import org.testng.annotations.Test;
import pages.*;

public class MarkFormelleTest extends CommonConditions {

    @Test(description = "Поиск, добавление и удаление из корзины товара")
    public void Search_TEST() {
        new MainPage(driver)
                .openPage()
                .getProductPage("Однотонная футболка с v-образным вырезом в оттенке \"турмалин\"")
                //                .closeSpam()
                .shirtClick()
                .openListSize()
                .choseSize()
                .addToBasket()
                .openBasketPage()
                .scrollToDeleteButton()
                .DeleteButtonClick();
    }

    @Test(description = "Сортировка товара по цене")
    public void sortByPrice_TEST() {
        new MainPage(driver)
                .openPage()
                .openCatalog()
             //   .closeSpam()
                .manProductsOpen() //---
                .bestSellersPageOpen()
                .sortListOpen()
                .priceSortParamClick();
    }

    @Test(description = "Сортировка носков по рейтингу")
    public void sortSocksByRate_TEST() {
        new MainPage(driver)
                .openPage()
                .openCatalog()
                .manProductsOpen()
   //             .closeSpam()
                .socksClick()
                .socksPageOpen()
                .sortListOpen()
                .rateSortParamClick();
    }

    @Test(description = "Сортировка товаров по белому цвету, размеру M и очистка фильтров")
    public void sortGoodsByFilters_TEST() {
        new MainPage(driver)
                .openPage()
                .openCatalog()
                //.closeSpam()
                .manProductsOpen() //---
                .allProductsForMansPageOpen()
               //.closeSpam()
                .colorListOpen()
                .choseWhiteColor()
                .sizeListOpen()
                .choseSizeM()
                .clearFiltersClick();
    }

    @Test(description = "Открытие страницы контакты")
    public void openContactsPage_TEST() {
        new MainPage(driver)
                .openPage()
                .scrollToFooter()
                .clickToContacts();
    }

        @Test(description = "Посмотреть список товаров, " +
                "которые есть в наличии в магазине по адресу пр. Победителей, д.65, ТЦ \"Замок\"")
    public void showListOfGoodsInStoreAddress_TEST() {
        new MainPage(driver)
                .openPage()
                .openCatalog()
                //.closeSpam()
                .manProductsOpen()
//                .closeSpam()
                .allProductsForMansPageOpen()
                .AvailabilityInStoresOpen()
                .chooseStore()
                .apply();
    }

    @Test(description = "Посмотреть список магазинов в городе «Минск»")
    public void showListOfStoresInCountry_TEST() {
        new MainPage(driver)
                .openPage()
                .acceptCurrentCountry()
                .openStoresPage()
                .showListOfStores()
                .openListOfCountries()
                .chooseCountry()
                .openListOfCities()
                .chooseCity();
    }
}
