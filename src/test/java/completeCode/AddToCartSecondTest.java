package completeCode;

import java.io.IOException;
import org.testng.annotations.Test;
import base.BaseTest;
import base.Retry;
import pageObjects.ProductCatalogue;

public class AddToCartSecondTest extends BaseTest {

	@Test(retryAnalyzer = Retry.class)
	public void LoginTest() throws IOException, InterruptedException {
		ProductCatalogue pc = lp.loginApplication("bexaj52067@fkcod.com", "Basit2119920!@#");
	}
}
