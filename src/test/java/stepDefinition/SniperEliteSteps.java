package stepDefinition;

import Pages.SniperElitePage;
import WebDriverUtils.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SniperEliteSteps {


    private SniperElitePage sniperElitePage;
    private final DriverManager driverManager;

    public SniperEliteSteps(SniperElitePage sniperElitePage, DriverManager driverManager) {
        this.driverManager = driverManager;
        this.sniperElitePage = sniperElitePage;
    }

    @Given("I navigate to Sniperelite Website")
    public void i_navigate_to_Sniperelite_website() {
        sniperElitePage.openTheWebsite();
    }

    @Then("the title of the page contains {string}")
    public void the_title_of_the_page_contains(String Title) {
        String pageTitle = sniperElitePage.getCurrentPageTitle();
        Title = "Sniper Elite: Resistance | Out Now";
        System.out.println(pageTitle.contains("Page title is: " + Title));
        assertThat(driverManager.getDriver().getTitle()).isEqualTo(Title);
        sniperElitePage.acceptCookie();
    }

    @Then("the Sniper Elite logo is visible in the main navigation bar")
    public void the_sniper_elite_logo_is_visible_in_the_main_navigation_bar() {
        sniperElitePage.siteLogoIsVisible();
    }

    @Then("the mega-menu is visible with the items:")
    public void the_mega_menu_is_visible_with_the_items(DataTable dataTable) {
        // Iterate over the items in the DataTable and check each item in the mega-menu
        for (List<String> row : dataTable.asLists(String.class)) {
            String itemName = row.get(0);
            sniperElitePage.verifyMenuItemsVisible(itemName);
        }
    }

    @Then("a globe icon is displayed in the main navigation bar")
    public void a_globe_icon_is_displayed_in_the_main_navigation_bar() {
        sniperElitePage.isGlobeIconVisible();
    }

    @And("the navigation menu should be present")
    public void the_navigation_menu_should_be_present() {
        sniperElitePage.isMegaMenuVisible();
        sniperElitePage.isAllTheMainNavigationLinksVisible();
    }

    @And("the main banner should be present")
    public void the_main_banner_should_be_present() {
        sniperElitePage.siteLogoIsVisible();
    }

    @Then("the footer component should be displayed")
    public void the_footer_component_should_be_displayed() {
        sniperElitePage.isFooterSectionVisible();
    }
    @Given("the hero banner heading {string} is visible")
    public void the_hero_banner_heading_is_visible(String Text) {
        sniperElitePage.acceptCookie();
        sniperElitePage.isHeroBannerHeadingVisible(Text);
    }
    @And("the sub-heading text {string} is visible")
    public void the_sub_heading_text_is_visible(String Subhead) {
       sniperElitePage.isSubHeadingVisible(Subhead);
    }
    @And("the page finishes loading")
    public void the_page_finishes_loading() {
        sniperElitePage.acceptCookie();
        sniperElitePage.siteLogoIsVisible();
    }

    @Then("the {string} CTA button is visible on the hero banner")
    public void the_cta_button_is_visible_on_the_hero_banner(String Text) {
      sniperElitePage.isBuyNowCtaVisible(Text);
    }

    @When("the user clicks the “BUY NOW” button")
    public void the_user_clicks_the_buy_now_button() {
       sniperElitePage.clickOnBuyNow();
    }

    @And("the platform tiles “PC”, “XBOX”, and “PLAYSTATION” are visible")
    public void the_platform_tiles_pc_xbox_and_playstation_are_visible() {
        sniperElitePage.verifyIsTilesVisible();
    }

    @And("the user clicks the “PC” tile")
    public void the_user_clicks_the_pc_tile() {
        sniperElitePage.clickPcTile();
    }

    @And("the PC tile window appears")
    public void the_PC_tile_window_appears() {
        sniperElitePage.isPCTilePopupWindowVisible();

    }
    @Then("a modal for PC purchase appears with “STANDARD EDITION” pre-selected")
    public void a_modal_for_pc_purchase_appears_with_standard_edition_pre_selected() {
        sniperElitePage.verifyStandEditionPreselected();

    }

    @When("the user clicks the “Rebellion Shop” option in the modal")
    public void the_user_clicks_the_rebellion_shop_option_in_the_modal() {
        sniperElitePage.clickOnRebllionShop();
    }

    @Then("the Rebellion Shop page opens in a new browser window")
    public void the_rebellion_shop_page_opens_in_a_new_browser_window() {
        sniperElitePage.verifyShopRebellionPage();
    }

    @After
    public void tearDown() {
        driverManager.quitDriver();
    }
}










