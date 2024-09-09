package commonMethods;

import java.io.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class WrapClass {
	
	public static void click(WebElement webUI) {
		webUI.click();

	}

	public static void sendKeys(WebElement webUI, String textToSend) {
		webUI.sendKeys(textToSend);
	}
	
	public static void sendKeysEnter(WebElement webUI, String textToSend) {
		webUI.sendKeys(textToSend);
		webUI.sendKeys(Keys.ENTER);
	}
	
	public static void ddlclickAndSelect(WebElement webUI, String textToSend, WebElement selectWebUI) throws InterruptedException {
		webUI.click();
		webUI.sendKeys(textToSend);
		selectWebUI.click();
//		Thread.sleep(1000);
	}
	
	public static void doubleClick(WebElement webUI) {
		Actions action = new Actions(GlobalVariables.driver);
		action.doubleClick(webUI).perform();
	}

	public static String getText(WebElement webUI) {
		return webUI.getText();
	}

	public static boolean verifyElementDisplayed(WebElement webUI) {
		try {
			return webUI.isDisplayed();
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public static void clickCheckbox(WebElement webUI) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) GlobalVariables.driver;
		boolean checkVisibility = (boolean) js.executeScript("return arguments[0].checkVisibility();", webUI); 
		if(checkVisibility == true) {
			js.executeScript("arguments[0].click();", webUI);
		}
		Thread.sleep(1000);
	}
	
	public static void clearInput(WebElement webUI) throws InterruptedException {
		while(!webUI.getAttribute("value").equals("")) {
			webUI.sendKeys(Keys.BACK_SPACE);
		}
	}
	
	public static void takeScreenshot(WebDriver webdriver, String testCaseName) {
	//Toman el screenshot de la pagina sin formato
		File scrFile = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.FILE);

		//Establecer ruta donde se guarda el screenshot
		String screenshotPath = "./test-output/ExecutionResults";

		try {
			FileHandler.createDir(new File(screenshotPath)); // creamos el folder usando la ruta especificada de la
																// variable "screenshotPath"
			FileHandler.copy(scrFile, new File(screenshotPath + File.separatorChar + testCaseName + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
