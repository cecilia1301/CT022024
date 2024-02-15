package seleniumPrac;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		
		//Obtener objetos/WebnElements de la pagina web
		WebElement userName = new WebDriverWait(driver,Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(By.id("user-name")));
		
		driver.quit();
			
		}

}


