package StepsDefinition;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Archivo.ArchivoProceso;
import Pages.RegistroUsuarioPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class registroUsuarioSteps {
	
	static WebDriver driver;
	RegistroUsuarioPage registroUsuarioPage;
	ArchivoProceso archivoproceso;
	String Hoja = "RegistroUsuario";

	@BeforeClass
	public static void setupTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Diana\\eclipse-workspace\\Automatizacion1\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
	}

	
	@Given("un usuario en el la pagina principal")
	public void un_usuario_en_el_la_pagina_principal() {
		setupTest();	    
		archivoproceso = new ArchivoProceso();
		archivoproceso.leerArchivo(Hoja);
		registroUsuarioPage = new RegistroUsuarioPage(driver);
		
		
	}

	@Given("seleccione el boton crear cuenta con un correo valido")
	public void seleccione_el_boton_crear_cuenta_con_un_correo_valido() {
		archivoproceso.getDatos().forEach((data)->{
			registroUsuarioPage.ingresarCorreo(data);
		}); 
	}

	@When("se muestra el formulario donde se llena la informacion requerida")
	public void se_muestra_el_formulario_donde_se_llena_la_informacion_requerida() {
		archivoproceso.getDatos().forEach((data)->{
			registroUsuarioPage.llenarFormulario(data);
		});   
	}

	@Then("se permite crear el cliente de manera exitosa")
	public void se_permite_crear_el_cliente_de_manera_exitosa() {
	    registroUsuarioPage.registrarUsuario();
		//driver.quit();
	}
	
	@AfterClass
	public static void quitDriver() {
		driver.quit();
	}

}
