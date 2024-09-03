package completeCode;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import base.BaseTest;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.ProductCatalogue;

public class AddToCartTestParts extends BaseTest {
	String productName = "ZARA COAT 3";
	String countryName = "india";
	ProductCatalogue pc;

	@Test
	public void login() throws IOException, InterruptedException {
		pc = lp.loginApplication("bexaj52067@fkcod.com", "Basit2119920!@#");
	}

	@Test
	public void addToCartTest() throws InterruptedException {
		List<WebElement> products = pc.getProductList();
		pc.addProductToCart(productName);
		CartPage cp = pc.gotoCartPage();
		Boolean match = cp.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage cop = cp.gotoCheckout();
		cop.selectCountry(countryName);
		cop.submitOrder();
	}
}
