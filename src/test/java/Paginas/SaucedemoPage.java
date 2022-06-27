package Paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaucedemoPage {
	//Elementos
	@FindBy(xpath="//input[@id='user-name']")
	WebElement User;
	
	@FindBy(css="#password")
	WebElement Password;

	@FindBy(name="login-button")
	WebElement BtnLogin;

	@FindBy(id="add-to-cart-test.allthethings()-t-shirt-(red)")
	WebElement Producto1;
	
	
	//Constructor
	public SaucedemoPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	
	}
	 public void ProductosPage(WebDriver driver) {	
		  PageFactory.initElements(driver, this);
	}
	//Acciones sobre los elementos
	public void escribirUsuario (String standard_user) {
		User.sendKeys("standard_user");
	}	
	public void escribirPassword (String secret_sauce) {
		Password.sendKeys("secret_sauce");	
	}	
	public void hacerclickLogin() {
		BtnLogin.click();
	}

	public void ElegirProducto() {
		  Producto1.click();
			  
	}	  
}	





