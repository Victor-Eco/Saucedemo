package edit.Tarea5;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Registro {
	
	String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	String driverPath = "..\\\\ProyectoSaucedemo\\Drivers\\chromedriver.exe";
	
	@Test
	
	public void registrarUsuario() {
		System.setProperty("webDriver.chrome.driver", driverPath);
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		//Paso 1: Indicar el correo
		driver.findElement(By.id("email_create")).sendKeys("Ejercicio" + Math.random() + "@mailinator.com");
		
		//Paso 2: hacer click sobre el boton "create an account"
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
		
		// insertar espera hasta que cargue la pagina
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(10)); 
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#id_gender1"))).click();
		
		// completar formulario
		driver.findElement(By.cssSelector("#customer_firstname")).sendKeys("Miguel");
		
		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("Gonzalez");
		
		//Alternativa para ingresar contraseña
	    WebElement txtpassword = driver.findElement(By.name("passwd"));
  	    txtpassword.clear();
  	    txtpassword.sendKeys("123654asf"); 
		
        Select days = new Select (driver.findElement(By.cssSelector("#days")));
        days.selectByValue("11");
        		
        Select months = new Select (driver.findElement(By.cssSelector("#months")));
        months.selectByValue("5");
        
        Select years = new Select (driver.findElement(By.name("years")));
        years.selectByValue("1985"); 
        
        driver.findElement(By.id("newsletter")).click();
        
        driver.findElement(By.name("optin")).click();
        
        driver.findElement(By.cssSelector("#company")).sendKeys("EcoTesting");
        
        driver.findElement(By.id("address1")).sendKeys("477-459 Broadway, New York");
        
        driver.findElement(By.name("address2")).sendKeys("1380");
        
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("new york");
        
        Select id_state = new Select (driver.findElement(By.cssSelector("#id_state")));
        id_state.selectByValue("30");
        
        driver.findElement(By.id("postcode")).sendKeys("10013");
        
        driver.findElement(By.xpath("//textarea[@id='other']")).sendKeys("Asignacion #4 de automatizacion");
        
        driver.findElement(By.name("phone")).sendKeys("+54119999999");
        
        driver.findElement(By.cssSelector("#phone_mobile")).sendKeys("+541147543234");
        
        driver.findElement(By.id("alias")).clear();
        driver.findElement(By.xpath("//input[@id='alias']")).sendKeys("Miguel_Gonzalez123");
        
        driver.findElement(By.xpath("//button[@id='submitAccount']")).click();
        
        
        
        
        
        
        
        
        
        
        
        		
        
        

		
		
	
		
		
		
		
	}

}
