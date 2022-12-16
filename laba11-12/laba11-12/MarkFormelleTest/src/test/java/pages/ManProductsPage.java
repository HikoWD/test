package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ManProductsPage extends AbstractPage {

    static final By colorListLocator = By.xpath("/html/body/div[8]/div[2]/div[3]/div/form/div/div[1]/ul/li[2]/div/div[1]/span");
    static final By sizeListLocator = By.xpath("/html/body/div[8]/div[2]/div[3]/div/form/div/div[1]/ul/li[3]/div/div[1]/span");
    static final By whiteColorLocator = By.xpath("/html/body/div[8]/div[2]/div[3]/div/form/div/div[1]/ul/li[2]/div/div[2]/ul/li[2]/label/span[1]");
    static final By sizeMLocator = By.xpath("/html/body/div[8]/div[2]/div[3]/div/form/div/div[1]/ul/li[3]/div/div[2]/ul/li[4]/label/span[1]");
    static final By clearFiltersLocator = By.xpath("/html/body/div[8]/div[3]/div[1]/a");
    static final By spamLocator = By.xpath("/html/body/div[1]/div/div[1]/div[1]/div/div");
    static final By availabilityInStoresButtonLocator = By.xpath("/html/body/div[8]/div[2]/div[2]/div");
    static final By storeAddressLocator = By.xpath("/html/body/div[2]/div/div[1]/div/div/div[2]/div/ul[2]/li[1]/div[1]/ul/li[2]");
    static final By applyButtonLocator = By.xpath("/html/body/div[2]/div/div[1]/div/div/div[2]/div/ul[2]/li[1]/div[1]/div[2]/a/span");

    public ManProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ManProductsPage colorListOpen(){
        WebElement color = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(colorListLocator));
        color.click();
        logger.info("color list opened");
        return this;
    }

    public ManProductsPage choseWhiteColor(){
        WebElement whiteColor = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(whiteColorLocator));
        whiteColor.click();
        logger.info("white color chosen");
        return this;
    }

    public ManProductsPage sizeListOpen(){
        CustomDelay(4);
        WebElement sizeList = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(sizeListLocator));
        sizeList.click();
        logger.info("size list opened");
        return this;
    }

    public ManProductsPage choseSizeM(){
        WebElement sizeM = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(sizeMLocator));
        sizeM.click();
        logger.info("size m chosen");
        return this;
    }

    public  ManProductsPage clearFiltersClick(){
        WebElement clearFilters = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(clearFiltersLocator));
        clearFilters.click();
        logger.info("filter list cleared");
        return this;
    }

    public ManProductsPage closeSpam(){
        CustomDelay(20);
        WebElement spam = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(spamLocator));
        spam.click();
        logger.info("spam closed");
        return this;
    }

    public ManProductsPage AvailabilityInStoresOpen(){
        WebElement availabilityInStores = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(availabilityInStoresButtonLocator));
        availabilityInStores.click();
        logger.info("availability stores opened");
        return this;
    }

    public ManProductsPage chooseStore(){
        WebElement storeAddress = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(storeAddressLocator));
        storeAddress.click();
        logger.info("store chosen");
        return this;
    }

    public ManProductsPage apply(){
        WebElement applyButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(applyButtonLocator));
        applyButton.click();
        logger.info("apply");
        return this;
    }
}
