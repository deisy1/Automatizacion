package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Archivo.ArchivoRegistro;

public class InicioSesionPage {
	
	private WebDriver driver;
	
	public By linkLogin;	
	public By inputEmail;
	public By inputPassword;
	public By btnSingIn;
	
	public InicioSesionPage(WebDriver driver) {
		this.driver = driver;
		linkLogin = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");
		inputEmail = By.name("email");
		inputPassword = By.id("passwd");
		btnSingIn = By.id("SubmitLogin");		
	}
	
	public void iniciarSesion(ArchivoRegistro datos) {
		driver.findElement(linkLogin).click();
		driver.findElement(inputEmail).sendKeys(datos.getEmail());
		driver.findElement(inputPassword).sendKeys(datos.getPassword());		
	}
	
	public void presionarBotonInicio() {
		driver.findElement(btnSingIn).click();
	}
}
