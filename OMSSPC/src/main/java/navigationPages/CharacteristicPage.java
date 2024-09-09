package navigationPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonMethods.GlobalVariables;
import commonMethods.WrapClass;

public class CharacteristicPage {
	
	private WebDriverWait wait;
	
	public CharacteristicPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		}
	
	//WebElements Characteristic Page
	
	//Elemento etiqueta de menu caracteristica
	@FindBy(xpath = "//*[@data-item-path='0/2/1']")
	private WebElement characteristicMenuItem;
	
	//Elemento de busqueda
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchCharacteristic;
	
	//Elemento para seleccion de fila
	@FindBy(xpath = "//div[contains(@class, 'tr')][@data-row-index=\"0\"]")
	private WebElement selectRowCharacteristic;
	
	//Elemento boton nueva caracteristica
	@FindBy(id = "btn_newNameCh_chAddEdit")
	private WebElement newCharacteristicNameBtn;
	
	//Elemento nombre de caracteristica
	@FindBy(id = "txt_chName_addChName")
	private WebElement nameCharacteristictxt;
	
	//Elemento descripcion de caracteristica
	@FindBy(id = "txt_chDescription_addChName")
	private WebElement descCharacteristictxt;

	//Elemento boton de submit
	@FindBy(id = "btn_submitCh_addChName")
	private WebElement submitNewChBtn;
	
	//Elemento boton de cancelar 
	@FindBy(id = "btn_cancelCh_addChName")
	private WebElement cancelNewChBtn;
	
	@FindBy(xpath = "//*[@id = 'ddl_characteristic']/div/div/input")
	private WebElement addCharacteristicdropdown;
	
	@FindBy(id = "ddl_characName_characAddEdit")
	private WebElement addCharacteristicddl;
	
	@FindBy(xpath = "//*[@id ='ddl_product_ch']//*/input") 
	private WebElement addProductddl; 
	
	@FindBy(xpath = "//*[@id = 'ddl_productSet_ch']//*/input")
	private WebElement addProductSetddl;
	
	@FindBy(id = "checkbox-PspcAddEditCharacteristic.0:0:1:2:0")
	private WebElement selectProductSetchk;  
	
	@FindBy(id = "ddl_dataType_characAddEdit")
	private WebElement Datatypeddl;
	
	@FindBy(id = "freqType")
	private WebElement frequencyTypeddl;
	
	// cuadro de texto que se muestra al seleccionar frecuencia de tipo Time Interval
	@FindBy(id = "txt_intervalHours_characAddEdit")
	private WebElement intervalHourstxt;
	
	// dropdown que se muestra al seleccionar frecuencia de tipo AQL
	@FindBy(id = "ddl_aqlLevel_characAddEdit")
	private WebElement aqlLevelddl;
	
	@FindBy(id = "ddl_dataFormat_characAddEdit")
	private WebElement dataFormatddl;
	
	@FindBy(id = "txt_docRevision_characAddEdit")
	private WebElement docRevisiontxt;
	
	@FindBy(id = "txt_pickList_characAddEdit")
	private WebElement pickListTxt;
	
	@FindBy(id = "txt_lsl_characAddEdit")
	private WebElement lsltxt;
	
	@FindBy(id = "txt_target_characAddEdit")
	private WebElement targetTxt;
	
	@FindBy(id = "txt_usl_characAddEdit")
	private WebElement uslTxt;
	
	@FindBy(id = "ddl_equipmentType_characAddEdit")
	private WebElement equipmentTypeddl;
	
	@FindBy(id = "txt_equipmentName_characAddEdit")
	private WebElement equipmentNametxt;
	
	@FindBy(id = "txt_offsetValue_characAddEdit")
	private WebElement offsetValuetxt;
	
	@FindBy(id = "ddl_destrucTest_characAddEdit")
	private WebElement destructiveTestddl;
	
	@FindBy(id = "txt_grrPercent_characAddEdit")
	private WebElement grrPercentTxt;
	
	@FindBy(id = "txt_inspecTime_characAddEdit")
	private WebElement inspectionTimetxt;
	
	@FindBy(id = "txt_instruction_characAddEdit")
	private WebElement instructiontxt;
	
	@FindBy(id = "checkbox-PspcAddEditCharacteristic.0:1") 
	private WebElement archiveCharacteristicchk;
	
	@FindBy(id = "btn_submitNewCh_addEditChName")
	private WebElement submitAddEditChBtn;
	
	@FindBy(id = "btn_cancelNewCh_addEditChName")
	private WebElement cancelAddEditNewBtn;
	
	@FindBy(id = "popup-simple_popup_message")
	private WebElement popupMessage;
	
	@FindBy(xpath = "//*[@data-component-path = 'Psimple_popup_message.0:0:3:0']")
	private WebElement closePopupMessage;
	
	
	// Methods
	public void openCharacteristicSetup() {
		wait.until(d -> characteristicMenuItem.isDisplayed());
		WrapClass.click(characteristicMenuItem);
	}
	
	public void searchRowTable(String characteristic) throws InterruptedException {
		wait.until(d -> searchCharacteristic.isDisplayed());
		WrapClass.clearInput(searchCharacteristic);
		WrapClass.sendKeys(searchCharacteristic, characteristic);

		if (WrapClass.verifyElementDisplayed(selectRowCharacteristic)) {
			wait.until(d -> selectRowCharacteristic.isDisplayed());
			WrapClass.click(selectRowCharacteristic);
		}
	}
	
	public boolean verifyExistCharacteristic(String characteristic) throws InterruptedException {
		WrapClass.clearInput(searchCharacteristic);
		WrapClass.sendKeys(searchCharacteristic, characteristic);
		if (WrapClass.verifyElementDisplayed(selectRowCharacteristic)) {
			WrapClass.clearInput(searchCharacteristic);
			return true;
		}
		WrapClass.clearInput(searchCharacteristic);
		return false;
	}

	public void openAddEditCharacteristicSetupPopup(String button) {
		wait.until(d -> GlobalVariables.driver.findElement(By.id(button)).isEnabled());
		WebElement element = GlobalVariables.driver.findElement(By.id(button));
		WrapClass.click(element);
	}
	
	public void addNewCharacteristicName(String name, String desc) {
		wait.until(d -> newCharacteristicNameBtn.isDisplayed());
		WrapClass.click(newCharacteristicNameBtn);
		WrapClass.sendKeys(nameCharacteristictxt, name);
		WrapClass.sendKeys(descCharacteristictxt, desc);
	}
	
	public void submitCharacteristicName() throws InterruptedException {
		WrapClass.click(submitNewChBtn);
	}

	public void dinamicDDLCharacteristic(String element, String value, String filter) {
		String ddlPath = "//*[@id ='"+element+"']//*/input";
		WebElement ddlElement = GlobalVariables.driver.findElement(By.xpath(ddlPath));
		WrapClass.click(ddlElement);
		if (filter != "") {
			WrapClass.sendKeys(ddlElement, filter);	
		}
		
		String valuePath = "//a[@data-label = '" + value + "']";
		WebElement valueElement = GlobalVariables.driver.findElement(By.xpath(valuePath));
		WrapClass.click(valueElement);
	}
	
	public void dinamicInputStringCharacteristic(String element, String value) throws InterruptedException {
		WebElement inputElement = GlobalVariables.driver.findElement(By.id(element));
		WrapClass.sendKeys(inputElement, value);
		Thread.sleep(1000);
			
	}
	
	public void dinamicInputNumericCharacteristic(String element, String value) throws InterruptedException {
		WebElement inputElement = GlobalVariables.driver.findElement(By.id(element));
		WrapClass.click(inputElement);
		Thread.sleep(1000);
		
		String inputPath = "//*[@id ='"+element+"']//*/input";
		WebElement inputElement2 = GlobalVariables.driver.findElement(By.xpath(inputPath));
		WrapClass.sendKeys(inputElement2, value);		
	}
	
	public void selectProductSetchk() throws InterruptedException {
        WebElement selectProductSet = GlobalVariables.driver.findElement(By.id("checkbox-PspcAddEditCharacteristic.0:0:1:2:0"));
        WrapClass.clickCheckbox(selectProductSet);	 
    } 
	
	public void submitCharacteristic() throws InterruptedException {
		WrapClass.click(submitAddEditChBtn);
		
		if (WrapClass.verifyElementDisplayed(popupMessage)) {
			WrapClass.click(closePopupMessage); 
		}

	}	
}
