package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage extends AbstractPage {

      static final By shirtLocator = By.xpath("//img[@alt='Однотонная футболка с v-образным вырезом в оттенке \"турмалин\"']");
    private final By spamLocator = By.xpath("//*[@id=\"popmechanic-form-45978\"]/div");

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public SearchPage closeSpam() {
       CustomDelay(5);
        WebElement spam = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(spamLocator));
        spam.click();
        logger.info("spam closed");
        return this;
    }

    public ShirtPage shirtClick(){
        WebElement shirt = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(shirtLocator)).get(0);
        Actions actions = new Actions(driver);
        actions.scrollToElement(shirt);
        actions.scrollByAmount(0, 200);
        actions.perform();
        shirt.click();
        logger.info("shirt clicked");
        return new ShirtPage(driver);
    }
}
