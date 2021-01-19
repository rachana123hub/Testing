package com.nlt.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.nlt.util.ExtentReportBase;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EDXTest extends ExtentReportBase {

	WebDriver driver=null;

	@BeforeTest
	public void DriverSetup() {

		//		WebDriverManager.firefoxdriver().setup();
		//		driver=new FirefoxDriver();

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.edx.org/");
	}

	@Test(priority = 1)
	public void SearchTest() throws InterruptedException {

		test= extent.createTest("Search Tab Test","Sample discribe the EDX search test");
		
		//search the content on search tab
		driver.findElement(By.id("home-search")).sendKeys("Software");
		//click on search button
		driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
		Thread.sleep(3000);
	}
	

	@Test(dataProvider = "test1Data", dataProviderClass = com.nlt.util.ExcelDataProvider.class, priority = 2)
	public void registrationFormTest(String fullname, String username, String emailId, String password) throws InterruptedException {

		test= extent.createTest("Registeration Test","Sample discribe the registeration form  test");
	
		//click on register button
		driver.findElement(By.linkText("Register")).click();
		//enter fullname
		driver.findElement(By.xpath("//input[@id='register-name']")).sendKeys(fullname);
		//enter public username
		driver.findElement(By.name("username")).sendKeys(username);
		//enter emailId
		driver.findElement(By.name("email")).sendKeys(emailId);
		//enter password
		driver.findElement(By.name("password")).sendKeys(password);
		//select country
		Select country = new Select(driver.findElement(By.name("country")));
		country.selectByValue("IN");

		//driver.findElement(By.id("toggle_optional_fields")).click();
		//driver.findElement(By.xpath("//button[contains(text(),'Create Account')]"));


		//Thread.sleep(3000);

	}


	@Test(dataProvider = "test2Data", dataProviderClass = com.nlt.util.ExcelDataProvider.class , priority = 3)
	public void loginTest( String emailId, String password) throws InterruptedException {

		test= extent.createTest("Login Test","Sample discribe the login and logout test");

		//click on sign in after register
		driver.findElement(By.linkText("Sign in.")).click();
		//enter login emailId
		driver.findElement(By.id("login-email")).sendKeys(emailId);
		//enter password
		driver.findElement(By.name("password")).sendKeys(password);
		//click on login button
		driver.findElement(By.xpath("//body/div[2]/div[2]/div[1]/main[1]/div[1]/div[1]/section[1]/div[1]/form[1]/button[1]")).click();
		//click on user menu list
		driver.findElement(By.xpath("//div[contains(@class, 'toggle-user-dropdown')]")).click();
		//open the list menu
		driver.findElement(By.xpath("//div[contains(@class, 'open')]"));
		//click on sign out
		driver.findElement(By.linkText("Sign Out")).click();

		//Thread.sleep(3000);


	}

	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
	}


}
