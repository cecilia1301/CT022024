package navigationPages;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonMethods.GlobalVariables;
import commonMethods.WrapClass;
import java.util.List;
//import testCases.List;

public class SamplesPage {
	
	private WebDriverWait wait;
	
	public SamplesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	//WebElements

		@FindBy(xpath = "//input[@type='search']")
		private WebElement searchSample;

		// Elemento para busqueda o edicion de un sample
		
		@FindBy(xpath = "//div[contains(@class, 'tr')][@data-row-index=\"0\"]")
		private WebElement selectRowSample;

		@FindBy(id = "popup-simple_popup_message")
		private WebElement popupMessage;
		
		@FindBy(xpath = "//*[@data-component-path = 'Psimple_popup_message.0:0:3:0']")
		private WebElement closePopupMessage;
		
		//Elemento para seleccionar pantalla de samples

		@FindBy(xpath = "//*[@data-item-path='0/0']")
		private WebElement sampleslbl;
		
		//Elementos de filtros
		
		@FindBy(id = "ddl_stationS_scheduledSamples")
		private WebElement stationddl;
		
		@FindBy(id = "ddl_statusS_scheduledSamples")
		private WebElement statusddl;
		
		@FindBy(id = "ddl_lineS_scheduledSamples")
		private WebElement lineSampleddl;
		
		@FindBy(id = "ddl_productS_scheduledSamples")
		private WebElement productddl;
		
		@FindBy(id = "btn_submitF_scheduledSamples")
		private WebElement submitFilterbtn;
		
		@FindBy(id = "btn_saveF_scheduledSamples")
		private WebElement saveFilterbtn;
		
		@FindBy(id = "btn_editS_scheduledSamples")
		private WebElement enterSamplebtn;
		
		@FindBy(id = "btn_deleteS_scheduledSamples")
		private WebElement cancelSamplebtn;
		
		@FindBy(id = "btn_addS_scheduledSamples")
		private WebElement createNewSamplebtn;
		
		@FindBy(id = "btn_recreateS_scheduledSamples")
		private WebElement recreateSamplebtn;
	
		//Elementos sample entry
		
		@FindBy(id = "txt_entryBox_sampleEntry")
		private WebElement inspectorEntrytxt;
		
		@FindBy(id = "btn_blockCav_scheduledSamples")
		private WebElement blockCavitybtn;
		
		@FindBy(id = "btn_importFile_scheduledSamples")
		private WebElement importFilebtn;
		
		
		//pendiente seleccion de caracteristicas para ingresar valores
		
		//Elementos seccion Instructions
		
		@FindBy(id = "txt_defInstructions_sampleEntry")
		private WebElement definitionInstructionSectiontxt;
		
		@FindBy(id = "txt_characInst_sampleEntry")
		private WebElement characteristicInstructionSectiontxt;
		
		//pendientes seccion comentarios
		
		//Elementos de botones principales de sample entry
		
		@FindBy(id = "btn_completeS_scheduledSamples")
		private WebElement completeSamplebtn;
		
		@FindBy(id = "btn_saveS_scheduledSamples")
		private WebElement saveSamplebtn;
		
		@FindBy(id = "btn_closeS_scheduledSamples")
		private WebElement closeSamplebtn;
		
		
		
		
		// Methods
		
		public void openSamples() {
			wait.until(d -> sampleslbl.isDisplayed());
			WrapClass.click(sampleslbl);
		}

		public boolean verifyExistButton() {
			return WrapClass.verifyElementDisplayed(enterSamplebtn);
		}

		public void searchRowTable(String definition, String status) throws InterruptedException {
			wait.until(d -> searchSample.isDisplayed());
			WrapClass.clearInput(searchSample);
			WrapClass.sendKeys(searchSample, definition);

			String selectedRowPath = "(//*[@id='tbl_scheduledSample']//div[contains(@class, 'tr-group') and .//div[contains(@class, 'content') and contains(text(), '"+ definition +"')] and .//div[contains(@class, 'content') and contains(text(), '"+ status +"')]])[1]";
			wait.until(d -> GlobalVariables.driver.findElement(By.xpath(selectedRowPath)).isEnabled());
			WebElement element = GlobalVariables.driver.findElement(By.xpath(selectedRowPath));
			WrapClass.click(element);
			
		}
		
		public void dinamicSelectedRowTable(String definition, String status) {
			String selectedRowPath = "//*[@id='tbl_scheduledSample']//div[contains(@class, 'tr-group') and .//div[contains(@class, 'content') and contains(text(), '"+ definition +"')] and .//div[contains(@class, 'content') and contains(text(), '"+ status +"')]]";
			wait.until(d -> GlobalVariables.driver.findElement(By.xpath(selectedRowPath)).isEnabled());
			WebElement element = GlobalVariables.driver.findElement(By.xpath(selectedRowPath));
			WrapClass.click(element);
		}
		
		public void openSampleDataPopup(String button) {
			wait.until(d -> GlobalVariables.driver.findElement(By.id(button)).isEnabled());
			WebElement element = GlobalVariables.driver.findElement(By.id(button));
			WrapClass.click(element);
		}
		
		public void dinamicInputStringSample(String element, String value) throws InterruptedException {
			
			WebElement inputElement = GlobalVariables.driver.findElement(By.id(element));
			
			System.out.println(inputElement.getText());
			if(inputElement.getText().toString().equals("")) {
				WrapClass.sendKeysEnter(inputElement, value);
 			}else {
 				WrapClass.clearInput(inputElement);
 				WrapClass.sendKeysEnter(inputElement, "");
 			}
			
			Thread.sleep(1000);
			
				
		}
	
		//Metodo para moverse entre tabs (se usara en seccion de comentarios de sample y caract..)
		public void selectTabIndex(String index) {
			String pathElement = "//div[@data-index='"+index+"']";
			wait.until(d -> GlobalVariables.driver.findElement(By.xpath(pathElement)).isEnabled());
			WebElement element = GlobalVariables.driver.findElement(By.xpath(pathElement));
			WrapClass.click(element);
			
		}
		
		public int getTotalInputs() {
			List<WebElement> elements = GlobalVariables.driver.findElements(By.xpath("//div[@data-row-index='1']//*[@data-column-id[starts-with(., '#')]]"));
			int numberRows = elements.size();
			
			return numberRows;
		}
		 
		
		public int getRowTable() {
			List<WebElement> elements = GlobalVariables.driver.findElements(By.xpath("//*[@data-column-id='characteristic_name']"));
			int columnNumber = elements.size();
			
			return columnNumber - 1;
		}
		
		
		public void SetFilterDS(String value) throws InterruptedException {
			Thread.sleep(2000);
			String xpathValue = "//*[@data-label='"+value+"']";
			WebElement element = GlobalVariables.driver.findElement(By.xpath(xpathValue));
			Thread.sleep(1000);
			WrapClass.click(element);
			
			WebElement submitBtn = GlobalVariables.driver.findElement(By.id("btn_submitF_scheduledSamples"));
			WrapClass.click(submitBtn);
		}
			
		public void saveandClose() throws InterruptedException {
			WrapClass.click(saveSamplebtn);

			if (WrapClass.verifyElementDisplayed(popupMessage)) {
				WrapClass.click(closePopupMessage);
			}

//			if (WrapClass.verifyElementDisplayed(closeProductSet)) {
//				WrapClass.click(closeProductSet);
//			}
		}
		
		public void createSample() {
			wait.until(d -> sampleslbl.isDisplayed());
			WrapClass.click(sampleslbl);
		}
}
	

