package navigationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonMethods.WrapClass;

public class TemporaryDevPage {
	
	public TemporaryDevPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	
	//WebElements ProductSetPage
		WebElement productsetSetupLbl = driver.findElement(By.xpath("//*[@data-item-path='0/2/2']"));
		@FindBy(className = "label-wrapper label-wrapper-text")
		private WebElement productSetlbl;
		@FindBy(className = "ia_button--primary psc-Buttons/ViewEdit button-primary ia-button popup-not-draggable")
		private WebElement addBtn;
		@FindBy(className = "ia_inputField text-field popup-not-draggable")
		private WebElement productSetNameTxt;
		@FindBy(className = "ia_inputField text-field popup-not-draggable")
		private WebElement productSetDescripTxt;
		@FindBy(className = "iaDropdownCommon_container iaDropdownCommon_placeholder-container ia_dropdown__placeholder")
		private WebElement productsinSetTxt;
		
		@FindBy(className = "ia_button--primary psc-Buttons/ViewEdit button-primary ia-button popup-not-draggable")
		private WebElement submitBtn;
		
		
		
		//Methods LoginPage
		public void login(String product, String psd) {
			WrapClass.click(addBtn);
			WrapClass.sendKeys(productSetNameTxt, product);
			WrapClass.sendKeys(productSetDescripTxt, psd);
			WrapClass.click(submitBtn);
			

		//public boolean verifyRemoveButton() {
			//WrapClass.click(addBtn);
			//return WrapClass.veridyElementDisplayed(removeBtn);
		}
}
