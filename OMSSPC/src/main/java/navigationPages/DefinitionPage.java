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

public class DefinitionPage {

	private WebDriverWait wait;

	public DefinitionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// WebElements

	// Elemento de busqueda
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchDefinition;

	// Elemento para seleccion de fila
	@FindBy(xpath = "//div[contains(@class, 'tr')][@data-row-index=\"0\"]")
	private WebElement selectRowDefinition;

	@FindBy(id = "popup-simple_popup_message")
	private WebElement popupMessage;
	
	@FindBy(xpath = "//*[@data-component-path = 'Psimple_popup_message.0:0:3:0']")
	private WebElement closePopupMessage;

	@FindBy(xpath = "//*[@data-item-path='0/2/0']")
	private WebElement definitionSetuplbl;

	@FindBy(id = "btn_addDef_definitionSetup")
	private WebElement addDefinitionBtn;

	@FindBy(id = "btn_editDef_definitionSetup")
	private WebElement editDefinitionBtn;
	
	@FindBy(id = "ddl_defType_definitionSetup")
	private WebElement definitionTypeddl;
	
	//Elemento dropdown de product
	@FindBy(xpath = "//*[@id ='ddl_product_definitionSetup']//*/input") 
	private WebElement productddl; 
	
	@FindBy(id = "checkbox-PM6FRuaQn.0:0:0:6") 
	private WebElement selectProductSetchk;
	
	@FindBy(xpath = "//*[@id ='ddl_productSet_defSetup']//*/input") 
	private WebElement productSetddl; 
	
	@FindBy(id = "ddl_mold_definitionSetup")
	private WebElement moldDdl;
	
	@FindBy(id = "txt_defName_definitionSetup")
	private WebElement defNametxt;
	
	@FindBy(id = "txt_description_definitionSetup")
	private WebElement descriptionctxt;
	
	@FindBy(id = "ddl_frequency_definitionSetup")
	private WebElement frequencyddl;
	
	@FindBy(id = "txt_numCavities_definitionSetup")
	private WebElement numCavitiestxt;
	
	@FindBy(id = "txt_cavID_definitionSetup")
	private WebElement cavIDtxt;
	
	@FindBy(id = "txt_InspecTime_definitionSetup")
	private WebElement InspecTimetxt;
	
	@FindBy(id = "ddl_station_definitionSetup")
	private WebElement stationddl;
	
	//Seccion para añadir archivo
	@FindBy(id = "btn_addFilePath_defSetup")
	private WebElement addFilePathbtn;
	
	@FindBy(id = "txt_fileName_definitionSetup")
	private WebElement fileNametxt;
	
	@FindBy(id = "ddl_fileType_definitionSetup")
	private WebElement fileTypeddl;
	
	@FindBy(id = "btn_addFile_definitionSetup")
	private WebElement addFilebtn;
	
	@FindBy(id = "btn_delete_definitionSetup")
	private WebElement deleteFilebtn;
	
	@FindBy(id = "btn_closeFile_definitionSetup")
	private WebElement closeFilebtn;
	
	
	@FindBy(id = "txt_numSize_definitionSetup")
	private WebElement lotSizetxt;
	
	@FindBy(id = "ddl_supplierName_definitionSetup")
	private WebElement supplierNameddl;
	
	//seccion Instructions
	@FindBy(id = "txt_instructions_definitionS")
	private WebElement instructionstxt;
	
	@FindBy(id = "txt_nameInstructions_defSetup")
	private WebElement nameInstructionstxt;
	
	@FindBy(id = "txt_url_definitionSetup")
	private WebElement urltxt;
	
	@FindBy(id = "btn_saveUrl_definitionSetup")
	private WebElement saveURLBtn;
	
	//seccion calculations
	@FindBy(id = "btn_addCalculation_defSetup")
	private WebElement addCalculationBtn;
	
	@FindBy(id = "txt_nameCalculation_defSetup")
	private WebElement nameCalculationtxt;
	
	@FindBy(id = "txt_descCalculation_defSetup")
	private WebElement descCalculationBtn;
	
	@FindBy(id = "ddl_calculationType_defSetup")
	private WebElement calculationTypeddl;
	
	@FindBy(xpath = "//*[@id= 'tbl_chCalcu_defAddEdit']//*[@data-row-id='1']//label")
	private WebElement calculationRow;
	
	@FindBy(id = "btn_submitAddCalcu_defSetup")
	private WebElement submitAddCalcuBtn;
	
	@FindBy(id = "btn_cancelAddCalcu_defSetup")
	private WebElement cancelAddCalcuBtn;
		
	@FindBy(id = "btn_editCalculation_defSetup")
	private WebElement editCalculationBtn;
	
