package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://markformelle.by/";
    // private final WebDriver driver;

    private final By footerLocator = By.xpath("//footer");
    private final By contactsLocator = By.xpath("/html/body/footer/div/div[1]/div[4]/div[2]/ul/li[3]/a");
    private final By searchValue = By.xpath("//input[@class='search-active-desc']");

    private final By catalogLocator = By.xpath("//div[@class='hamburger-text']");

    private final By manLocator = By.xpath("//a[text()='Мужчинам']");
    private final By bestSellersLocator = By.xpath("//a[@href='/catalog/muzhchinam/sale-leaders/']");
    private final By spamLocator = By.xpath("/html/body/div[1]/div/div[1]/div[1]/div/div");
    private final By socksLocator = By.xpath("/html/body/div[5]/div/div[1]/div[3]/ul/li[4]/ul/li[4]/a/span");

    private final By socksPageLocator = By.xpath("/html/body/div[5]/div/div[1]/div[3]/ul/li[4]/ul/li[4]/ul/li[1]/a");
    private final By allProductsForMansLocator = By.xpath("/html/body/div[5]/div/div[1]/div[3]/ul/li[4]/ul/li[1]/a");

    private final By countryButtonLocator = By.xpath("/html/body/div[2]/div/div[3]/div/div/div[2]/a[2]");

    private final By listOfStoresLocator = By.className("header-location");



    // private final By spamLocator = By.xpath("//div[@class='popmechanic-close");

//    @FindBy(xpath = "//footer")
//    private WebElement footer;
    // @FindBy(xpath = "//a[@href='/info/kontakty/']")
    //  private WebElement contacts;


    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainPage openPage() {
        driver.get(HOMEPAGE_URL);
        driver.manage().window().maximize();
        logger.info("site opened");
        return this;
    }

    public MainPage scrollToFooter()  {
        WebElement footer = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(footerLocator));
        Actions actions = new Actions(driver);
        actions.scrollToElement(footer);
        actions.scrollByAmount(0, -200);
        actions.perform();
        logger.info("scrolled to footer");
        return this;
        // footer.click();
    }

    public ContactPage clickToContacts() {
        WebElement contacts = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(contactsLocator));
        contacts.click();
        logger.info("contact page opened");
        return new ContactPage(driver);
    }

    public SearchPage getProductPage(String value)  {
        WebElement search = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(searchValue));
        search.sendKeys(value);
        search.sendKeys(Keys.ENTER);
        logger.info("inputted value and opened page");
        return new SearchPage(driver);
    }

    public MainPage openCatalog(){
        WebElement catalog = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(catalogLocator));
        catalog.click();
        logger.info("catalog opened");
        return this;
    }

    public MainPage closeSpam(){
        CustomDelay(20);
        WebElement spam = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(spamLocator));
        spam.click();
        logger.info("spam closed");
        return this;
    }

    public MainPage manProductsOpen(){
        WebElement man = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(manLocator));
        man.click();
        logger.info("man products opened");
        return this;
    }

    public ManBestSellersPage bestSellersPageOpen(){
        WebElement bestSellers = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(bestSellersLocator));
        bestSellers.click();
        logger.info("best sellers page opened");
        return new ManBestSellersPage(driver);
    }

    public MainPage socksClick(){
        WebElement socks = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(socksLocator));
        socks.click();
        logger.info("clicked socks button");
        return this;
    }

    public MainPage acceptCurrentCountry(){
        CustomDelay(4);
        WebElement countryButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(countryButtonLocator));
        countryButton.click();
        logger.info("accepted country");
        return this;
    }

    public StoresPage openStoresPage(){
        CustomDelay(4);
        WebElement listOfStores = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(listOfStoresLocator));
        listOfStores.click();
        logger.info("stores page opened");
        return new StoresPage(driver);
    }

    public SocksPage socksPageOpen(){
        WebElement socksPage = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(socksPageLocator));
        socksPage.click();
        logger.info("socks page opened");
        return new SocksPage(driver);
    }

    public ManProductsPage allProductsForMansPageOpen() {
        WebElement allProductsForMans = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(allProductsForMansLocator));
        allProductsForMans.click();
        logger.info("all products for mans page opened");
        return new ManProductsPage(driver);
    }
}
