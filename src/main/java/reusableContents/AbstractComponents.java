package reusableContents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.CartPage;

public class AbstractComponents {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(css = "button[routerlink='/dashboard/cart']")
	WebElement cartPage;

	public AbstractComponents(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void waitForElementToAppear(By findby) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}

	public void waitForElementToDisappear(WebElement element) throws InterruptedException {
		Thread.sleep(1000);
		// wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		// wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public CartPage gotoCartPage() {
		cartPage.click();
		CartPage cp = new CartPage(driver);
		return cp;
	}
}