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


public class SniperElitePage extends BasePageObject {
    private WebDriver driver;
    private WebDriverWait wait;
    private final ConfigFileReader configFileReader;

    public SniperElitePage(DriverManager driverManager, ConfigFileReader configFileReader) {
        super(driverManager.getDriver());
        this.driver = driverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.configFileReader = configFileReader;
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

    private WebElement megaMenuSelector() {
        return driver.findElement(By.cssSelector("nav[aria-label='Main Navigation']"));
    }

    private WebElement footerSection() {
        return driver.findElement(By.cssSelector("div.page__footer_global_wrapper"));
    }

    private WebElement socialMediaSection() {
        return driver.findElement(By.cssSelector("div.social-media__inner"));
    }

    private WebElement heroBannerHeading() {
        return driver.findElement(By.cssSelector("h1.hero__heading.is-short span"));
    }

    private WebElement pcTile() {
        return driver.findElement(By.cssSelector(".button.edition-selector__button.is-beige"));
    }

    private WebElement xBoxTile() {
        return driver.findElement(By.cssSelector("button[aria-label='Xbox']"));
    }

    private WebElement playStationTile() {
        return driver.findElement(By.cssSelector("button[aria-label='Playstation'].edition-selector__button.is-blue"));
    }

    private WebElement pcModalWindow() {
        return driver.findElement(By.cssSelector(".store-links.modal-card"));
    }

    private WebElement standEdition() {
        return driver.findElement(By.cssSelector("button.button.is-primary.selected span.button__label"));
    }

    private WebElement rebellionShopCta() {
        return driver.findElement(By.cssSelector("a.store-links__link.button.is-secondary.icon-right span.button__caption"));
    }

    public void openTheWebsite() {
        driver.get(configFileReader.getApplicationUrl());
    }

    private WebElement subHeadingText() {
        return driver.findElement(By.cssSelector("p.hero__body"));
    }

    private WebElement buyNowCta() {
        return driver.findElement(By.cssSelector("button.hero__link.is-large .button__label"));
    }


//Shop Reblion

    private WebElement rebllionCookiePopUp() {
        return driver.findElement(By.cssSelector("section#shopify-pc__banner.shopify-pc__banner__dialog"));
    }

    private WebElement rebellionAcceptCookie() {
        return driver.findElement(By.cssSelector("#shopify-pc__banner__btn-accept"));
    }

    private WebElement standardEditionButton() {
        return driver.findElement(By.xpath("//span[text()='Standard Edition']"));
    }


    private WebElement xsSizeSelected() {
        return driver.findElement(By.xpath("//span[text()='XS']"));
    }

    private WebElement qtyOne() {
        return driver.findElement(By.cssSelector("input.quantity__input[name='quantity']"));

    }

    private WebElement addToCart() {
        return driver.findElement(By.cssSelector(".product-form__btn[aria-label='Add to cart']"));
    }

    private WebElement cartDrawer() {
        return driver.findElement(By.cssSelector("#CartDrawer[data-with-overlay='only-desktop']"));
    }

    private WebElement productSubHeading() {
        return driver.findElement(By.cssSelector("cart-drawer-items-block[block-id='items'] form"));
    }

    private WebElement goToCartCta() {
        return driver.findElement(By.cssSelector("a[aria-label='Go to cart']"));
    }

    private WebElement checkOutCta() {
        return driver.findElement(By.cssSelector("#checkout"));
    }


    public String getCurrentPageTitle() {
        return driver.getTitle();
    }


    public void verifyHomePageTitle(String Title) {
        driver.getCurrentUrl();
        Title = "Sniper Elite: Resistance | Out Now";
        assertThat(driver.getTitle().equalsIgnoreCase(Title));

    }

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

    public void isPCTilePopupWindowVisible() {
        waitForanElement(pcModalWindow()).isDisplayed();
    }

    public void isBuyNowCtaVisible(String Text) {
        WebElement BuyNowCTA = waitForanElement(buyNowCta());
        boolean visible = BuyNowCTA.isDisplayed();
        String ExpectedText = BuyNowCTA.getText();
        assertThat(ExpectedText.equalsIgnoreCase(Text));
    }

    public void clickOnBuyNow() {
        acceptCookie();
        waitForanElement(buyNowCta()).click();
    }

    public void verifyStandEditionPreselected() {
        waitForanElement(standEdition());
    }

    public void clickPcTile() {
        waitForanElement(pcTile()).click();
    }

    public void clickOnRebllionShop() {
        waitForanElement(rebellionShopCta()).click();
    }

    public void isSubHeadingVisible(String Subhead) {
        WebElement subHeading = waitForanElement(subHeadingText());
        boolean visible = subHeading.isDisplayed();
        String ExpectedText = heroBannerHeading().getText();
        assertThat(ExpectedText.equalsIgnoreCase(Subhead));
    }

    public void isHeroBannerHeadingVisible(String Text) {
        WebElement heroBannerh1 = waitForanElement(heroBannerHeading());
        boolean visible = heroBannerh1.isDisplayed();
        String ExpectedText = heroBannerHeading().getText();
        assertThat(ExpectedText.equalsIgnoreCase(Text));
    }

    public void isMegaMenuVisible() {
        WebElement megaMenu = waitForanElement(megaMenuSelector());
        boolean visible = megaMenu.isDisplayed();
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

    public void verifyMenuItemsVisible(String itemName) {
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

    public void isFooterSectionVisible() {
        WebElement socialMedia = waitForanElement(socialMediaSection());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", socialMedia);
        socialMedia.isDisplayed();
        WebElement footerSection = waitForanElement(footerSection());
        // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", socialMedia);
        footerSection.isDisplayed();
    }

    public void verifyIsTilesVisible() {
        boolean actualPC = waitForanElement(pcTile()).isDisplayed();
        boolean actualXBOX = waitForanElement(xBoxTile()).isDisplayed();
        boolean actualPlaystation = waitForanElement(playStationTile()).isDisplayed();
    }


    public void verifyShopRebellionPage() {
        String mainWindow = driver.getWindowHandle();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(d -> d.getWindowHandles().size() > 1);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("shop.rebellion.com"),
                "Expected shop URL not loaded. Actual URL: " + currentUrl);
    }

//shop Rebellion

    public void isShopCookiePopUpDisplayed() {
        try {
            WebElement cookieWindow = waitForanElement(rebllionCookiePopUp());
            if (rebllionCookiePopUp().isDisplayed()) {
                rebellionAcceptCookie().click();
            }
        } catch (Exception e) {
            System.out.println("Cookie accept button not found or already accepted.");
        }
        waitForanElement(rebllionCookiePopUp()).isDisplayed();

    }

    public void isXSSizePreselected() {
        WebElement element = waitForanElement(xsSizeSelected());
        Assert.assertEquals(element.getText().trim(), "XS");
    }

    public void isStandardEditionPreselected() {
        WebElement element = waitForanElement(standardEditionButton());
        Assert.assertEquals(element.getText().trim(), "Standard Edition");
    }

    public void quantityCheck() {
        WebElement qtyValue = waitForanElement(qtyOne());
        String qtyDefault = qtyValue.getAttribute("Value");
        Assert.assertEquals("1", qtyDefault);
    }


    public void clickOnAddToCart() {
        waitForanElement(addToCart()).click();
    }

    public void isCartDrawerOverlayVisible() {
        waitForanElement(cartDrawer()).isDisplayed();
    }


    public void verifyProductSubHeadInCart() {
        String productHeadingText = waitForanElement(xsSizeSelected()).getText();
        String overlayCartProductSubText = waitForanElement(productSubHeading()).getText();
        assertThat(productHeadingText.contains(overlayCartProductSubText));
    }


    public void clickOnGoToCart(String AddToCart) {
        boolean goToCart = waitForanElement(goToCartCta()).isDisplayed();
        Assert.assertTrue(goToCart);
        waitForanElement(checkOutCta()).isDisplayed();
        waitForanElement(goToCartCta()).click();
        driver.getCurrentUrl().contains("/cart");

    }

}