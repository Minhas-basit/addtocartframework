package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reusableContents.AbstractComponents;

public class LandingPage extends AbstractComponents {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail")
	WebElement email;

	@FindBy(id = "userPassword")
	WebElement password;

	@FindBy(id = "login")
	WebElement button;

	public ProductCatalogue loginApplication(String uemail, String upassword) {
		email.sendKeys(uemail);
		password.sendKeys(upassword);
		button.click();
		ProductCatalogue pc = new ProductCatalogue(driver);
		return pc;
	}

	public void gotoApp() {
		driver.get("https://rahulshettyacademy.com/client");
	}

}
