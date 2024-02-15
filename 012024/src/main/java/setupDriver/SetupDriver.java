package setupDriver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetupDriver {
	
	public static WebDriver setupDriver () {
		
		WebDriver driver = new ChromeDriver ();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
				
	}

}
