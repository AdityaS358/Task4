package Feature;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginStep {
	WebDriver driver;
	
	@Given("User is on Home Page")
	public void user_is_on_home_page() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Drivers\\Chrome Driver\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}

	@When("User enters username and password from Excel")
	public void user_enters_username_and_password_from_excel() throws IOException, InterruptedException {
		Object[][] data = ReadExcel.readData("D:\\Worldline Training\\dataprovider.xlsx", "Sheet1");
        String username = (String) data[0][0];
        String password = (String) data[0][1];

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(5000);
	}

	@Then("User clicks on login button")
	public void user_clicks_on_login_button() {
		WebElement login=driver.findElement(By.name("login-button"));
	    login.click();
	}

	@Then("User should be logged in")
	public void user_should_be_logged_in() {
		System.out.println("Login Successfully");
	}

}
