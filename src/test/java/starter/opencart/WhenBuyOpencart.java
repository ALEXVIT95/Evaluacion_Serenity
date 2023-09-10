package starter.opencart;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.thucydides.core.annotations.Managed;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.SingleBrowser;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Managed;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import static org.assertj.core.api.Assertions.assertThat;

//@SuppressWarnings("unused")
@ExtendWith(SerenityJUnit5Extension.class)
class WhenBuyOpencart {

    /**
     * Define the webdriver instance to be used for these tests
     */
    @Managed(driver = "chrome", options = "headless")
    WebDriver driver;
    //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

    /**
     * Navigation actions. This is a UIInteraction class so it will be instantiated automatically by Serenity.
     */
    NavigateActions navigate;

    /**
     * Actions related to searches. This is a UIInteraction class so it will be instantiated automatically by Serenity.
     */
    CheckSteps checks;
    
    @CastMember(name = "Guest")
    Actor guest;
    
	@Test
	@DisplayName("1. Add a cart two items to an list")
	void addToList() {
		guest.attemptsTo(
				navigate.toTheHomePage(),
				Click.on(SearchForms.SEARCH_ITEM_1)	,
				Click.on(SearchForms.SEARCH_ITEM_2)	
		);
	}
	
	
	@Test
	@DisplayName("2. View a cart with two items and Checkout")
	void viewCart() throws InterruptedException {
		guest.attemptsTo(
				navigate.toTheCheckoutPage()
		);
		Thread.sleep(1000);
		guest.attemptsTo(
				navigate.toTheCheckoutCheckPage()
		);
	}
	
	@Test
	@DisplayName("3. Checkout Complete")
	void CheckoutComplete() throws InterruptedException {
		Thread.sleep(1000);
		guest.attemptsTo(
				navigate.toTheCheckoutCheckPage(),
				checks.checkoutinfoStep1(),
				checks.checkoutinfoStep2(),
				checks.checkoutinfoStep4(),
				checks.checkoutinfoStep5()
		);
	}
	
	@Test
	@DisplayName("4. Comfirm Order with Your order has been placed!")
	void ComfirmOrder() throws InterruptedException {
		Thread.sleep(1000);
		guest.attemptsTo(
				navigate.toTheCheckoutCheckPage()
			);
				checks.checkoutcomplete();
	}
}
