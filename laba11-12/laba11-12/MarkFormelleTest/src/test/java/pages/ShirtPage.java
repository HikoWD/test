package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class ShirtPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='popmechanic-close']")
    private WebElement spam;
    @FindBy(xpath = "//a[text()='Да, все верно']")
    private WebElement spam22;

    static final By ListSizeLocator = By.xpath("//div[@class='size-header closed']");
    static final By sizeLocator = By.xpath("//div[@class='w25per size'][text()='M']");
    static final By basketLocator = By.xpath("//a[@class='button-link black-tr-b btn-pink add-to-basket-pickup']");
    static final By basketPageLocator = By.xpath("//a[@href='/personal/cart/']");

    public ShirtPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ShirtPage openListSize()  {
        WebElement ListSize = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(ListSizeLocator));
        ListSize.click();
        logger.info("list size opened");
        return this;
    }

    public ShirtPage choseSize() {
        WebElement size = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(sizeLocator));
        size.click();
        logger.info("size chosen");
        return this;
    }

    public ShirtPage addToBasket()  {
        WebElement basket = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(basketLocator));
        basket.click();
        logger.info("added to basket");
        return this;
    }

    public BasketPage openBasketPage()  {
        WebElement basketPage = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(basketPageLocator));
        basketPage.click();
        logger.info("basket page opened");
        return new BasketPage(driver);
    }
}
