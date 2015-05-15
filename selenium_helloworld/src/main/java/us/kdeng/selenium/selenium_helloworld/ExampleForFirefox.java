package us.kdeng.selenium.selenium_helloworld;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// http://www.open-open.com/lib/view/1354764154148

public class ExampleForFirefox {
	public static void main(String[] argv) {
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		System.out.println("1 Page title is: " + driver.getTitle());
		
		WebDriverWait wait = new WebDriverWait(driver, 4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("q"))));
		
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("neu");
		element.submit();
		
		(new WebDriverWait(driver, 3)).until(
			new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver d) {
	                return d.getTitle().toLowerCase().startsWith("neu");
	            }
			}
		);
		
		System.out.println("2 Page title is: " + driver.getTitle());
		
		driver.quit();
	}
}
