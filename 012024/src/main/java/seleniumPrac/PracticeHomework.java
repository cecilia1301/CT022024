package seleniumPrac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeHomework {

	public static void main(String[] args) throws InterruptedException{

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
		
		//verifica elemento mostrado en la pagina
		
		WebElement loginBtn1 = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		WebElement loginBtn2 = driver.findElement(By.id("shopping_cart_container"));
		
		boolean product = driver.findElement(By.className("inventory_item_name")).isDisplayed();
		if (product) {
			System.out.println("El articulo es despleado");
			loginBtn1.click();
			Thread.sleep(2000);
			loginBtn2.click();
		}
		
		WebElement loginBtn3 = driver.findElement(By.id("checkout"));
		
		boolean product1 = driver.findElement(By.className("inventory_item_name")).isDisplayed();
		if (product1) {
			System.out.println("El articulo es despleado");
			Thread.sleep(2000);
			loginBtn3.click();
			
		WebElement firstName = driver.findElement(By.id("first-name"));
		WebElement lastName = driver.findElement(By.id("last-name"));
		WebElement ZipPostal = driver.findElement(By.id("postal-code"));
		WebElement loginBtn4 = driver.findElement(By.id("continue"));

		firstName.sendKeys("Mario");
		Thread.sleep(2000);
		lastName.sendKeys("Martinez");
		Thread.sleep(2000);
		ZipPostal.sendKeys("525655");
		Thread.sleep(2000);
		loginBtn4.click();
				
		
		//Obtener el texto de un WebElement
		String prodText = driver.findElement(By.className("inventory_item_name")).getText();
				
			boolean textCorrect = prodText.contains("Sauce Labs Backpack"); //contains es un metodo de JAVA que evalua 2 strings
				
			if (textCorrect) {
				System.out.println("El nombre del producto es correcto");
			} else {
				System.out.println("ERROR: El producto no es correcto");
			}
				Thread.sleep(2000);
		
		}
	 
	
	}

}
