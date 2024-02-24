package loginTestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonMethods.GlobalVariables;
import commonMethods.WrapClass;
import navigationPages.LoginPage;
import setupDriver.SetupDriver;

public class TC06_LoginJsonData {

	// Declarar e inicializar el WebDriver
	WebDriver driver = SetupDriver.setupDriver();

	// PageObjects
	LoginPage loginPage = new LoginPage(driver);

	@BeforeTest
	public void startWebDriver() {
		driver.get(GlobalVariables.HOME_PAGE);
	}

	@Test
	public void TC06() {

		String user = WrapClass.getCellData("TC_06", 1, 0);
		String pwd = WrapClass.getCellData("TC_06", 1, 1);

		loginPage.login(user, pwd);
	}

	@AfterTest
	public void closeDriver() {
		WrapClass.takeScreenshot(driver, "TC06_Login");
		driver.quit();
	}
}