	@FindBy(id = "btn_deleteCalculation_defSetup")
	private WebElement deleteCalculationBtn;
	
	//botones principales
	@FindBy(id = "btn_submitDef_definitionSetup")
	private WebElement submitdefinitionBtn;
	
	@FindBy(id = "btn_cancelDef_definitionSetup")
	private WebElement canceldefinitionBtn;
	
	
	

	// Methods

	public void openDefinitionSetup() {
		wait.until(d -> definitionSetuplbl.isDisplayed());
		WrapClass.click(definitionSetuplbl);
	}

	public boolean verifyExistButton() {
		return WrapClass.verifyElementDisplayed(addDefinitionBtn);
	}

	public void searchRowTable(String definition) throws InterruptedException {
		wait.until(d -> searchDefinition.isDisplayed());
		WrapClass.clearInput(searchDefinition);
		WrapClass.sendKeys(searchDefinition, definition);

		if (WrapClass.verifyElementDisplayed(selectRowDefinition)) {
			wait.until(d -> selectRowDefinition.isDisplayed());
			WrapClass.click(selectRowDefinition);
		}
	}

	public boolean verifyExistDefinition(String definition) throws InterruptedException {
		WrapClass.clearInput(searchDefinition);
		WrapClass.sendKeys(searchDefinition, definition);
		if (WrapClass.verifyElementDisplayed(selectRowDefinition)) {
			WrapClass.clearInput(searchDefinition);
			return true;
		}
		WrapClass.clearInput(searchDefinition);
		return false;	
	}
	
	public void openAddEditDefinitionSetupPopup(String button) {
		wait.until(d -> GlobalVariables.driver.findElement(By.id(button)).isEnabled());
		WebElement element = GlobalVariables.driver.findElement(By.id(button));
		WrapClass.click(element);
	}
	
	public void dinamicDDLDefinition(String element, String value, String filter) {
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
	
	public void dinamicInputStringDefinition(String element, String value) throws InterruptedException {
		WebElement inputElement = GlobalVariables.driver.findElement(By.id(element));
		WrapClass.sendKeys(inputElement, value);
		Thread.sleep(1000);
			
	}
	
	public void dinamicInputNumericDefinition(String element, String value) throws InterruptedException {
		WebElement inputElement = GlobalVariables.driver.findElement(By.id(element));
		WrapClass.click(inputElement);
		Thread.sleep(1000);
		
		String inputPath = "//*[@id ='"+element+"']//*/input";
		WebElement inputElement2 = GlobalVariables.driver.findElement(By.xpath(inputPath));
		WrapClass.sendKeys(inputElement2, value);		
	}
	
	public void selectProductSetchk() throws InterruptedException {
        WebElement selectProductSet = GlobalVariables.driver.findElement(By.id("checkbox-PM6FRuaQn.0:0:0:6"));
        WrapClass.clickCheckbox(selectProductSet);	 
    } 
	
	public void openFilePathPopup(String button) {
		wait.until(d -> GlobalVariables.driver.findElement(By.id(button)).isEnabled());
		WebElement element = GlobalVariables.driver.findElement(By.id(button));
		WrapClass.click(element);
	}
	
	public void addFilePath(String name,String element) {
		WrapClass.sendKeys(fileNametxt, name);
		wait.until(d -> fileTypeddl.isDisplayed());
		this.dinamicDDLDefinition("ddl_fileType_definitionSetup", element, "");
		WrapClass.click(addFilebtn);
		WrapClass.click(closeFilebtn);
		
	}
	
	public void selectTabIndex(String index) {
		String pathElement = "//div[@data-index='"+index+"']";
		wait.until(d -> GlobalVariables.driver.findElement(By.xpath(pathElement)).isEnabled());
		WebElement element = GlobalVariables.driver.findElement(By.xpath(pathElement));
		WrapClass.click(element);
		
	}
	
	public void dinamicClickButton(String button) {
		wait.until(d -> GlobalVariables.driver.findElement(By.id(button)).isDisplayed());
		WebElement element = GlobalVariables.driver.findElement(By.id(button));
		WrapClass.click(element);
	}
	
	public void selectCheckbox(String checkbox) {
		//wait.until(d -> GlobalVariables.driver.findElement(By.id(checkbox)).isEnabled());
		WebElement element = GlobalVariables.driver.findElement(By.xpath(checkbox));
		WrapClass.click(element);
		
	}
	
	public void submitDefinition() throws InterruptedException {
		WrapClass.click(submitdefinitionBtn);
		
		if (WrapClass.verifyElementDisplayed(popupMessage)) {
			WrapClass.click(closePopupMessage); 
		}

	}	
}
