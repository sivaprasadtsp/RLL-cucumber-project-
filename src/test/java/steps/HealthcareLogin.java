package steps;

import static org.testng.Assert.assertNotEquals;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HealthcareLogin {
	WebDriver driver;
	@Given("User opens the Healthcare page in chrome")
	public void user_opens_the_healthcare_page_in_chrome() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		String ActualTitle= driver.getTitle();
		String ExpectedTitle= "Login";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		
		Thread.sleep(1500);
	}

	@Then("User enters Following Username and Password")
	public void user_enters_following_username_and_password(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
List<Map<String, String>> userList	= dataTable.asMaps(String.class, String.class);
		
		for(Map<String, String> e : userList) {
			driver.findElement(By.id("username")).sendKeys(e.get("Username"));
			driver.findElement(By.id("password")).sendKeys(e.get("password"));

			Thread.sleep(1500);
		}
	}

	@Then("User choose the Location")
	public void user_choose_the_location() throws InterruptedException {
	    driver.findElement(By.xpath("//li[@id='Registration Desk']")).click();
	    Thread.sleep(1500);
	}

	@Then("User clicks On login")
	public void user_clicks_on_login() throws InterruptedException {
	    driver.findElement(By.xpath("//input[@type = 'submit']")).click();
	    Thread.sleep(1500);
	 
        String expectedTitle = "Expected Title"; // Replace with the expected title
        assertNotEquals(driver.getTitle(), expectedTitle, "Title does not match the expected value");

        
       
	    driver.close();
	}
}
