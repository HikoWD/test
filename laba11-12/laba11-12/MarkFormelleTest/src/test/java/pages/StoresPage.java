package pages;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StoresPage extends AbstractPage{
    static final By shopListLocator = By.className("mf-shoplist-shops");
    static final By listOfCountriesLocator = By.xpath("/html/body/section/div/div[3]/div[1]/div/div[1]/div[1]");
    static final By countryLocator = By.xpath("/html/body/section/div/div[3]/div[1]/div/div[2]/ul/li[3]");

    static final By listOfCitiesLocator = By.xpath("/html/body/section/div/div[3]/div[2]/div/div[1]/div[1]");

    static final By cityLocator = By.xpath("/html/body/section/div/div[3]/div[2]/div/div[2]/ul/li[62]");

    public StoresPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public StoresPage showListOfStores(){
        WebElement shopList = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(shopListLocator));
        shopList.click();
        return this;
    }

    public StoresPage openListOfCountries(){
        WebElement listOfCountries = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(listOfCountriesLocator));
        listOfCountries.click();
        logger.info("list of countries opened");
        return this;
    }

    public StoresPage chooseCountry(){
        WebElement country = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(countryLocator));
        country.click();
        logger.info("country chosen");
        return this;
    }
    public StoresPage openListOfCities(){
        WebElement listOfCities = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(listOfCitiesLocator));
        listOfCities.click();
        logger.info("list of cities opened");
        return this;
    }
    public StoresPage chooseCity(){
        WebElement city = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(cityLocator));
        Actions actions = new Actions(driver);
        actions.scrollToElement(city);
        city.click();
        logger.info("city chosen");
        return this;
    }
}
