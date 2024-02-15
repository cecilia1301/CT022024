package seleniumPrac;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWait {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");

		//ImplicitWait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Obtener objetos/WebnElements de la pagina web
		WebElement userName = driver.findElement(By.id("user-name"));
		
		driver.quit();
	}

}
