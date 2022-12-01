package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
    WebDriver driver;

    @FindBy(xpath = "//input[@class='search-active-desc']")
    private WebElement searchValue;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void inputSearchValue() throws InterruptedException {
        Thread.sleep(2000);
        searchValue.sendKeys("Однотонная футболка с v-образным вырезом в оттенке \"турмалин\"");
    }

    public SearchPage enterSearchValue() throws InterruptedException {
        Thread.sleep(200);
        searchValue.sendKeys(Keys.RETURN);
        return new SearchPage(driver);
    }
}
