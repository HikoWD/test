package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SocksPage extends AbstractPage{

    static final By sortListLocator = By.xpath("/html/body/div[8]/div[2]/div[2]/div/form/div/div[2]/div[1]");

    static final By rateSortParamLocator = By.xpath("/html/body/div[8]/div[2]/div[2]/div/form/div/div[2]/ul/li[5]/div[2]");

    public SocksPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public SocksPage sortListOpen() {
        WebElement sortList = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(sortListLocator)).get(0);
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0, 50);
        actions.perform();
        sortList.click();
        logger.info("sort list opened");
        return this;
    }

    public SocksPage rateSortParamClick() {
        WebElement rateSortParam = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(rateSortParamLocator));
        rateSortParam.click();
        logger.info("rate sort param clicked");
        return this;
    }
}
