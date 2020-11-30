package StepsDefinition;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Archivo.ArchivoProceso;
import Pages.InicioSesionPage;
import Pages.RegistroUsuarioPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ingresoUsuarioSteps {
	
	static WebDriver driver;
	InicioSesionPage iniciosesionpage;
	ArchivoProceso archivoproceso;
	String Hoja = "RegistroUsuario";

	@BeforeClass
	public static void setupTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Diana\\eclipse-workspace\\Automatizacion\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
	}

	
	@Given("un cliente con correo valido")
	public void un_cliente_con_correo_valido() {	    
	    setupTest();
	    archivoproceso = new ArchivoProceso();
		archivoproceso.leerArchivo(Hoja);
		iniciosesionpage = new InicioSesionPage(driver);
	}

	@When("cuando ingrese informacion valida")
	public void cuando_ingrese_informacion_valida() {	    
	    archivoproceso.getDatos().forEach((data)->{
	    iniciosesionpage.iniciarSesion(data);
	    });
	}

	@Then("inicia sesion de manera exitosa")
	public void inicia_sesion_de_manera_exitosa() {
	    iniciosesionpage.presionarBotonInicio();
	}
	
	@AfterClass
	public static void quitDriver() {
		driver.quit();
	}

}
