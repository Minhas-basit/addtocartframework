package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableContents.AbstractComponents;

public class CartPage extends AbstractComponents {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".totalRow button")
	WebElement checkoutEle;

	@FindBy(css =".cartSection h3" )
	List<WebElement> cartProducts;

	public Boolean verifyProductDisplay(String porductName) {
		Boolean match = cartProducts.stream().anyMatch(cart -> cart.getText().equalsIgnoreCase(porductName));
		return match;
	}

	public CheckoutPage gotoCheckout() {
		checkoutEle.click();
		CheckoutPage cop=new CheckoutPage(driver);
		return cop;

	}
}
