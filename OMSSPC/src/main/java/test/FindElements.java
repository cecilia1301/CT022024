package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindElements {

	public static void main(String[] args) throws InterruptedException {


		// #1 Creo el WebDriver (el objeto que contiene lo necesario para controlar el browser)
		WebDriver driver = new ChromeDriver(); 
		//maximizo mi browser
		driver.manage().window().maximize();
		// #2 Le indico al webdriver que visite la URL
		driver.get("https://msdnigntest:8043/data/perspective/client/OMSweb");

		// Obtener objetos/WebElementos de la pagina web

		WebElement login1Btn = driver.findElement(By.className("submit-button"));
		Thread.sleep(1000);
		login1Btn.click(); 		// Hacer login
		Thread.sleep(1000);

		WebElement userName = driver.findElement(By.name("username"));
		userName.sendKeys("ceciliarazo");
		Thread.sleep(1000);
		WebElement login2Btn = driver.findElement(By.className("submit-button"));
		login2Btn.click();
		Thread.sleep(1000);

		WebElement passwordTxt = driver.findElement(By.name("password"));
		passwordTxt.sendKeys("crh140221#");
		Thread.sleep(1000);
		WebElement login3Btn = driver.findElement(By.className("submit-button"));
		login3Btn.click();
		Thread.sleep(10000);

		WebElement productsetSetupLbl = driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/div[2]/div[2]/div[1]/div[2]/div/div/div/div[3]/div[6]/div/div[2]/div/div[2]"));
		productsetSetupLbl.click();
		Thread.sleep(2000);
		//*[@id="app-container"]/div/div[3]/div[2]/div[2]/div[3]/button[1]
		WebElement addProductSetBtn = driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/div[3]/div[2]/div[2]/div[3]/button[1]"));
		addProductSetBtn.click();
		Thread.sleep(2000);
		WebElement productsetNameTxt = driver.findElement(By.xpath("//*[@id=\"popup-mFx/E6jB\"]/div[10]/div/div/div[1]/div[1]/input"));
		productsetNameTxt.sendKeys("Test 1 Product Set");
		Thread.sleep(2000);
		WebElement productsetDescTxt = driver.findElement(By.xpath("//*[@id=\"popup-mFx/E6jB\"]/div[10]/div/div/div[1]/div[2]/input"));
		productsetDescTxt.sendKeys("Primer prueba");
		Thread.sleep(2000);
		
		
//		WebElement addProductSetdropdown = driver.findElement(By.xpath("#popup-mFx\\/E6jB > div.body-wrapper > div > div > div:nth-child(1) > div:nth-child(3) > div.flex-container.responsive-container.ia_container--primary > div > div > div > div > div > div > div"));
//		addProductSetdropdown.sendKeys("100");
//		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#popup-mFx\\/E6jB > div.body-wrapper > div > div > div:nth-child(1) > div:nth-child(3) > div.flex-container.responsive-container.ia_container--primary > div > div > div > div > div > div > div")));
//
//	    WebElement opcion = driver.findElement(By.cssSelector("#popup-mFx\\\\/E6jB > div.body-wrapper > div > div > div:nth-child(1) > div:nth-child(3) > div.flex-container.responsive-container.ia_container--primary > div > div > div > div > div > div > div > div"));
//	    opcion.click();
//	        
//	    //WebElement userName = new WebDriverWait(driver,Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(By.id("user-name")));
//		//Select dropdown = new Select(driver.findElement(By.("")));
//		//dropdown.selectByValue("");
//		
//		WebElement submitAddProductSetBtn = driver.findElement(By.xpath("//*[@id=\"popup-mFx/E6jB\"]/div[10]/div/div/div[2]/button[1]"));
//		submitAddProductSetBtn.click();
//		
//		WebElement elementPrincipalLbl = driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/div[3]/div[2]/div[2]/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[1]/div[1]/div[2]"));
//		elementPrincipalLbl.click();
//		
//		WebElement editProductSetBtn = driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/div[3]/div[2]/div[2]/div[3]/button[2]"));
//		editProductSetBtn.click();
//		
//		WebElement productsetName1Txt = driver.findElement(By.xpath("//*[@id=\"popup-mFx/E6jB\"]/div[10]/div/div/div[1]/div[1]/input"));
//		productsetName1Txt.sendKeys("Test 1 Product Set..");
//		
//		WebElement submitEditProductSetBtn = driver.findElement(By.xpath("//*[@id=\"popup-mFx/E6jB\"]/div[10]/div/div/div[2]/button[1]"));
//		submitEditProductSetBtn.click();
//		
		
		

		
		
		
		
		
		

		// Encuentra todos los botones
        //WebElement buttons = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div[2]/div[3]/button[1]"));
        //buttons.click();
       
        
      
		// Find Elements (Devuelve una lista de WebElements que existan en la pagina)

		// List<WebElement> prodList =
		// driver.findElements(By.className("inventory_item_name"));
		// System.out.println("Numero de Elmentos: "+ prodList.size());

		// String primerProd = prodList.get(0).getText();
		// String segProd = prodList.get(1).getText();
		// System.out.println(primerProd);
		// System.out.println(segProd);

		// for (int i = 0; i < prodList.size(); i++) {
		// System.out.println("Los productos son: " + prodList.get(i).getText());
		// }

		driver.quit();
	}

}
