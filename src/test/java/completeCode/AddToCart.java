package completeCode;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseTest;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.ProductCatalogue;

public class AddToCart extends BaseTest {

	@Test(dataProvider = "getData")
	public void cartTest(HashMap<String, String> input) throws IOException, InterruptedException {

		String countryName = "india";

		ProductCatalogue pc = lp.loginApplication(input.get("email"), input.get("password"));

		List<WebElement> products = pc.getProductList();
		pc.addProductToCart(input.get("productName"));
		CartPage cp = pc.gotoCartPage();

		Boolean match = cp.verifyProductDisplay(input.get("productName"));
		Assert.assertTrue(match);
		CheckoutPage cop = cp.gotoCheckout();
		cop.selectCountry(countryName);
		cop.submitOrder();

	}

	@DataProvider
	public Object[][] getData() throws IOException {

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", "bexaj52067@fkcod.com");
		map.put("password", "Basit2119920!@#");
		map.put("productName", "ZARA COAT 3");

		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("email", "rowef29903@padvn.com");
		map1.put("password", "2119920Minhax");
		map1.put("productName", "IPHONE 13 PRO");
		return new Object[][] { { map }, { map1 } };

	}
}
