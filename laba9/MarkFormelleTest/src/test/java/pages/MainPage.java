package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class MainPage {
    private static final String HOMEPAGE_URL = "https://markformelle.by/";
    private final WebDriver driver;

    @FindBy(xpath = "/html/body/footer/div/div[1]/div[4]/div[2]/ul/li[3]")
    private WebElement searchButton;
    @FindBy(xpath = "/html/body/footer/div/div[1]/div[4]/div[2]/ul/li[3]/a")
    private WebElement scroll;

//    @FindBy(xpath = "//input[@id='ac-gn-searchform-input']")
//    private WebElement searchInput;
//
//    @FindBy(xpath = "//div[@class='as-pinwheel15-section as-pinwheel15-smalltile as-pinwheel15-smalltileleft as-pinwheel15-tile3 as-util-relatedlink relatedlink']")
//    private WebElement accessoryButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public void scrollTo(){
        //driver.findElement(By.xpath("//*[text()='ftr-row']"));
        Actions actions = new Actions(driver);
        //actions.moveToElement(driver.findElement(By.xpath("//*[text()='fix-block brfid']")));
        actions.scrollByAmount(0, 1500);
        actions.perform();
        scroll.click();
    }

//    public void enterSearchText(String searchText) {
//        searchInput.sendKeys(searchText);
//        searchInput.submit();
//    }
//
//    public void enterAccessory() {
//        accessoryButton.click();
//    }

    public void searchClick() {
        searchButton.click();
    }
}
