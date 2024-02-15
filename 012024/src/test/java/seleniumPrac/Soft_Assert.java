package seleniumPrac;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Soft_Assert {
  @Test
  public void f() {
	  
	  SoftAssert softAssert = new SoftAssert();
	  
	  WebDriver driver = new ChromeDriver ();
		driver.get("https://www.saucedemo.com/");
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Swag Labs";
		String badTitle = "My store";
		
		softAssert.assertEquals(actualTitle, expectedTitle);
		softAssert.assertEquals(actualTitle, badTitle);
		
		
		softAssert.assertAll();
  }
}
