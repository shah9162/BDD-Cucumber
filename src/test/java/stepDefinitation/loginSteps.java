package stepDefinitation;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class loginSteps {
	WebDriver driver;
	ChromeOptions options = new ChromeOptions();

	@Given("I am on the login page")
	public void i_am_on_the_login_page() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://koinpro.io/portal/auth/login");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@When("I enter my user id {string} and password {string}")
	public void i_enter_my_user_id_and_password(String userId, String Password) {
		WebElement userid = driver.findElement(By.xpath("//input[contains(@type,'email')]"));
		userid.sendKeys(userId);
		WebElement password = driver.findElement(By.xpath("//input[contains(@name,'password')]"));
		password.sendKeys(Password);
	}

	@When("I click on the login button")
	public void i_click_on_the_login_button() throws InterruptedException {
		WebElement Login = driver.findElement(By.xpath("//button[contains(@type,'submit')]"));
		Login.click();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}

	@Then("I should be redirected to my account dashboard")
	public void i_should_be_redirected_to_my_account_dashboard() {
		if (driver.getPageSource().contains("Logged In Successfully.")) {
			Assert.assertTrue(true);
			driver.close();
		} else {
			Assert.assertTrue(false);
		}
	}

	@Then("I should see an error message {string}")
	public void i_should_see_an_error_message(String String) {
		if (driver.getPageSource().contains(String)) {
			Assert.assertTrue(true);
			driver.close();
		} else {
			Assert.assertTrue(false);
		}
	}
	
}
