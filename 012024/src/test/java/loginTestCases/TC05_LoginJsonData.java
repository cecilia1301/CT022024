package loginTestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonMethods.GlobalVariables;
import commonMethods.WrapClass;
import navigationPages.LoginPage;
import setupDriver.SetupDriver;

public class TC05_LoginJsonData {

	// Declarar e inicializar el WebDriver
	WebDriver driver = SetupDriver.setupDriver();

	// PageObjects
	LoginPage loginPage = new LoginPage(driver);

	@BeforeTest
	public void startWebDriver() {
		driver.get(GlobalVariables.HOME_PAGE);
	}

	@Test
	public void TC05() {

		String user = WrapClass.getJsonValue("TC_05", "username");
		String pwd = WrapClass.getJsonValue("TC_05", "password");

		loginPage.login(user, pwd);
	}

	@AfterTest
	public void closeDriver() {
		WrapClass.takeScreenshot(driver, "TC05_Login");
		driver.quit();
	}
}
