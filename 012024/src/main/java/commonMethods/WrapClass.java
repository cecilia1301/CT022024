package commonMethods;

import org.openqa.selenium.WebElement;

public class WrapClass {
	
	public static void click(WebElement webUI) {
		webUI.click();
		
	}
	
	public static void sendKeys(WebElement webUI, String textToSend) {
		webUI.sendKeys(textToSend);
	}

}
