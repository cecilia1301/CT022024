package loginTestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonMethods.GlobalVariables;
import navigationPages.LoginPage;
import setupDriver.SetupDriver;

public class TC01_Login {
	
	//Declarar e inicializar el WebDriver
	WebDriver driver = SetupDriver.setupDriver();
	
	//PageObjects
	LoginPage loginPage = new LoginPage(driver);
	
	@BeforeTest
	public void startWebDriver() {
		driver.get(GlobalVariables.HOME_PAGE);
	}
	
  @Test
  public void TC01() {
	  loginPage.login(GlobalVariables.STANDARD_USER, GlobalVariables.PASSWORD);
  }
  
  @AfterTest
  public void closeDriver() {
	  driver.quit();
  }
}

