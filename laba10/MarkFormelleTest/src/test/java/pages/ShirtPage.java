package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class ShirtPage {
    WebDriver driver;

    @FindBy(xpath = "//div[@class='popmechanic-close']")
    private WebElement spam;
    @FindBy(xpath = "//a[text()='Да, все верно']")
    private WebElement spam22;

    @FindBy(xpath = "//div[@class='size-header closed']")
    private WebElement ListSize;

    @FindBy(xpath = "//div[@class='w25per size'][text()='M']")
    private WebElement size;

    @FindBy(xpath = "//a[@class='button-link black-tr-b btn-pink add-to-basket-pickup']")
    private WebElement basket;

    @FindBy(xpath = "//a[@href='/personal/cart/']")
    private WebElement basketPage;

    public ShirtPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void deleteSpam22() throws InterruptedException {
        Thread.sleep(15000);
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0, 50);
        actions.perform();
        Thread.sleep(30000);
        spam.click();
    }

    public void deleteSpam() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0, 50);
        actions.perform();
        Thread.sleep(30000);
        spam.click();
    }

    public void openListSize() throws InterruptedException {
        Thread.sleep(200);
        ListSize.click();
    }

    public void choseSize() throws InterruptedException {
        Thread.sleep(200);
//        Actions action = new Actions(driver);
//        action.scrollByAmount(0, 200);
//        action.perform();
       // Thread.sleep(2000);
        size.click();
    }

    public void addToBasket() throws InterruptedException {
        Thread.sleep(2000);
        basket.click();
    }

    public BasketPage openBasketPage() throws InterruptedException {
        Thread.sleep(200);
        basketPage.click();
        return new BasketPage(driver);
    }
}
