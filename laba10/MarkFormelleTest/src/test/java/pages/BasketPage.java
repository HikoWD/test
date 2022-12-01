package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class BasketPage {
    WebDriver driver;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@data-entity='basket-item-delete']")
    private WebElement deleteButton;

    public void scrollAndDeleteButtonClick() throws InterruptedException {
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.scrollToElement(deleteButton);
        actions.perform();
        Thread.sleep(2000);
        deleteButton.click();
    }
}
