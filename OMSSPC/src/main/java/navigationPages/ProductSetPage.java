package navigationPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.WebDriverWait;

import commonMethods.GlobalVariables;
import commonMethods.WrapClass;

public class ProductSetPage {

	private WebDriverWait wait;

	public ProductSetPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// WebElements
	
	@FindBy(id = "popup-simple_popup_message")
	private WebElement popupMessage;

	@FindBy(xpath = "//*[@data-item-path='0/2/3']")
	private WebElement productSetlbl;

	@FindBy(id = "btn_add_product")
	private WebElement addProdSetBtn;

	@FindBy(id = "txt_psName_psAddEdit")
	private WebElement productSetNameTxt;

	@FindBy(id = "txt_psDescription_psAddEdit")
	private WebElement productSetDescripTxt;

	@FindBy(xpath = "//*[@id = 'ddl_productSet']/div/div/input")
	private WebElement addProductSetdropdown;

	@FindBy(id = "btn_submitPS_psAddEdit")
	private WebElement submitBtn;

	@FindBy(xpath = "//*[@data-component-path = 'Psimple_popup_message.0:0:3:0']")
	private WebElement closePopupMessage;

	@FindBy(id = "btn_cancel_PSAddEdit")
	private WebElement closeProductSet;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchProductSet;

	@FindBy(xpath = "//div[contains(@class, 'tr')][@data-row-index=\"0\"]")
	private WebElement selectRowProductSet;

	@FindBy(id = "btn_removePS_productSets")
	private WebElement removeProductSet;

	@FindBy(xpath = "//*[@data-component-path = 'Psimple_popup_message.0:0:3:2']")
	private WebElement confirmPopupRemovePSMessage;
	
	// Methods
	
	public void openProductSet() {
		wait.until(d -> productSetlbl.isDisplayed());
		WrapClass.click(productSetlbl);
	}

	public boolean verifyExistButton() {
		return WrapClass.verifyElementDisplayed(addProdSetBtn);
	}

	public void openAddProductSetPopup(String product, String desc) {
		WrapClass.click(addProdSetBtn);
		WrapClass.sendKeys(productSetNameTxt, product);
		WrapClass.sendKeys(productSetDescripTxt, desc);
	}

	public void openEditProductSetPopup(String button) {
		wait.until(d -> GlobalVariables.driver.findElement(By.id(button)).isEnabled());
		WebElement element = GlobalVariables.driver.findElement(By.id(button));
		WrapClass.click(element);
	}

	public void searchRowTable(String product) throws InterruptedException {
		wait.until(d -> searchProductSet.isDisplayed());
		WrapClass.clearInput(searchProductSet);
		WrapClass.sendKeys(searchProductSet, product);

		if (WrapClass.verifyElementDisplayed(selectRowProductSet)) {
			wait.until(d -> selectRowProductSet.isDisplayed());
			WrapClass.click(selectRowProductSet);
		}

	}

	public boolean verifyExistPS(String productSet) throws InterruptedException {
		WrapClass.clearInput(searchProductSet);
		WrapClass.sendKeys(searchProductSet, productSet);
		if (WrapClass.verifyElementDisplayed(selectRowProductSet)) {
			WrapClass.clearInput(searchProductSet);
			return true;
		}
		WrapClass.clearInput(searchProductSet);
		return false;
	}

	public void editBasicData(String name, String desc) throws InterruptedException {
		wait.until(d -> productSetNameTxt.isDisplayed());
		if (name != "") {
			WrapClass.clearInput(productSetNameTxt);
			WrapClass.sendKeys(productSetNameTxt, name);
		}

		if (desc != "") {
			WrapClass.clearInput(productSetDescripTxt);
			WrapClass.sendKeys(productSetDescripTxt, desc);
		}

	}

	public void addPartsToProductSet(String element, String filter) throws InterruptedException {
		Thread.sleep(1000);

		WrapClass.click(addProductSetdropdown);
		WrapClass.sendKeys(addProductSetdropdown, filter);
		wait.until(d -> addProductSetdropdown.isDisplayed());
		String pathElement = "//a[@data-label = '" + element + "']";
		wait.until(d -> GlobalVariables.driver.findElement(By.xpath(pathElement)).isDisplayed());
		WebElement productTest = GlobalVariables.driver.findElement(By.xpath(pathElement));
		WrapClass.click(productTest);
	}

	public void deletePartsfromProductSet(String product) throws InterruptedException {

		WrapClass.sendKeys(searchProductSet, product);
		if (WrapClass.verifyElementDisplayed(selectRowProductSet)) {
			WrapClass.click(selectRowProductSet);
			// 3. click button remove
			WrapClass.click(removeProductSet);

			// 4. verify if popup is open
			if (WrapClass.verifyElementDisplayed(popupMessage)) {
				WrapClass.click(confirmPopupRemovePSMessage); // 5. click confirm remove button
			}
		}
		WrapClass.clearInput(searchProductSet);

	}

	public void editProductSet(String product, String Filter) throws InterruptedException {
		// eliminar producto
		try {
			String pathElement = "//div[@data-label = '" + product + "']/a";
			WebElement productTest = GlobalVariables.driver.findElement(By.xpath(pathElement));
			WrapClass.click(productTest);
		} catch (Exception e) {
			addPartsToProductSet(product, Filter);
		}

	}

	public void submitProductSet() throws InterruptedException {
		WrapClass.click(submitBtn);

		if (WrapClass.verifyElementDisplayed(popupMessage)) {
			WrapClass.click(closePopupMessage);
		}

		if (WrapClass.verifyElementDisplayed(closeProductSet)) {
			WrapClass.click(closeProductSet);
		}


	}
}
