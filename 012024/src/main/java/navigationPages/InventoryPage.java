package navigationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonMethods.WrapClass;

public class InventoryPage {
	
	public InventoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//WebElements LoginPage
	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	private WebElement addBtn;
	@FindBy(id = "remove-sauce-labs-backpack")
	private WebElement removeBtn;
	
	public boolean verifyRemoveButton() {
		WrapClass.click(addBtn);
		return WrapClass.veridyElementDisplayed(removeBtn);
	}

}
