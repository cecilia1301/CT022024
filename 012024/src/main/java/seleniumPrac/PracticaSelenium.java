package seleniumPrac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PracticaSelenium {

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

		// Metodos del explorador

		// Obtener el titulo de la pagina
		String title = driver.getTitle();
		System.out.println("El titulo de la pagina es: " + title);

		// Obtener la URL
		String url = driver.getCurrentUrl();
		System.out.println("La url actual es: " + url);
		
		//Metodos de navegacion
		//driver.navigate().back();
		//Thread.sleep(2000);
		//driver.navigate().forward();
		//Thread.sleep(2000);
		//driver.navigate().refresh();
		
		//verifica elemento mostrado en la pagina
		boolean product = driver.findElement(By.className("inventory_item_name")).isDisplayed();
		if (product) {
			System.out.println("El articulo es despleado");
		}
		
		//Obtener el texto de un WebElement
		String prodText = driver.findElement(By.className("inventory_item_name")).getText();
		
		boolean textCorrect = prodText.contains("Sauce Labs Backpack"); //contains es un metodo de JAVA que evalua 2 strings
		
		if (textCorrect) {
			System.out.println("El nombre del producto es correcto");
		} else {
			System.out.println("ERROR: El producto no es correcto");
		}
		Thread.sleep(2000);
		
		//Ejemplo usando Dropdown
		Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
		dropdown.selectByValue("lohi");
		
		//driver.close(); // cierra la ventana actual con la que se esta interactuando
		driver.quit();
		
	}

}
