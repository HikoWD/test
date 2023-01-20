package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private static final String HOMEPAGE_URL = "https://markformelle.by/";
    private final WebDriver driver;
    @FindBy(xpath = "//footer")
    private WebElement footer;
    @FindBy(xpath = "//a[@href='/info/kontakty/']")
    private WebElement linkToContacts;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public void scrollToFooter(){
        Actions actions = new Actions(driver);
        actions.scrollToElement(footer);
        actions.perform();
    }
    public void scrollToContactsAndClick(){
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0, -200);
        actions.moveToElement(linkToContacts).click();
        actions.perform();
    }
}
