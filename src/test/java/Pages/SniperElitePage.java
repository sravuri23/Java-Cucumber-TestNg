package Pages;

import WebDriverUtils.DriverManager;
import dataProviders.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.BasePageObject;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class SniperElitePage<wait> extends BasePageObject {

    private WebDriver driver;
    private WebDriverWait wait;
    private final ConfigFileReader configFileReader;


    // Constructor that accepts DriverManager
    public SniperElitePage(DriverManager driverManager, ConfigFileReader configFileReader) {
        super(driverManager.getDriver());  // Pass WebDriver directly from DriverManager to BasePageObject
        this.driver = driverManager.getDriver(); // Set the driver
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.configFileReader = configFileReader;
    }

    // Web elements (Search Field and Cookie Accept button)
    private WebElement searchField() {
        return driver.findElement(By.cssSelector("input[id='sp-cc-accept']"));
    }

    private WebElement cookieAccept() {
        return driver.findElement(By.cssSelector("button#onetrust-accept-btn-handler"));
    }

    private WebElement cookieWindow() {
        return driver.findElement(By.cssSelector("#onetrust-banner-sdk"));
    }

    private WebElement siteLogo() {
        return driver.findElement(By.cssSelector("a.page-header__brand.hidden-mobile div.reb-media.page-header__brand-img"));
    }


    private WebElement globeIcon() {
        return driver.findElement(By.cssSelector("nav.languages .nav-item__link.is-right .nav-item__icon path"));
    }
    private WebElement megaMenuSelector(){
        return driver.findElement(By.cssSelector("nav[aria-label='Main Navigation']"));
    }

    private WebElement footerSection(){
        return driver.findElement(By.cssSelector("div.page__footer_global_wrapper"));
    }
    private  WebElement socialMediaSection(){
        return driver.findElement(By.cssSelector("div.social-media__inner"));
    }

    private WebElement heroBannerHeading(){
        return driver.findElement(By.cssSelector("h1.hero__heading.is-short span"));
    }

    private WebElement pcTile(){
        return driver.findElement(By.cssSelector(".button.edition-selector__button.is-beige"));
    }
 private WebElement xBoxTile(){
        return driver.findElement(By.cssSelector("button[aria-label='Xbox']"));
 }

 private WebElement playStationTile(){
     return driver.findElement(By.cssSelector("button[aria-label='Playstation'].edition-selector__button.is-blue"));
 }

 private WebElement pcModalWindow(){
        return  driver.findElement(By.cssSelector(".store-links.modal-card"));
 }

private  WebElement standEdition(){
        return  driver.findElement(By.cssSelector("button.button.is-primary.selected span.button__label"));
}

private  WebElement rebellionShopCta(){
        return driver.findElement(By.cssSelector("a.store-links__link.button.is-secondary.icon-right span.button__caption"));
}




    // Method to open the website
    public void openTheWebsite() {
        driver.get(configFileReader.getApplicationUrl());
    }

//    private WebElement allMegaMenuLinks(){
//        return driver.findElement(By.cssSelector(".nav-menu__list .nav-menu__list-item a.nav-item__link"));
//    }

    private  WebElement subHeadingText(){
        return driver.findElement(By.cssSelector("p.hero__body"));
    }

    private WebElement buyNowCta(){
        return driver.findElement(By.cssSelector("button.hero__link.is-large .button__label"));
    }

    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

    // Click on the search field
//    public void clickOnSearchField() {
//        waitForanElement(searchField()).click();
//    }

    public void acceptCookie() {
        try {
            WebElement cookieWindow = waitForanElement(cookieWindow());
            if (cookieWindow.isDisplayed()) {
                cookieAccept().click();
            }
        } catch (Exception e) {
            System.out.println("Cookie accept button not found or already accepted.");
        }
    }

    public void siteLogoIsVisible() {
        WebElement logo = waitForanElement(siteLogo());
        boolean visible = logo.isDisplayed();

    }

    public void isGlobeIconVisible() {
        WebElement globleIcon = waitForanElement(globeIcon());
        boolean visible = globleIcon.isDisplayed();
        if (visible) {
            System.out.println("GlobeIcon Is Visible");
        } else {
            System.out.println("GlobeIcon Not Visible");
        }
    }

    public void isPCTilePopupWindowVisible(){
        waitForanElement(pcModalWindow()).isDisplayed();
    }

    public  void isBuyNowCtaVisible(String Text){
        WebElement BuyNowCTA = waitForanElement(buyNowCta());
        boolean visible = BuyNowCTA.isDisplayed();
        String ExpectedText = BuyNowCTA.getText();
        assertThat(ExpectedText.equalsIgnoreCase(Text));
    }

    public void clickOnBuyNow(){
        acceptCookie();
        waitForanElement(buyNowCta()).click();
    }

    public void verifyStandEditionPreselected(){
        waitForanElement(standEdition());
    }

    public void clickPcTile(){
        waitForanElement(pcTile()).click();
    }

    public void clickOnRebllionShop(){
        waitForanElement(rebellionShopCta()).click();
    }
    public  void isSubHeadingVisible(String Subhead){
        WebElement subHeading = waitForanElement(subHeadingText());
        boolean visible = subHeading.isDisplayed();
        String ExpectedText = heroBannerHeading().getText();
        assertThat(ExpectedText.equalsIgnoreCase(Subhead));
    }
    public  void isHeroBannerHeadingVisible(String Text){
        WebElement heroBannerh1 = waitForanElement(heroBannerHeading());
        boolean visible = heroBannerh1.isDisplayed();
        String ExpectedText = heroBannerHeading().getText();
        assertThat(ExpectedText.equalsIgnoreCase(Text));
    }
    public void isMegaMenuVisible(){
        WebElement megaMenu= waitForanElement(megaMenuSelector());
        boolean visible =megaMenu.isDisplayed();
        if (visible) {
            System.out.println("The mega menu is visible.");
        } else {
            System.out.println("The mega menu is NOT visible.");
        }
    }

    public void isAllTheMainNavigationLinksVisible() {
        List<WebElement> menuLinks = driver.findElements(By.cssSelector("a.nav-item__link"));

        for (WebElement link : menuLinks) {
            String linkText = link.getText().trim();

            switch (linkText) {
                case "News":
                    Assert.assertTrue(link.isDisplayed());
                    System.out.println("News link is visible");
                    break;

                case "Games":
                    Assert.assertTrue(link.isDisplayed());
                    System.out.println("Games link is visible");
                    break;

                case "Support":
                    Assert.assertTrue(link.isDisplayed());
                    System.out.println("Support link is visible");
                    break;

                case "Merchandise":
                    Assert.assertTrue(link.isDisplayed());
                    System.out.println("Merchandise link is visible");
                    break;

                case "Accessibility":
                    Assert.assertTrue(link.isDisplayed());
                    System.out.println("Accessibility link is visible");
                    break;

                default:
                    System.out.println("Unexpected link: " + linkText);
            }
        }
    }

    public  void verifyMenuItemsVisible(String itemName){
            // Find all the menu links
            List<WebElement> menuLinks = driver.findElements(By.cssSelector("a.nav-item__link"));

            for (WebElement link : menuLinks) {
                String linkText = link.getText().trim();

                // Check if the link matches the passed item name
                if (linkText.equalsIgnoreCase(itemName)) {
                    // Verify if the link is displayed
                    Assert.assertTrue(link.isDisplayed());
                    System.out.println(itemName + " link is visible");
                    return; // Exit once the link is found and checked
                }
            }
            // If we don't find the link in the menu, print an error
            System.out.println("The link " + itemName + " is not found in the navigation.");
        }

    public  void isFooterSectionVisible(){
        WebElement socialMedia=  waitForanElement(socialMediaSection());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", socialMedia);
        socialMedia.isDisplayed();
        WebElement footerSection=  waitForanElement(footerSection());
       // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", socialMedia);
        footerSection.isDisplayed();
    }

    public void verifyIsTilesVisible(){
        waitForanElement(pcTile()).isDisplayed();
        waitForanElement(xBoxTile()).isDisplayed();
        waitForanElement(playStationTile()).isDisplayed();
    }

    public void verifyShopRebellionPage() {
        // Store the current window handle (main page)
        String mainWindow = driver.getWindowHandle();
        // Wait until a new window opens
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(d -> d.getWindowHandles().size() > 1);
        // Switch to the new window
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        // Verify the URL of the new pag
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("shop.rebellion.com"),
                "Expected shop URL not loaded. Actual URL: " + currentUrl);
    }


}