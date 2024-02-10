package seleniumPrac;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElements {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");

		// Obtener objetos/WebElementos de la pagina web

		WebElement userName = driver.findElement(By.id("user-name"));
		WebElement passwordTxt = driver.findElement(By.name("password"));
		WebElement loginBtn = driver.findElement(By.id("login-button"));

		// Hacer login
		userName.sendKeys("standard_user");
		Thread.sleep(2000);
		passwordTxt.sendKeys("secret_sauce");
		Thread.sleep(2000);
		loginBtn.click();
		
		//Find Elements (Devuelve una lista de WebElements que existan en la pagina)
		
		List<WebElement> prodList = driver.findElements(By.className("inventory_item_name"));
		System.out.println("Numero de Elmentos: "+ prodList.size());
		
		String primerProd = prodList.get(0).getText();
		String segProd = prodList.get(1).getText();
		System.out.println(primerProd);
		System.out.println(segProd);
		
		for (int i = 0; i < prodList.size(); i++) {
			System.out.println("Los productos son: " + prodList.get(i).getText());
		}
		
		driver.quit();
		}

}


