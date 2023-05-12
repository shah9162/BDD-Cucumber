package stepDefinitation;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class signUpSteps {
	WebDriver driver;
	ChromeOptions options = new ChromeOptions();

	@Given("I am on the SignUp page")
	public void i_am_on_the_sign_up_page() {
		WebDriverManager.chromedriver().setup();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://koinpro.io/portal/auth/signUp");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@When("I enter my name as {string}")
	public void i_enter_my_name_as(String Name) {
		driver.findElement(By.id("register-username")).sendKeys(Name);
	}

	@When("I enter my email as {string}")
	public void i_enter_my_email_as(String Email) {
		driver.findElement(By.id("register-email")).sendKeys(Email);
	}

	@When("I enter my MobileNumber as {string}")
	public void i_enter_my_mobile_number_as(String Mobile) {
		driver.findElement(By.id("register-mobile")).sendKeys(Mobile);
	}

	@When("I enter my password as {string}")
	public void i_enter_my_password_as(String Password) {
		driver.findElement(By.id("register-password")).sendKeys(Password);
	}

	@When("I click on the SignUp button")
	public void i_click_on_the_sign_up_button() throws InterruptedException {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
	}
	
	@Then("I should see an Error message {string}")
	public void i_should_see_an_error_message(String msg) {
		System.out.println(" Assertion message : "+msg);
		Boolean br = driver.getPageSource().contains("Check T&C");
		System.out.println(br);
		if (driver.getPageSource().contains(msg)) {
			Assert.assertTrue(true);
			driver.close();
		} else {
			Assert.assertTrue(false);
		}
	   
	}

}
