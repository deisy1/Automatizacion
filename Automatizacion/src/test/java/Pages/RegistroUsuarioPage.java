package Pages;

import org.junit.jupiter.params.shadow.com.univocity.parsers.common.input.InputAnalysisProcess;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import Archivo.ArchivoRegistro;

public class RegistroUsuarioPage {
	private WebDriver driver;
	
	public By linkLogin;	
	public By inputCorreo;
	public By btnCrearCuenta;
	public By checkMs;
	public By inputFirtName;
	public By inputLastName;
	public By inputPassword;
	public By inputNameF;
	public By inputNameL;
	public By inputCompany;
	public By inputAddres;
	public By inputCity;
	public By inputMobil;
	public By inputPostal;
	public By btnRegister;
	
	//Desplegable
	public By selectState;
	public By selectCountry; 
	
	
	
	public RegistroUsuarioPage(WebDriver driver) {
		this.driver = driver;
		
		linkLogin = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");
		inputCorreo = By.id("email_create");
		btnCrearCuenta = By.id("SubmitCreate");
		
		checkMs = By.xpath("//*[@id=\"id_gender1\"]");
		inputFirtName = By.id("customer_firstname");
		inputLastName = By.id("customer_lastname");
		inputPassword = By.id("passwd");
		inputNameF = By.id("firstname");
		inputNameL = By.id("lastname");
		inputAddres = By.id("address1");
		inputCompany = By.id("company");
		inputCity = By.id("city");
		inputPostal = By.id("postcode");
		inputMobil = By.id("phone_mobile");
		btnRegister = By.id("submitAccount");
		
		//Desplegables
		selectState = By.id("id_state");
		selectCountry = By.id("id_country");
		
	}
	
	/*Acciones para ingresar el correo
	 **/
	public void ingresarCorreo(ArchivoRegistro datos) {
		driver.findElement(linkLogin).click();
		driver.findElement(inputCorreo).click();
		System.out.println(datos.getEmail());
		driver.findElement(inputCorreo).sendKeys(datos.getEmail());		
		driver.findElement(btnCrearCuenta).click();
		espera();
	}
	
	/*Acciones formilario registro
	 *Se agrega toda la informacion del archivo en el formulario registro*/
	public void llenarFormulario(ArchivoRegistro datos) {
		espera();
		Select select;
		driver.findElement(checkMs).click();		
		driver.findElement(inputFirtName).sendKeys(datos.getFirtName());
		driver.findElement(inputLastName).sendKeys(datos.getLastName());
		driver.findElement(inputPassword).sendKeys(datos.getPassword());
		driver.findElement(inputNameF).sendKeys(datos.getFname());
		driver.findElement(inputNameL).sendKeys(datos.getLname());
		driver.findElement(inputAddres).sendKeys(datos.getAddres());
		driver.findElement(inputCity).sendKeys(datos.getCity());
		select = new Select(driver.findElement(selectState));		
		select.selectByVisibleText(datos.getState());
		driver.findElement(inputPostal).sendKeys(datos.getZipCode());
//		select = new Select(driver.findElement(selectCountry));		
//		select.selectByVisibleText(datos.getCountry());
		driver.findElement(inputMobil).sendKeys(datos.getMobile());
		
	}
	
	/*Accion Crear Cliente
	 * Se  preesiona el boton Crear Cliente*/
	public void registrarUsuario() {
		driver.findElement(btnRegister).click();
	}
	
	public void espera() {
		try {
			Thread.sleep(2000);			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
