package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class SearchAccessoriesTest {
    private WebDriver driver;
    MainPage mainPage;

    @BeforeMethod
    public void driverSetup() {
        driver = new ChromeDriver();
    }

    @Test
    public void Test() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.scrollToFooter();

        ContactPage contactPage = mainPage.scrollToContactsAndClick();
        contactPage.inputSearchValue();

        SearchPage searchPage = contactPage.enterSearchValue();

        ShirtPage shirtPage = searchPage.shirtClick();

        shirtPage.openListSize();
        shirtPage.choseSize();
        shirtPage.addToBasket();

        BasketPage basketPage = shirtPage.openBasketPage();
        basketPage.scrollAndDeleteButtonClick();
    }

//    @AfterMethod(alwaysRun = true)
//    public void browserTearDown() throws InterruptedException {
//        Thread.sleep(5000);
//        driver.quit();
//        driver = null;
//    }
}
