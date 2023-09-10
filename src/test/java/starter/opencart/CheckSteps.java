package starter.opencart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.questions.Text;


public class CheckSteps {
	public static WebDriver driver;
	public static Performable viewcart() throws InterruptedException {
		Thread.sleep(1000);
		return Click.on(By.id("shopping_cart_container"));
	}
	public static Performable checkout() throws InterruptedException {
		Thread.sleep(1000);
		return Click.on(By.xpath("//div[2]/div[2]/div/div[3]/div[2]/a"));
	}
	public static Performable checkoutinfoStep1() throws InterruptedException {
		Thread.sleep(1000);
		Click.on(By.xpath("//div[2]/div/div/div/div[1]/div[2]/div/div/div[1]/div[2]/label"));
		Thread.sleep(1000);
		return Click.on(By.id("button-account"));
	}
	public static void ConfigurarDriver() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver= new ChromeDriver();
	}
	
	public static Performable checkoutinfoStep2() throws InterruptedException {
		Thread.sleep(1000);
		ConfigurarDriver();
		Select selectcountry = new Select((WebElement) By.id("input-payment-country"));		
		Select selectstate = new Select(driver.findElement(By.id("input-payment-zone")));	
		WebElement fname = driver.findElement(By.id("input-payment-firstname"));	
		WebElement lname = driver.findElement(By.id("input-payment-lastname"));
		WebElement email = driver.findElement(By.id("input-payment-email"));	
		WebElement phone = driver.findElement(By.id("input-payment-telephone"));	
		WebElement address = driver.findElement(By.id("input-payment-address-1"));	
		WebElement city = driver.findElement(By.id("input-payment-city"));	
		WebElement zcode = driver.findElement(By.id("input-payment-postcode"));	
		
		UserInfo infouser = new UserInfo();
		fname.sendKeys(infouser.getFirstname());
		lname.sendKeys(infouser.getLastname());
		email.sendKeys(infouser.getEmail());
		phone.sendKeys(infouser.getPhone());
		address.sendKeys(infouser.getAddress());		
		city.sendKeys(infouser.getCity());
		zcode.sendKeys(infouser.getPostalcode());
		selectcountry.selectByValue(infouser.countryvalue);
		Thread.sleep(1000);
		selectstate.selectByValue(infouser.statevalue);
		
		Thread.sleep(1000);
		return Click.on(By.id("button-guest"));
	}
public static Performable checkoutinfoStep4() throws InterruptedException {
	Thread.sleep(1000);
		return Click.on(By.id("button-shipping-method"));
	}
public static Performable checkoutinfoStep5() throws InterruptedException {
	Thread.sleep(1000);
	Click.on(By.name("agree"));
	Thread.sleep(1000);
	return Click.on(By.id("button-payment-method"));
}
	public static Question<String> checkoutcomplete() throws InterruptedException {
		Thread.sleep(1000);
		Click.on(By.id("button-confirm"));
		Thread.sleep(1000);
		if(Text.of(By.xpath("//div[2]/div/div/h1")).equals("Your order has been placed!")) {
			System.out.println("Confirmacion Correcta: Your order has been placed! ");	
		}else {
			System.out.println(Text.of(By.xpath("//div[2]/div/div/h1")));	
		}
		return Text.of(By.xpath("//div[2]/div/div/h1"));
	}
	
}