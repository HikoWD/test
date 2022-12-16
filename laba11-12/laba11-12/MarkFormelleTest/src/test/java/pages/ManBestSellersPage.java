package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ManBestSellersPage extends AbstractPage {

    static final By sortListLocator = By.xpath("/html/body/div[8]/div[2]/div[3]/div/form/div/div[2]/div[1]");
    static final By priceSortParamLocator = By.xpath("/html/body/div[8]/div[2]/div[3]/div/form/div/div[2]/ul/li[5]/div[2]");

    public ManBestSellersPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public ManBestSellersPage closeSpam() {
        WebElement sortList = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(sortListLocator)).get(0);
        sortList.click();
        logger.info("spam closed");
        return this;
    }

    public ManBestSellersPage sortListOpen() {
        WebElement sortList = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(sortListLocator)).get(0);
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0, 50);
        actions.perform();
        sortList.click();
        logger.info("sort list opened");
        return this;
    }

    public ManBestSellersPage priceSortParamClick() {
        WebElement priceSortParam = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(priceSortParamLocator));
        priceSortParam.click();
        logger.info("price sort param clicked");
        return this;
    }
}
