package starter.opencart;

import org.openqa.selenium.By;

public class SearchForms {
    public static By SEARCH_ITEM_1 = By.xpath("//div[2]/div/div/div[2]/div[1]/div/div[3]/button[1]");
    public static By SEARCH_ITEM_2 = By.xpath("//div[2]/div[2]/div/div[2]/div[2]/div/div[3]/button[1]");
    public static By SEARCH_BUTTON = By.xpath("(//input[contains(@id,'search_button_homepage')] | //button[contains(@class, 'search')])");
}