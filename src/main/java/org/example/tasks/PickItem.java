package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.pageObject.OpenCart_MainPage;
import org.openqa.selenium.*;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class PickItem implements Task {
    @Override
    public <T extends Actor> void performAs(T t) {
        int i = 0;
        int cantidad = Integer.parseInt(t.recall("cantidad"));
        List<WebElement> listaElementos = getDriver().findElements(By.cssSelector("#content > div:nth-child(3) > div > div > div:nth-child(2) > div.button-group > button:nth-child(1)"));
        for (WebElement element : listaElementos) {
            element.click();
            i++;
            if (i == cantidad) break;
        }

    }
}