package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    WebDriver driver;

    @FindBy(xpath = "//img[@alt='Однотонная футболка с v-образным вырезом в оттенке \"турмалин\"']")
    private WebElement shirt;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ShirtPage shirtClick() throws InterruptedException {
        Thread.sleep(200);
        shirt.click();
        return new ShirtPage(driver);
    }
}
