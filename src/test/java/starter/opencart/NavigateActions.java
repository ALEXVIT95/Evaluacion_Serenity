package starter.opencart;

import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.annotations.Step;
import net.serenitybdd.screenplay.actions.Open;

/**
 * UIInteractionSteps let us define action classes which regroup related actions.
 * The @Step annotation is used to indicate that this action will appear as a step in the reports.
 */
public class NavigateActions extends UIInteractions {
    @Step("Navigate to the home page")
    public Performable toTheHomePage() {
    	return Open.url("http://opencart.abstracta.us/");
    }
    @Step("Navigate to the Checkout Page")
    public Performable toTheCheckoutPage() {
       return Open.url("http://opencart.abstracta.us:80/index.php?route=checkout/cart");
    }
    @Step("Navigate to the Checkout Check Page")
    public Performable toTheCheckoutCheckPage() {
       return Open.url("https://opencart.abstracta.us/index.php?route=checkout/checkout");
    }
}
