package navigationPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonMethods.GlobalVariables;
import commonMethods.WrapClass;

public class StationSetupPage {
	
	private WebDriverWait wait;
	public StationSetupPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	//WebElements StationPage
	
	@FindBy(xpath = "//*[@data-item-path='0/2/2']")
	private WebElement stationMenuItem;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchStation;
		
	@FindBy(xpath = "//div[contains(@class, 'tr')][@data-row-index=\"0\"]")
	private WebElement selectRowStation;
	
	@FindBy(id = "txt_stationName_stationAddEdit")
	private WebElement nameStation;
	
	@FindBy(id = "lbl_addLines_stationAddEdit")
	private WebElement addLineslbl;

	@FindBy(xpath = "//*[@data-component-path='PxBCtstQY.0:3:1']")
	private WebElement submitPopupTree;
	
	@FindBy(id = "btn_submitStation_stationAddEdit")
	private WebElement submitAddEditStation;
	
	
	// Methods
	public void openStationSetup() {
		wait.until(d -> stationMenuItem.isDisplayed());
		WrapClass.click(stationMenuItem);
	}
	
	public void searchRowTable(String station) throws InterruptedException {
		wait.until(d -> searchStation.isDisplayed());
		WrapClass.clearInput(searchStation);
		WrapClass.sendKeys(searchStation, station);

		if (WrapClass.verifyElementDisplayed(selectRowStation)) {
			wait.until(d -> selectRowStation.isDisplayed());
			WrapClass.click(selectRowStation);
		}
	}
	
	public boolean verifyExistStation(String station) throws InterruptedException {
		WrapClass.clearInput(searchStation);
		WrapClass.sendKeys(searchStation, station);
		if (WrapClass.verifyElementDisplayed(selectRowStation)) {
			WrapClass.clearInput(searchStation);
			return true;
		}
		WrapClass.clearInput(searchStation);
		return false;
	}

	public void openAddEditStationSetupPopup(String button) {
		wait.until(d -> GlobalVariables.driver.findElement(By.id(button)).isEnabled());
		WebElement element = GlobalVariables.driver.findElement(By.id(button));
		WrapClass.click(element);
	}

	public void addStationPopup(String name) throws InterruptedException {
		Thread.sleep(1000);
		WrapClass.clearInput(nameStation);
		WrapClass.sendKeys(nameStation, name);
		WrapClass.click(addLineslbl);
	}
	
	public void addLinesinStation(String line) {
		////div[@data-label="IQMS-012"]
		String pathElement = "//div[@data-label='"+line+"']";
		wait.until(d -> GlobalVariables.driver.findElement(By.xpath(pathElement)).isDisplayed());
		WebElement element = GlobalVariables.driver.findElement(By.xpath(pathElement));
		if (WrapClass.verifyElementDisplayed(element)) {
			WrapClass.click(element);
		}	
	}
	
	public void submitPopupTree() {
		wait.until(d -> submitPopupTree.isDisplayed());
		WrapClass.click(submitPopupTree); 
	}
	
	public void submitAddEditStationPopup() throws InterruptedException {
		//wait.until(d -> !submitPopupTree.isDisplayed());
		Thread.sleep(1000);
		WrapClass.click(nameStation);
		Thread.sleep(1000);
		WrapClass.click(submitAddEditStation); 
	}
	public void selectCheckActiveStation() throws InterruptedException {
         WebElement activeStation = GlobalVariables.driver.findElement(By.id("checkbox-PmFx/E6jB.0:0:2:1"));
         WrapClass.clickCheckbox(activeStation);	 
         
     } 
     
	
}
